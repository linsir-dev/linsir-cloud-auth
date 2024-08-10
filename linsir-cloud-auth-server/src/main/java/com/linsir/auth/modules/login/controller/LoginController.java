package com.linsir.auth.modules.login.controller;

import com.linsir.auth.modules.login.service.CaptchaService;
import com.linsir.auth.modules.login.service.LoginService;
import com.linsir.base.core.controller.BaseController;
import com.linsir.base.core.vo.jsonResults.JsonResult;
import com.linsir.base.core.vo.results.R;
import com.linsir.modules.login.dto.LoginParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author linsir
 * @version 1.0.0
 * @title LoginController
 * @description
 * @create 2024/7/22 13:33
 */


@RestController
@RequestMapping("/")
public class LoginController extends BaseController {


    @Autowired
    private CaptchaService captchaService;

    @Autowired
    private LoginService loginService;


    /**
     * 验证码
     * @return
     * @throws Exception
     */
    @GetMapping("captcha")
    public R captcha() throws Exception {
        return exec("验证码",()->{
            return JsonResult.OK(captchaService.getCaptcha());
        });
    }


    public R login(String username,String password) throws Exception {
        return exec("登录",()->{
            return JsonResult.OK(loginService.login(username,password));
        });
    }

}
