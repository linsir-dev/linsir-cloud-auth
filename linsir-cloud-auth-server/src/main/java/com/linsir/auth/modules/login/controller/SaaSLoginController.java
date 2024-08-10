package com.linsir.auth.modules.login.controller;

import com.linsir.modules.login.dto.LoginParams;
import com.linsir.auth.modules.login.service.LoginService;
import com.linsir.base.core.vo.jsonResults.JsonResult;
import com.linsir.base.core.vo.results.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author linsir
 * @version 1.0.0
 * @title SaaSLoginController
 * @description
 * @create 2024/7/28 17:42
 */

@RestController
@RequestMapping("/saas/")
public class SaaSLoginController extends LoginController{

    @Autowired
    private LoginService loginService;

    @PostMapping("login")
    public R login(@RequestBody LoginParams loginParams) throws Exception {
        return exec("saas登录",()->{
           return JsonResult.OK(loginService.saasLogin(loginParams));
        });
    }

    @GetMapping("getUserInfo")
    public R getUserInfo() throws Exception {
        return exec("获取当前用户信息",()->{
            return JsonResult.OK(loginService.getUserInfo());
        });
    }
}
