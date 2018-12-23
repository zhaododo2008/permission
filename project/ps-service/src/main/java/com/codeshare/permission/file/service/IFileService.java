package com.codeshare.permission.file.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by zhaojun on 2018/12/23.
 **/

public interface IFileService {

    /**
     * 通用文件上传接口
     * @param multipartFile
     * @return
     * @throws Exception
     */
    String uploadFile(MultipartFile multipartFile) throws Exception;

}
