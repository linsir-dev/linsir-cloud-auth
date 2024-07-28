package com.linsir.auth.modules.oauth.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.linsir.auth.modules.oauth.dto.LoginData;
import com.linsir.auth.modules.oauth.service.CaptchaService;
import com.linsir.auth.modules.oauth.service.LoginService;
import com.linsir.auth.vo.TokenVO;
import com.linsir.base.core.controller.BaseController;
import com.linsir.base.core.vo.jsonResults.JsonResult;
import com.linsir.base.core.vo.results.R;
import com.linsir.saas.feign.IUerClient;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author linsir
 * @version 1.0.0
 * @title LoginController
 * @description
 * @create 2024/7/22 13:33
 */


@RestController("/auth")
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

}
