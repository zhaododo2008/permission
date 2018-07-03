package com.codeshare.permission.common;


import com.codeshare.common.JsonUtils;
import com.codeshare.permission.common.util.Fn;
import com.codeshare.permission.common.util.Reflections;
import com.codeshare.permission.user.enums.ResourceType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 后端数据转vue需要的数据格式
 *
 * @author cjbi
 */
public class VueBridge<A, B> {

    public <E extends Enum<E>> ArrayList<Map<String, String>> getSelectByEnum(Fn<A, B> fn) {
        ArrayList<Map<String, String>> list = new ArrayList();
        Arrays.asList(Reflections.fnToClass(fn).getEnumConstants()).forEach(e -> {
            Map<String, String> map = new HashMap<>(2);
            map.put("name", Reflections.fnToFieldValue(fn, e));
            map.put("value", e.toString());
            list.add(map);
        });
        return list;
    }

    public static void main(String[] args) {
        VueBridge<ResourceType, String> vueBridge = new VueBridge();
        System.out.println(JsonUtils.obj2json(vueBridge.getSelectByEnum(ResourceType::getInfo)));
    }

}
