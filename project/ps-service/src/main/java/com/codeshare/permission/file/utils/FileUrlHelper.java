package com.codeshare.permission.file.utils;

import org.apache.commons.lang3.StringUtils;

public class FileUrlHelper {
	private final static String domain = "http://mini-erp.ihomefnt.cn/";

	public static String getUrl(String fileName){

		if (StringUtils.isEmpty(fileName)){
			return StringUtils.EMPTY;
		}
		return domain + fileName;
	}

}