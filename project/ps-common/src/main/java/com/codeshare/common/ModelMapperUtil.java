package com.codeshare.common;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaojun on 2018/7/3.
 **/

public class ModelMapperUtil {

    private static ModelMapper modelMapper;

    static{
        modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    public static <D> D strictMap(Object source,Class<D> destinationType){
        return modelMapper.map(source, destinationType);
    }

    public static <D> List<D> strictMapList(Object source, final Class<D> componentType){
        List<D> list= new ArrayList<D>();
        List<Object> objectList = (List<Object>) source;
        for (Object obj : objectList) {
            list.add(modelMapper.map(obj, componentType));
        }
        return list;
    }


}
