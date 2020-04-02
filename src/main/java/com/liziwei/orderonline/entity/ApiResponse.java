package com.liziwei.orderonline.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.liziwei.orderonline.common.enums.ResponseCode;

import java.io.Serializable;

/**
 * @author liziwei
 * @title: ApiResponse
 * @projectName orderonline
 * @description: TODO
 * @date 2020/2/7 23:48
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties({"success"})
public class ApiResponse<T> implements Serializable {

    /**
     * 响应标识
     **/
    private int code;
    /**
     * 响应结果
     */
    private T data;
    /**响应提示*/
    private String msg;
    /**数据长度*/
    private int count;

    private ApiResponse(int code) {
        this.code = code;
    }

    private ApiResponse(int code, T data) {
        this.code = code;
        this.data = data;
    }

    private ApiResponse(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    private ApiResponse(int resultCode, String resultMsg) {
        this.code = resultCode;
        this.msg = resultMsg;
    }

    @JsonIgnore
    public boolean isSuccess() {
        return this.code == ResponseCode.SUCCESS.getCode();
    }

    public int getCode() {
        return code;
    }

    public T getData() {
        return data;
    }

    public String getMsg() {
        return msg;
    }


    public static <T> ApiResponse<T> createBySuccess() {
        return new ApiResponse<>(ResponseCode.SUCCESS.getCode());
    }
    public static <T> ApiResponse<T> adminLogin() {
        return new ApiResponse<>(ResponseCode.ADMIN_LOGIN.getCode(),ResponseCode.ADMIN_LOGIN.getDesc());
    }
    public static <T> ApiResponse<T> userLogin(T result) {
        return new ApiResponse<>(ResponseCode.USER_LOGIN.getCode(),ResponseCode.USER_LOGIN.getDesc(),result);
    }

    public static <T> ApiResponse<T> createBySuccess(String resultMsg) {
        return new ApiResponse<>(ResponseCode.SUCCESS.getCode(), resultMsg);
    }

    public static <T> ApiResponse<T> createBySuccess(T result) {
        return new ApiResponse<>(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getDesc(), result);
    }

    public static <T> ApiResponse<T> createBySuccess(String resultMsg, T result) {
        return new ApiResponse<>(ResponseCode.SUCCESS.getCode(), resultMsg, result);
    }


    public static <T> ApiResponse<T> createByError() {
        return new ApiResponse<>(ResponseCode.ERROR.getCode(), ResponseCode.ERROR.getDesc());
    }


    public static <T> ApiResponse<T> createByError(String errorMessage) {
        return new ApiResponse<>(ResponseCode.ERROR.getCode(), errorMessage);
    }

    public static <T> ApiResponse<T> createByError(int errorCode, String errorMessage) {
        return new ApiResponse<>(errorCode, errorMessage);
    }

//    public static <T> ApiResponse<T> userLoginSuceesee(int)


}
