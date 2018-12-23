package com.codeshare.permission.file.service.impl;

import com.codeshare.permission.file.service.IFileService;
import com.codeshare.permission.file.service.IQiNiuService;
import com.codeshare.permission.file.utils.FileUrlHelper;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * Created by zhaojun on 2018/12/23.
 **/

@Service
public class FileServiceImpl implements IFileService{

    private static final Logger logger = LoggerFactory.getLogger(FileServiceImpl.class);

    @Value("${file.saveDir}")
    private String saveDir;

    @Resource
    private IQiNiuService qiNiuService;

    @Override
    public String uploadFile(MultipartFile multipartFile) throws Exception {

        if (multipartFile.isEmpty()) {
            logger.warn("upload file is empty");
            throw new FileNotFoundException("上传文件为空");
        }

        String fileBodyName = String.format("%s-", System.currentTimeMillis());
        String fileName = fileBodyName + multipartFile.getOriginalFilename().replace(" ", "");
        String localSavePath = saveDir + File.separator + fileName;
        File uploadFile = new File(localSavePath);
        if (!uploadFile.getParentFile().exists()) {
            uploadFile.getParentFile().mkdirs();
        }
        multipartFile.transferTo(uploadFile);

        String md5FileName = md5Key(fileName);
        qiNiuService.fileUpload(uploadFile, md5FileName);
        uploadFile.delete();
        return FileUrlHelper.getUrl(md5FileName);
    }

    private String md5Key(String fileName) {
        String fileExtension = "";
        if (fileName.indexOf(".") > 0) {
            fileExtension = fileName.substring(fileName.indexOf("."));
        }
        return String.format("%d-%s", System.currentTimeMillis(), DigestUtils.md5Hex(fileName) + fileExtension);
    }
}
