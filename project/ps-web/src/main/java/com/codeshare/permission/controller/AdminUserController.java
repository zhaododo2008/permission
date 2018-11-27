package com.codeshare.permission.controller;

import com.codeshare.common.CodeHelperUtil;
import com.codeshare.permission.common.ResponseConstant;
import com.codeshare.permission.common.ResponseVo;
import com.codeshare.permission.common.authz.JwtHelper;
import com.codeshare.permission.user.dto.*;
import com.codeshare.permission.user.service.IUserRoleFacade;
import com.codeshare.permission.user.service.IUserService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Arrays;

/**
 * @author cjbi
 */
@RestController
@RequestMapping("/admin")
@Api(tags="【ps-web】用户接口")
public class AdminUserController {

    @Resource
    private IUserRoleFacade userRoleFacade;

    @Resource
    private IUserService userService;

    @com.wordnik.swagger.annotations.ApiOperation("分页查询系统用户列表")
    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public ResponseVo<UserPageQueryRes> queryUsers(@RequestBody UserQueryReq userQueryReq) {
        return ResponseVo.success(userRoleFacade.queryUserListByPage(userQueryReq));
    }

    @com.wordnik.swagger.annotations.ApiOperation("保存系统用户")
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public ResponseVo saveUser(@RequestBody @Valid UserSaveReq userSaveReq) {
        userRoleFacade.saveUser(userSaveReq);
        return ResponseVo.success();
    }

    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    @com.wordnik.swagger.annotations.ApiOperation("更新系统用户")
    public ResponseVo updateUser(@RequestBody @Valid UserUpdateReq userUpdateReq) {
        userRoleFacade.updateUser(userUpdateReq);
        return ResponseVo.success();
    }

    @RequestMapping(value = "/user", method = RequestMethod.DELETE)
    @com.wordnik.swagger.annotations.ApiOperation("删除系统用户")
    public ResponseVo deleteUser(@RequestBody UserDeleteReq deleteReq) {
        IUser user = JwtHelper.getCurrentUser();

        if (CodeHelperUtil.isNotEmpty(user)){
            boolean isSelf = Arrays.stream(deleteReq.getUserIds().toArray()).anyMatch(id -> id.equals(user.getUserId()));
            if (isSelf) {
                return ResponseVo.failure(ResponseConstant.FAILED_DEL_OWN, ResponseConstant.FAILED_DEL_OWN_MSG);
            }
        }
        deleteReq.getUserIds().forEach(id -> userService.deleteUser(id));
        return ResponseVo.success();
    }

    @RequestMapping(value = "/user/login", method = RequestMethod.POST)
    @com.wordnik.swagger.annotations.ApiOperation("用户登陆")
    public ResponseVo<UserLoginRes> login(@Valid @RequestBody UserLoginReq userLoginReq) throws Exception {
        return ResponseVo.success(userService.login(userLoginReq));
    }


    @RequestMapping(value = "/user/roles", method = RequestMethod.PUT)
    @com.wordnik.swagger.annotations.ApiOperation("修改用户角色")
    public ResponseVo updateRoles(@RequestBody @Valid UserRoleSaveOrUpdateReq userRoleSaveReq) {
        userRoleFacade.saveOrUpdateRoles(userRoleSaveReq);
        return ResponseVo.success();
    }

    @com.wordnik.swagger.annotations.ApiOperation("修改用户密码")
    @RequestMapping(value = "/user/change/password", method = RequestMethod.PUT)
    public ResponseVo changePassword(@RequestBody @Valid ChangePasswordReq changePasswordReq) {
        userService.changePassword(changePasswordReq);
        return ResponseVo.success();
    }

}
