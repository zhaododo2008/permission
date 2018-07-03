package com.codeshare.permission.controller;

import com.codeshare.common.ModelMapperUtil;
import com.codeshare.permission.common.Constants;
import com.codeshare.permission.common.ResponseVo;
import com.codeshare.permission.common.VueBridge;
import com.codeshare.permission.user.dto.*;
import com.codeshare.permission.user.enums.ResourceType;
import com.codeshare.permission.user.service.IResourceFacade;
import com.codeshare.permission.user.service.IResourceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * @author cjbi
 */
@RestController
@RequestMapping("/admin")
@Api(tags="【ps-web】资源接口")
public class AdminResourceController {

    @Resource
    private IResourceService IResourceService;

    @Resource
    private IResourceFacade IResourceFacade;

    @ApiOperation("查询资源列表")
    @RequestMapping(value = "/resources", method = RequestMethod.POST)
    public ResponseVo<ResourceQueryRes> queryResource(@RequestBody ResourceQueryReq resourceQueryReq) {
        return ResponseVo.success(IResourceService.queryList(resourceQueryReq));
    }

    @ApiOperation("查询资源树")
    @RequestMapping(value = "/resource/tree", method = RequestMethod.POST)
    public ResponseVo<ResourceTreeRes> queryResourceTree(@RequestBody ResourceQueryReq resourceQueryReq) {
        List<ResourceQueryRes> list = IResourceService.queryList(resourceQueryReq);
        return ResponseVo.success(getResourceTree(list, Constants.RESOURCE_ROOT_ID));
    }

    private List<ResourceTreeRes> getResourceTree(List<ResourceQueryRes> source, Integer pid) {
        List<ResourceTreeRes> target = getChildResourceByPid(source, pid);
        target.forEach(res -> res.setChildren(getResourceTree(source, res.getId())));
        return target;
    }


    private List<ResourceTreeRes> getChildResourceByPid(List<ResourceQueryRes> source, Integer parentId) {
        List<ResourceTreeRes> child = new ArrayList<>();
        source.forEach(res -> {
            if (parentId.equals(res.getParentId())) {
                child.add(ModelMapperUtil.strictMap(res, ResourceTreeRes.class));
            }
        });
        return child;
    }

    @ApiOperation("新增资源")
    @RequestMapping(value = "/resource", method = RequestMethod.POST)
    public ResponseVo saveResource(@Valid @RequestBody ResourceSaveReq resourceSaveReq) {
        IResourceService.saveResource(resourceSaveReq);
        return ResponseVo.success();
    }

    @ApiOperation("更新资源")
    @RequestMapping(value = "/resource", method = RequestMethod.PUT)
    public ResponseVo updateResource(@Valid @RequestBody ResourceUpdateReq resourceUpdateReq) {
        IResourceService.updateResource(resourceUpdateReq);
        return ResponseVo.success();
    }

    @ApiOperation("删除资源")
    @RequestMapping(value = "/resource/{id}", method = RequestMethod.DELETE)
    public ResponseVo deleteResource(@PathVariable Integer id) {
        IResourceService.deleteResource(id);
        return ResponseVo.success();
    }

    @ApiOperation("查询资源类型")
    @RequestMapping(value = "/resource/types", method = RequestMethod.GET)
    public ResponseVo queryResourceType() {
        VueBridge<ResourceType, String> vueBridge = new VueBridge<>();
        return ResponseVo.success(vueBridge.getSelectByEnum(ResourceType::getInfo));
    }

    @ApiOperation("查询菜单树")
    @RequestMapping(value = "/resource/menus", method = RequestMethod.POST)
    public ResponseVo<MenusRes> queryMenus(@RequestBody @Valid ResourceTreeReq resourceTreeReq) {
        return ResponseVo.success(IResourceFacade.queryMenus(resourceTreeReq));
    }

}
