package com.codeshare.permission.user.service;

import com.codeshare.permission.common.PageResultSet;
import com.codeshare.permission.user.dto.*;

import java.util.List;

/**
 * @author cjbi
 */
public interface IUserService {

    /**
     * 分页查询系统用户列表
     * @param userQueryReq
     * @return
     */
    PageResultSet<UserQueryRes> queryListByPage(UserQueryReq userQueryReq);

    /**
     * 查询用户列表
     * @param userQueryReq
     * @return
     */
    List<UserQueryRes> queryList(UserQueryReq userQueryReq);

    /**
     * 查询总数
     * @param userQueryReq
     * @return
     */
    long queryTotal(UserQueryReq userQueryReq);

    /**
     * 保存系统用户
     * @param userSaveReq
     */
    Integer saveUser(UserSaveReq userSaveReq);

    /**
     * 更新系统用户
     * @param userUpdateReq
     */
    void updateUser(UserUpdateReq userUpdateReq);

    /**
     * 删除系统用户
     * @param userId
     */
    void deleteUser(Integer userId);

    /**
     * 系统用户/设计师用户登陆
     * @param userLoginReq
     */
    UserLoginRes login(UserLoginReq userLoginReq) throws Exception;

    /**
     * 修改用户密码
     * @param changePasswordReq
     */
    void changePassword(ChangePasswordReq changePasswordReq);

}
