package com.codeshare.permission.controller;

import com.codeshare.permission.common.PageResultSet;
import com.codeshare.permission.common.ResponseVo;
import com.codeshare.permission.user.dto.RoleQueryReq;
import com.codeshare.permission.user.dto.RoleQueryRes;
import com.codeshare.permission.user.dto.RoleSaveReq;
import com.codeshare.permission.user.dto.RoleUpdateReq;
import com.codeshare.permission.user.service.IRoleFacade;
import com.codeshare.permission.user.service.IRoleService;
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
@Api(tags="【ps-web】角色接口")
public class AdminRoleController {

    @Resource
    private IRoleService IRoleService;

    @Resource
    private IRoleFacade roleResourceFacade;

    @ApiOperation("查询角色列表")
    @RequestMapping(value = "/roles", method = RequestMethod.POST)
    public ResponseVo<PageResultSet<RoleQueryRes>> queryRoles(@RequestBody RoleQueryReq roleQueryReq) {
        return ResponseVo.success(roleResourceFacade.queryRoleListByPage(roleQueryReq));
    }

    @ApiOperation("查询角色列表")
    @RequestMapping(value = "/roles", method = RequestMethod.GET)
    public ResponseVo<RoleQueryRes> queryRoles() {
        return ResponseVo.success(IRoleService.queryAll());
    }

    @ApiOperation("新增角色")
    @RequestMapping(value = "/role", method = RequestMethod.POST)
    public ResponseVo saveRole(@Valid @RequestBody RoleSaveReq roleSaveReq) {
        IRoleService.saveRole(roleSaveReq);
        return ResponseVo.success();
    }

    @ApiOperation("更新角色")
    @RequestMapping(value = "/role", method = RequestMethod.PUT)
    public ResponseVo updateRole(@Valid @RequestBody RoleUpdateReq roleUpdateReq) {
        IRoleService.updateRole(roleUpdateReq);
        return ResponseVo.success();
    }

    @ApiOperation("批量删除角色")
    @RequestMapping(value = "/role", method = RequestMethod.DELETE)
    public ResponseVo deleteRole(@RequestBody Integer[] ids) {
        Arrays.asList(ids).forEach(id -> IRoleService.deleteRole(id));
        return ResponseVo.success();
    }

}
