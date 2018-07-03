package com.codeshare.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SimpleDateFormatSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by zhaojun on 2018/7/3.
 **/

public class JsonUtils {

    private static SerializeConfig mapping = new SerializeConfig();

    private static final Logger logger = LoggerFactory.getLogger(JsonUtils.class);

    static {
        mapping.put(Date.class, new SimpleDateFormatSerializer("yyyy-MM-dd HH:mm:ss"));
    }

    /**
     * javaBean、list、map convert to json string
     */
    public static String obj2json(Object obj) {
        if (null == obj) {
            return null;
        }
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof Number) {
            return obj.toString();
        }
        if (obj instanceof Class || obj instanceof ApplicationContext) {
            // 无法进行json转换的类型
            return "";
        }
        String jsonStr = "";
        try {
            jsonStr = JSON.toJSONString(obj, mapping);
        } catch (Throwable e) {
            logger.warn("object to json string error {}",e.getMessage(), e);
        }
        return jsonStr;
    }

    /**
     * javaBean、list、map convert to json string
     */
    public static Map<String, Object> obj2map(Object obj) {
        return obj == null ? null : json2map(JSON.toJSONString(obj, mapping));
    }

    /**
     * json string convert to javaBean、map
     */
    public static <T> T json2obj(String jsonStr, Class<T> clazz) {
        if (clazz.equals(String.class)) {
            return (T) jsonStr;
        }
        if (StringUtils.isEmpty(jsonStr)) {
            return null;
        }
        return JSON.parseObject(jsonStr, clazz);
    }

    /**
     * json array string convert to list with javaBean
     */
    public static <T> List<T> json2list(String jsonArrayStr, Class<T> clazz) {
        return JSON.parseArray(jsonArrayStr, clazz);
    }

    /**
     * json string convert to map
     */
    public static <T> Map<String, Object> json2map(String jsonStr) {
        return json2obj(jsonStr, Map.class);
    }

    /**
     * json string convert to map with javaBean
     */
    public static <T> Map<String, T> json2map(String jsonStr, Class<T> clazz) {
        Map<String, T> map = JSON.parseObject(jsonStr, new TypeReference<Map<String, T>>() {
        });
        for (Map.Entry<String, T> entry : map.entrySet()) {
            JSONObject obj = (JSONObject) entry.getValue();
            map.put(entry.getKey(), JSONObject.toJavaObject(obj, clazz));
        }
        return map;
    }
}
