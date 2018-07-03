package com.codeshare.common;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhaojun on 2018/7/3.
 **/

public class ValidationResult {

    /**
     * 校验结果是否有错
     */
    private boolean hasErrors;

    /**
     * 校验错误信息(key:对象属性名,value:错误信息)
     */
    private Map<String,String> errorMsg;

    public boolean isHasErrors() {
        return hasErrors;
    }

    public void setHasErrors(boolean hasErrors) {
        this.hasErrors = hasErrors;
    }

    /**
     * 校验错误信息(key:对象属性名,value:错误信息)
     * @return
     * @author：Ivan
     * @date：2016年2月1日 下午7:46:37
     */
    public Map<String, String> getErrorMsg() {
        return errorMsg;
    }

    /**
     * 获取Json错误信息
     * <br/>便于接口返回
     * @return
     * @author Ivan
     * @date 2016年7月19日 下午2:50:14
     */
    public String getErrorMsgJson(){
        if(errorMsg!=null){
            return JsonUtils.obj2json(errorMsg);
        }else{
            return "";
        }
    }

    public void setErrorMsg(Map<String, String> errorMsg) {
        this.errorMsg = errorMsg;
    }

    /**
     * 添加错误信息
     * (业务逻辑判断时使用)
     * @param key 属性名
     * @param value 错误信息
     * @author Ivan
     * @date 2016年6月3日 上午10:49:19
     */
    public void addError(String key,String value){
        hasErrors=true;
        if(errorMsg==null){
            errorMsg = new HashMap<String, String>();
        }
        errorMsg.put(key, value);
    }

    @Override
    public String toString() {
        return "ValidationResult [hasErrors=" + hasErrors + ", errorMsg="
                + errorMsg + "]";
    }
}
