package com.liziwei.orderonline.common.enums;

/**
 * 响应标识
 * @author liziwei
 * @title: ResponseCode
 * @projectName orderonline
 * @description: TODO
 * @date 2020/2/7 23:54
 */
public enum  ResponseCode {
    SUCCESS(0,"Success"),
    USER_LOGIN(2,"用户登录成功"),
    ADMIN_LOGIN(3,"管理员登陆成功"),
    ERROR(1,"Error"),
    PARAM_ERROR(400,"Param Error");

    private final int code;
    private final String desc;

    ResponseCode(int code,String desc){
        this.code = code;
        this.desc = desc;
    }
    public int getCode(){
        return code;
    }
    public String getDesc(){
        return desc;
    }

}
