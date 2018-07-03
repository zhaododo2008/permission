package com.codeshare.permission.common;


import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * 分页返回
 * @author cjbi
 */
public class PageResultSet<T> {

    public static final PageResultSet EMPTY_RESULT = new PageResultSet<>();

    private long total;

    private List<T> rows;

    public PageResultSet() {
        super();
        rows = new ArrayList<>(10);
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public void addRow(T obj) {
        rows.add(obj);
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
