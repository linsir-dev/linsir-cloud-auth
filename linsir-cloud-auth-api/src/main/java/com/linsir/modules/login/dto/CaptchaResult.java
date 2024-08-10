package com.linsir.modules.login.dto;

import lombok.Builder;
import lombok.Data;

/**
 * @author linsir
 * @version 1.0.0
 * @title CaptchaResult
 * @description
 * @create 2024/7/22 23:20
 */
@Builder
@Data
public class CaptchaResult {
    private String captchaKey;

    private String captchaBase64;

}
