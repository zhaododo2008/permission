package com.codeshare.permission.common;

import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.io.Serializable;

/**
 * @author cjbi
 */
public class BasePageRequest implements Serializable {

    @ApiModelProperty("分页数")
    private Integer pageSize;
    @ApiModelProperty("第几页")
    private Integer pageNo;
    @ApiModelProperty("排序，示例：id desc或者id、id asc")
    private String orderBy;

    public Integer getLimit() {
        return pageSize;
    }

    public Integer getOffset() {
        if (pageSize == null) {
            return null;
        }
        return pageSize * (pageNo - 1);
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
