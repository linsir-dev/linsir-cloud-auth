package com.linsir.modules.login.vo;

import lombok.Data;

/**
 * @author linsir
 * @version 1.0.0
 * @title TokenVO
 * @description
 * @create 2024/7/24 3:19
 */

@Data
public class TokenVO {

    private String tokenType;

    private String accessToken;
}
