package com.linsir.auth.modules.login.controller;

import com.linsir.auth.modules.login.service.CaptchaService;
import com.linsir.auth.modules.login.service.LoginService;
import com.linsir.base.core.vo.jsonResults.JsonResult;
import com.linsir.base.core.vo.results.R;
import com.linsir.modules.login.dto.LoginData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author linsir
 * @version 1.0.0
 * @title AuthLoginController
 * @description
 * @create 2024/7/28 18:57
 */

@RestController
@RequestMapping("/auth/")
public class AuthLoginController extends LoginController{

    @Autowired
    private CaptchaService captchaService;


    @Autowired
    private LoginService loginService;


    @PostMapping("login")
    public R login(LoginData loginData) throws Exception {
        return exec("auth 登录",()->{
           return JsonResult.OK(loginService.authLogin(loginData));
        });
    }

    @GetMapping("getUserInfo")
    public R getUserInfo() throws Exception {
        return exec("获取用户信息",()->{
            return JsonResult.OK(loginService.getAuthUserInfo());
        });
    }


    @DeleteMapping("logout")
    public R logout() throws Exception {
        return exec("推出",()->{
           loginService.logout();
            return JsonResult.OK();
        });
    }

}
