package com.linsir.auth.code;

import com.linsir.base.core.code.ICode;

/**
 * @author linsir
 * @version 1.0.0
 * @title AuthCode
 * @description
 * @create 2024/7/29 1:10
 */


public enum AuthCode implements ICode,Cloneable{


    AUTH_USER_NOT_EXIST(415,"用户不存在",Boolean.TRUE),
    AUTH_TOKEN_NOT_GET(416,"无法获取token",Boolean.TRUE),
    ;
    private  int code;
    private String msg;
    private Boolean status;

    AuthCode(int code, String msg, Boolean status) {
        this.code =code;
        this.msg = msg;
        this.status = status;
    }


    @Override
    public int getCode() {
        return this.code;
    }

    @Override
    public String getMsg() {
        return this.msg;
    }

    @Override
    public boolean status() {
        return this.status;
    }

    @Override
    public void setMessage(String message) {
        this.msg = message;
    }

    @Override
    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public void setStatus(boolean status) {
        this.status = status;
    }


}
