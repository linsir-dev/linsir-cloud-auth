package com.linsir.auth.config;

import cn.dev33.satoken.context.SaHolder;
import cn.dev33.satoken.context.model.SaRequest;
import cn.dev33.satoken.oauth2.config.SaOAuth2Config;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import com.linsir.base.core.code.BaseCode;
import com.linsir.base.core.vo.jsonResults.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.http.HttpRequest;
import java.util.function.Supplier;

/**
 * @author linsir
 * @version 1.0.0
 * @title SaOAuth2ServerConfig
 * @description
 * @create 2024/7/22 1:08
 */


@Slf4j
@Configuration
public class SaOAuth2ServerConfig {


   @Bean
   public Supplier<Object> notLoginView()
   {

       return null;
   }



    @Bean
    public SaOAuth2Config saOAuth2Config()
    {
        SaOAuth2Config config = new SaOAuth2Config();
        config
                .setNotLoginView(()->{
                    SaRequest request =  SaHolder.getRequest();
                    log.error(request.getUrl());
                    log.error(request.getParam("response_type"));
                    log.error(request.getParam("client_id"));
                    log.error(request.getParam("redirect_uri"));
                    return new JsonResult<>(BaseCode.FAIL_AUTHENTICATION);
                })
                .setDoLoginHandle((name, pwd) -> {
                    if("sa".equals(name) && "123456".equals(pwd)) {
                        StpUtil.login(10001);
                        return SaResult.ok();
                    }
                    return SaResult.error("账号名或密码错误");
                }).setConfirmView((clientId, scope) -> {
                    String msg = "<p>应用 " + clientId + " 请求授权：" + scope + "</p>"
                            + "<p>请确认：<a href='/oauth2/doConfirm?client_id=" + clientId + "&scope=" + scope + "' target='_blank'> 确认授权 </a></p>"
                            + "<p>确认之后刷新页面</p>";
                    return msg;});
        return config;
    }
}
