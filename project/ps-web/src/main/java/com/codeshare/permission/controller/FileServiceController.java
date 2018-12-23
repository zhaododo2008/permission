package com.codeshare.permission.controller;

import com.codeshare.permission.common.ApiResponse;
import com.codeshare.permission.common.ResponseVo;
import com.codeshare.permission.file.service.IFileService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * Created by zhaojun on 2018/12/23.
 **/

@Api("【通用】文件接口")
@RequestMapping("/file")
@Controller
public class FileServiceController {

    private static final Logger logger = LoggerFactory.getLogger(FileServiceController.class);

    @Resource
    private IFileService uploadService;

    @ApiOperation("通用文件上传接口")
    @RequestMapping(value = "/uploadFile",method = RequestMethod.POST)
    @ApiParam(value = "上传的文件", required = true)
    @ResponseBody
    public ResponseVo uploadSku(@RequestParam(value = "file") MultipartFile file) {
        try {
            String imgUrl = uploadService.uploadFile(file);
            return ApiResponse.success("上传成功", imgUrl);
        } catch (Exception e) {
            logger.info("upload file fail,fileName {} ", file.getOriginalFilename(), e);
            return ApiResponse.fail(2, "上传失败，" + e.getMessage());
        }
    }
}
