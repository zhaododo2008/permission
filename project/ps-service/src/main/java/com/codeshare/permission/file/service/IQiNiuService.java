package com.codeshare.permission.file.service;

import java.io.File;

/**
 * Created by zhaojun on 2018/12/23.
 **/

public interface IQiNiuService {

    /**
     * 上传模型文件
     * @param file
     * @param fileName
     * @throws Exception
     */
    void fileUpload(File file, String fileName) throws Exception;
}
