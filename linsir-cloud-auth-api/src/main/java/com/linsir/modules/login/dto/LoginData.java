package com.linsir.modules.login.dto;

import lombok.Data;

/**
 * @author linsir
 * @version 1.0.0
 * @title LoginData
 * @description
 * @create 2024/7/24 3:11
 */

@Data
public class LoginData {

    private String username;

    private String password;

    private String captchaKey;

    public  String captchaCode;
}
