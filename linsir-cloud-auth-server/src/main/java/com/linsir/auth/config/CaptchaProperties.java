package com.linsir.auth.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author linsir
 * @version 1.0.0
 * @title CaptchaProperties
 * @description
 * @create 2024/7/23 2:10
 */
@Component
@ConfigurationProperties(prefix = "captcha")
@Data
public class CaptchaProperties {

    /**
     * 验证码类型  circle-圆圈干扰验证码|gif-Gif验证码|line-干扰线验证码|shear-扭曲干扰验证码
     */
    private String type;

    /**
     * 验证码图片宽度
     */
    private int width;
    /**
     * 验证码图片高度
     */
    private int height;

    /**
     * 干扰线数量
     */
    private int interfereCount;

    /**
     * 文本透明度
     */
    private Float textAlpha;

    /**
     * 验证码过期时间，单位：秒
     */
    private Long expireSeconds;

    /**
     * 验证码字符配置
     */
    //private CodeProperties code;

    /**
     * 验证码字体
     */
    //private FontProperties font;
}
