package com.linsir.auth.modules.oauth.service;

import com.linsir.auth.config.CaptchaProperties;
import com.linsir.auth.modules.oauth.dto.CaptchaResult;

/**
 * @author linsir
 * @version 1.0.0
 * @title CaptchaService
 * @description
 * @create 2024/7/22 23:17
 */


public interface CaptchaService {

   CaptchaResult getCaptcha();

   CaptchaResult getCaptcha(CaptchaProperties captchaProperties);
}
