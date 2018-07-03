package com.codeshare.permission.user.dto;

import com.codeshare.permission.user.enums.Source;

import java.io.Serializable;

/**
 * @author cjbi
 */
public interface IUser extends Serializable {
    /**
     * 用户Id
     * @return
     */
    Integer getUserId();

    /**
     * 用户名
     * @return
     */
    String getUsername();

    /**
     * 用户来源
     * @return
     */
    Source getSource();


}
