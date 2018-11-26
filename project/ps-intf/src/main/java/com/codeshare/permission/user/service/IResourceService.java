package com.codeshare.permission.user.service;

import com.codeshare.permission.user.dto.ResourceQueryReq;
import com.codeshare.permission.user.dto.ResourceQueryRes;
import com.codeshare.permission.user.dto.ResourceSaveReq;
import com.codeshare.permission.user.dto.ResourceUpdateReq;

import java.util.List;
import java.util.Set;

/**
 * 资源接口
 * @author cjbi
 */
public interface IResourceService {

    /**
     * 查询资源列表
     * @param resourceQueryReq
     * @return
     */
    List<ResourceQueryRes> queryList(ResourceQueryReq resourceQueryReq);

    /**
     * 根据id查询资源
     * @param id
     * @return
     */
    ResourceQueryRes queryResourceById(Integer id);

    /**
     * 保存资源
     * @param resourceSaveReq
     */
    void saveResource(ResourceSaveReq resourceSaveReq);

    /**
     * 更新资源
     * @param resourceUpdateReq
     */
    void updateResource(ResourceUpdateReq resourceUpdateReq);

    /**
     * 删除资源
     * @param id
     */
    void deleteResource(Integer id);

    /**
     * 查询用户资源
     * @param resourceIds
     * @return
     */
    List<ResourceQueryRes> queryList(Set<Integer> resourceIds);

    /**
     * 根据父资源id查询子资源
     * @param parentIds
     * @return
     */
    List<ResourceQueryRes> queryListByParentIds(String parentIds);

    /**
     * 根据用户权限得到菜单
     * @param permissions
     * @return
     */
    List<ResourceQueryRes> queryMenus(Set<String> permissions);

}
