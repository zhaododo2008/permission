package com.codeshare.permission.file.service.impl;

import com.codeshare.permission.file.service.IQiNiuService;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;

/**
 * Created by zhaojun on 2018/12/23.
 **/

@Service
public class QiNiuServiceImpl implements IQiNiuService {

    private static final Logger logger = LoggerFactory.getLogger(QiNiuServiceImpl.class);

    @Value("${qiniu.accesskey:ry31AVn3xS-lvL67tIu9BGqDy6KRdPHE7LUnc8eC}")
    private String accessKey;

    @Value("${qiniu.secretkey:czHdCDhkillbpQ1DYliKYOe-kUKAe9A4A5jMemwL}")
    private String secretKey;

    private Auth auth;

    @PostConstruct
    public void init() {
        auth = Auth.create(accessKey, secretKey);
    }

    private String getBucket(){
        return "mini-erp";
    }

    /**
     * 返回七牛的上传token
     * @param bucket
     * @return
     */
    private String getUploadToken(String bucket) {
        String token = auth.uploadToken(bucket);
        logger.info("get accessKey,secretKey,token. accessKey={},secretKey={},token={}", accessKey, secretKey, token);
        logger.debug("get upload token: " + token);
        return token;
    }

    @Override
    public void fileUpload(File file, String fileName) throws Exception {

        Response res;
        UploadManager uploadManager = new UploadManager(new Configuration());
        try {
            res = uploadManager.put(file, fileName, getUploadToken(getBucket()));
        } catch (QiniuException e) {
            logger.error("file upload fail, fileName {}", fileName, e);
            throw new Exception("file upload fail,error message is" + e.getMessage());
        }

        if (res.isOK()) {
            logger.info("file upload success, fileName {}",fileName);
            logger.info("res is {}",res);
        } else {
            logger.error("file upload fail, return error {}, fileName {}",res.error,fileName);
            throw new Exception("file upload fail, return error " + res.error);
        }

    }
}
