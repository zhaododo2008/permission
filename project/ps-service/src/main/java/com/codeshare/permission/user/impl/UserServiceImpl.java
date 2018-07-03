package com.codeshare.permission.user.impl;

import com.codeshare.common.JsonUtils;
import com.codeshare.common.ModelMapperUtil;
import com.codeshare.permission.common.Constants;
import com.codeshare.permission.common.PageResultSet;
import com.codeshare.permission.common.ResponseConstant;
import com.codeshare.permission.common.authz.JwtHelper;
import com.codeshare.permission.common.exception.BusinessException;
import com.codeshare.permission.common.util.PasswordUtil;
import com.codeshare.permission.user.dao.UserDao;
import com.codeshare.permission.user.dto.*;
import com.codeshare.permission.user.enums.Source;
import com.codeshare.permission.user.po.User;
import com.codeshare.permission.user.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * 用户服务接口
 *
 * @author cjbi
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public PageResultSet<UserQueryRes> queryListByPage(UserQueryReq userQueryReq) {
        if (userQueryReq.getPageNo() == null) {
            userQueryReq.setPageNo(Constants.DEFAULT_PAGE_NUM);
        }
        if (userQueryReq.getPageSize() == null) {
            userQueryReq.setPageSize(Constants.DEFAULT_PAGE_SIZE);
        }
        List<User> list = userDao.selectList(userQueryReq);
        if (list == null) {
            return PageResultSet.EMPTY_RESULT;
        }
        PageResultSet<UserQueryRes> pageResultSet = new PageResultSet<>();
        long total = userDao.countList(userQueryReq);
        ModelMapperUtil.strictMapList(list, UserQueryRes.class);
        pageResultSet.setRows(ModelMapperUtil.strictMapList(list, UserQueryRes.class));
        pageResultSet.setTotal(total);
        return pageResultSet;
    }

    @Override
    public List<UserQueryRes> queryList(UserQueryReq userQueryReq) {
        List<User> list = userDao.selectList(userQueryReq);
        if (list == null) {
            return Collections.EMPTY_LIST;
        }
        return ModelMapperUtil.strictMapList(list, UserQueryRes.class);
    }

    @Override
    public long queryTotal(UserQueryReq userQueryReq) {
        return userDao.countList(userQueryReq);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer saveUser(UserSaveReq userSaveReq) {
        UserQueryReq selectByUsername = new UserQueryReq();
        selectByUsername.setUsername(userSaveReq.getUsername());
        if (Optional.ofNullable(userDao.selectOne(selectByUsername)).isPresent()) {
            throw new BusinessException(ResponseConstant.DB_INSERT_ERROR, "用户名已存在");
        }
        UserQueryReq selectByPhone = new UserQueryReq();
        selectByPhone.setPhone(userSaveReq.getPhone());
        if (Optional.ofNullable(userDao.selectOne(selectByPhone)).isPresent()) {
            throw new BusinessException(ResponseConstant.DB_INSERT_ERROR, "手机号已存在");
        }
        UserQueryReq selectByEmail = new UserQueryReq();
        selectByEmail.setEmail(userSaveReq.getEmail());
        if (Optional.ofNullable(userDao.selectOne(selectByEmail)).isPresent()) {
            throw new BusinessException(ResponseConstant.DB_INSERT_ERROR, "邮箱已存在");
        }
        User user = ModelMapperUtil.strictMap(userSaveReq, User.class);
        user.setPassword(PasswordUtil.generate(Constants.DEFAULT_PASSWORD));
        int rows = userDao.insertSelective(user);
        if (rows == 0) {
            throw new BusinessException(ResponseConstant.DB_INSERT_ERROR, ResponseConstant.DB_INSERT_ERROR_MSG);
        }
        return user.getId();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateUser(UserUpdateReq userUpdateReq) {
        UserQueryReq selectByUsername = new UserQueryReq();
        selectByUsername.setUsername(userUpdateReq.getUsername());
        if (Optional.ofNullable(userDao.selectOne(selectByUsername)).filter(user -> !user.getId().equals(userUpdateReq.getId())).isPresent()) {
            throw new BusinessException(ResponseConstant.DB_UPDATE_ERROR, "用户名已存在");
        }
        UserQueryReq selectByPhone = new UserQueryReq();
        selectByPhone.setPhone(userUpdateReq.getPhone());
        if (Optional.ofNullable(userDao.selectOne(selectByPhone)).filter(user -> !user.getId().equals(userUpdateReq.getId())).isPresent()) {
            throw new BusinessException(ResponseConstant.DB_UPDATE_ERROR, "手机号已存在");
        }
        UserQueryReq selectByEmail = new UserQueryReq();
        selectByEmail.setEmail(userUpdateReq.getEmail());
        if (Optional.ofNullable(userDao.selectOne(selectByEmail)).filter(user -> !user.getId().equals(userUpdateReq.getId())).isPresent()) {
            throw new BusinessException(ResponseConstant.DB_UPDATE_ERROR, "邮箱已存在");
        }
        userUpdateReq.setPassword(null);
        User user = ModelMapperUtil.strictMap(userUpdateReq, User.class);
        int rows = userDao.updateByPrimaryKeySelective(user);
        if (rows == 0) {
            throw new BusinessException(ResponseConstant.DB_UPDATE_ERROR, ResponseConstant.DB_UPDATE_ERROR_MSG);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteUser(Integer userId) {
        int rows = userDao.deleteByPrimaryKey(userId);
        if (rows == 0) {
            throw new BusinessException(ResponseConstant.DB_DELETE_ERROR, ResponseConstant.DB_DELETE_ERROR_MSG);
        }
    }

    @Override
    public UserLoginRes login(UserLoginReq userLoginReq) throws Exception {
        User user = userDao.selectLoginUser(userLoginReq.getUsername());
        if (user == null) {
            throw new BusinessException("用户名/密码错误");
        }
        if (Boolean.TRUE.equals(user.getLocked())) {
            throw new BusinessException("帐号锁定");
        }
        if (!PasswordUtil.verify(userLoginReq.getPassword(), user.getPassword())) {
            throw new BusinessException("用户名/密码错误");
        }
        UserLoginRes userLoginRes = new UserLoginRes();
        userLoginRes.setUser(ModelMapperUtil.strictMap(user, UserQueryRes.class));
        //设置token
        userLoginRes.setToken(JwtHelper.createJWT(userLoginRes.getUser().getUserId().toString()
                , JsonUtils.obj2json(userLoginRes.getUser())
                , Constants.JWT_TTL));
        return userLoginRes;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void changePassword(ChangePasswordReq changePasswordReq) {
        if (changePasswordReq.getSource() != Source.dr_admin) {
            throw new BusinessException("只支持系统用户密码修改");
        }
        User user = userDao.selectByPrimaryKey(changePasswordReq.getUserId());
        user.setPassword(PasswordUtil.generate(changePasswordReq.getNewPassword()));
        userDao.updateByPrimaryKeySelective(user);
    }
}
