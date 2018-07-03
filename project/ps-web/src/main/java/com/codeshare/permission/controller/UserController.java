package com.codeshare.permission.controller;

import com.codeshare.common.ModelMapperUtil;
import com.codeshare.permission.req.PermissionReq;
import com.codeshare.permission.req.UserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cglib.core.CollectionUtils;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zhaojun on 2018/7/2.
 **/

@Controller
@RequestMapping("/person")
@Api(tags="个人业务")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);


    @RequestMapping(value="/getPerson",method= RequestMethod.GET)
    @ApiOperation(httpMethod = "GET", value = "个人信息", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody UserVo getPersons() {
        UserVo person = new UserVo();
        person.setCompoundId(1);
        person.setCompoundName("中国");

        PermissionReq permissionReq = ModelMapperUtil.strictMap(person, PermissionReq.class);

        logger.info("permissionReq is {}",permissionReq);


        return person;
    }
}
