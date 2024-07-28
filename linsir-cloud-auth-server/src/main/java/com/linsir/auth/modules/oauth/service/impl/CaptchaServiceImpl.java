package com.linsir.auth.modules.oauth.service.impl;

import cn.hutool.captcha.AbstractCaptcha;
import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.generator.CodeGenerator;
import cn.hutool.core.util.IdUtil;
import com.linsir.auth.config.CaptchaProperties;
import com.linsir.auth.modules.oauth.dto.CaptchaResult;
import com.linsir.auth.modules.oauth.service.CaptchaService;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.concurrent.TimeUnit;

/**
 * @author linsir
 * @version 1.0.0
 * @title CaptchaServiceImpl
 * @description
 * @create 2024/7/23 1:43
 */
@Service
public class CaptchaServiceImpl implements CaptchaService {

    private CodeGenerator codeGenerator;

    private  Font captchaFont;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

   public CaptchaServiceImpl()
   {
       this.codeGenerator = new CodeGenerator() {
           @Override
           public String generate() {
               return "54415";
           }

           @Override
           public boolean verify(String code, String userInputCode) {
               return false;
           }
       };

       this.captchaFont = new Font("SansSerif",1,20);

   }


    @Override
    public CaptchaResult getCaptcha() {

        String captchaType = "circle";  //验证码类型 circle-圆圈干扰验证码|gif-Gif验证码|line-干扰线验证码|shear-扭曲干扰验证码
        int width = 120; //# 验证码宽度
        int height = 40;//# 验证码高度
        int interfereCount = 2; // 验证码干扰元素个数
        int codeLength =2; //验证码字符长度，type=算术时，表示运算位数(1:个位数 2:十位数)；type=随机字符时，表示字符个数

        AbstractCaptcha captcha =  CaptchaUtil.createCircleCaptcha(width, height, codeLength, interfereCount);

        captcha.setGenerator(codeGenerator);
        captcha.setTextAlpha(0.8f); //# 文本透明度(0.0-1.0)
        captcha.setFont(captchaFont); //# 字体名称 Dialog|DialogInput|Monospaced|Serif|SansSerif

        String captchaCode = captcha.getCode();
        String imageBase64Data = captcha.getImageBase64();

        // 验证码文本缓存至Redis，用于登录校验
        String captchaKey = IdUtil.fastSimpleUUID();

        stringRedisTemplate.opsForValue().set("Captcha:" + captchaKey, captchaCode,
                3600, TimeUnit.SECONDS);

        return CaptchaResult.builder()
                .captchaKey(captchaKey)
                .captchaBase64(imageBase64Data)
                .build();
    }

    @Override
    public CaptchaResult getCaptcha(CaptchaProperties captchaProperties) {
        return null;
    }

}
