package com.codeshare.permission.controller;

import com.codeshare.permission.common.Constants;
import com.codeshare.permission.common.ResponseConstant;
import com.codeshare.permission.common.ResponseVo;
import com.codeshare.permission.user.dto.*;
import com.codeshare.permission.user.service.IUserRoleFacade;
import com.codeshare.permission.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
    private IUserRoleFacade IUserRoleFacade;

    @Resource
    private UserService userService;

    @ApiOperation("分页查询系统用户列表")
    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public ResponseVo<UserPageQueryRes> queryUsers(@RequestBody UserQueryReq userQueryReq) {
        return ResponseVo.success(IUserRoleFacade.queryUserListByPage(userQueryReq));
    }

    @ApiOperation("保存系统用户")
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public ResponseVo saveUser(@RequestBody @Valid UserSaveReq userSaveReq) {
        IUserRoleFacade.saveUser(userSaveReq);
        return ResponseVo.success();
    }

    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    @ApiOperation("更新系统用户")
    public ResponseVo updateUser(@RequestBody @Valid UserUpdateReq userUpdateReq) {
        IUserRoleFacade.updateUser(userUpdateReq);
        return ResponseVo.success();
    }

    @RequestMapping(value = "/user", method = RequestMethod.DELETE)
    @ApiOperation("删除系统用户")
    public ResponseVo deleteUser(@RequestBody Integer[] ids) {
        Arrays.asList(ids).forEach(id -> userService.deleteUser(id));
        return ResponseVo.success();
    }

    @RequestMapping(value = "/user/login", method = RequestMethod.POST)
    public ResponseVo<UserLoginRes> login(@Valid @RequestBody UserLoginReq userLoginReq) throws Exception {
        return ResponseVo.success(userService.login(userLoginReq));
    }


    @RequestMapping(value = "/designer/roles/sync", method = RequestMethod.POST)
    public ResponseVo syncUserRole(String verify) {
        if (!Constants.VERIFY.equalsIgnoreCase(verify)) {
            return ResponseVo.failure(ResponseConstant.PARAM_ERROR, ResponseConstant.PARAM_ERROR_MSG);
        }
        IUserRoleFacade.syncUserRole();
        return ResponseVo.success();
    }

    @RequestMapping(value = "/user/roles", method = RequestMethod.PUT)
    @ApiOperation("修改用户角色")
    public ResponseVo updateRoles(@RequestBody @Valid UserRoleSaveReq userRoleSaveReq) {
        IUserRoleFacade.updateRoles(userRoleSaveReq);
        return ResponseVo.success();
    }

    @RequestMapping(value = "/user/permissions", method = RequestMethod.POST)
    @ApiOperation("查询用户权限")
    public ResponseVo queryPermissions(@Valid @RequestBody PermissionsQueryReq permissionsQueryReq) {
        return ResponseVo.success(IUserRoleFacade.queryPermissions(permissionsQueryReq));
    }

    @ApiOperation("修改用户密码")
    @RequestMapping(value = "/user/change/password",method = RequestMethod.PUT)
    public ResponseVo changePassword(@RequestBody @Valid ChangePasswordReq changePasswordReq) {
        userService.changePassword(changePasswordReq);
        return ResponseVo.success();
    }

}
