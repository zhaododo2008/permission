package com.codeshare.permission.common;


import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.util.ArrayList;
import java.util.List;


/**
 * @author zhaojun
 */
public class ReactPageResultSet<T> {

    public static final ReactPageResultSet EMPTY_RESULT = new ReactPageResultSet<>();

    private ReactPagination pagination;

    private List<T> list;

    public ReactPageResultSet() {
        super();
        list = new ArrayList<>(10);
        pagination = new ReactPagination(0,10,1);
    }

    public static ReactPageResultSet getEmptyResult() {
        return EMPTY_RESULT;
    }

    public ReactPagination getPagination() {
        return pagination;
    }

    public void setPagination(ReactPagination pagination) {
        this.pagination = pagination;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public void addRow(T obj) {
        list.add(obj);
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
