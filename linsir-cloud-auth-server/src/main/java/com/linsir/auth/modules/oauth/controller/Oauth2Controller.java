package com.linsir.auth.modules.oauth.controller;

import cn.dev33.satoken.context.SaHolder;
import cn.dev33.satoken.oauth2.logic.SaOAuth2Handle;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author linsir
 * @version 1.0.0
 * @title TobTokenController
 * @description
 * @create 2024/7/19 16:00
 */

@RestController
public class Oauth2Controller {

    @RequestMapping("/oauth2/*")
    public Object request() {
        System.out.println("------- 进入请求: " + SaHolder.getRequest().getUrl());
        return SaOAuth2Handle.serverRequest();
    }

}
