package com.codeshare.permission.common;

/**
 * Created by zhaojun on 2018/11/26.
 **/

public class ReactPagination {

    public ReactPagination(long total,long pageSize,long current){
        this.total =total;
        this.pageSize = pageSize;
        this.current = current;
    }

    /**
     * 总数
     */
    private long total;

    /**
     * 每页页数
     */
    private long pageSize;

    /**
     * 当前页
     */
    private long current;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public long getPageSize() {
        return pageSize;
    }

    public void setPageSize(long pageSize) {
        this.pageSize = pageSize;
    }

    public long getCurrent() {
        return current;
    }

    public void setCurrent(long current) {
        this.current = current;
    }
}
