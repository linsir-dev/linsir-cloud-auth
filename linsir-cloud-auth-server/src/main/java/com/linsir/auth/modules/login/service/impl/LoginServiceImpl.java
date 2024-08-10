package com.linsir.auth.modules.login.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.linsir.auth.code.AuthCode;
import com.linsir.auth.exception.AuthException;
import com.linsir.auth.modules.login.service.CaptchaService;
import com.linsir.auth.modules.login.service.LoginService;
import com.linsir.modules.login.dto.LoginData;
import com.linsir.modules.login.dto.LoginParams;
import com.linsir.modules.login.vo.AuthUserInfo;
import com.linsir.modules.login.vo.SaaSUserInfo;
import com.linsir.modules.login.vo.TokenVO;
import com.linsir.saas.modules.rabc.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author linsir
 * @version 1.0.0
 * @title LoginServiceImpl
 * @description
 * @create 2024/7/19 16:01
 */

@Slf4j
@Service
public class LoginServiceImpl implements LoginService {


    @Autowired
    private CaptchaService captchaService;


    @Override
    public UserVO isUser(String username, String password) {
        boolean flag = false;
        /*
        * 调用 saas 服务判断信息
        * */
        UserVO userVO = new UserVO();
        if (userVO==null) {
            throw AuthException.authException(AuthCode.AUTH_USER_NOT_EXIST);
        }

        if (Objects.equals(username, "admin") || Objects.equals(password, "123456")) {
            userVO.setId(11111L);
            userVO.setAccount(username);
        }
        return userVO;
    }

    @Override
    public void login(Object loginId) {
        StpUtil.login(loginId);
        log.info("{},登录成功",StpUtil.getLoginId());
    }

    @Override
    public SaaSUserInfo getUserInfo() {
        UserVO userVO = new UserVO();
        SaaSUserInfo ssaSUserInfo = new SaaSUserInfo(userVO);
        return ssaSUserInfo;
    }

    @Override
    public AuthUserInfo getAuthUserInfo() {
        UserVO userVO = new UserVO();
        AuthUserInfo authUserInfo = new  AuthUserInfo(userVO);
        return authUserInfo;
    }

    @Override
    public TokenVO getToken() {
        TokenVO tokenVO = new TokenVO();
        tokenVO.setTokenType("Bearer ");
        tokenVO.setAccessToken(StpUtil.getTokenValue());
        return tokenVO;
    }

    @Override
    public boolean login(String username, String password) {
        UserVO userVO = isUser(username, password);
        boolean flag = false;
        if (userVO!=null)
        {
            login(userVO.getId());
            flag = true;
        }
        else
        {
            throw AuthException.authException(AuthCode.AUTH_TOKEN_NOT_GET);
        }
        return flag;
    }


    @Override
    public TokenVO saasLogin(LoginParams loginParams) {
        TokenVO tokenVO = new TokenVO();
        if (login(loginParams.getUsername(), loginParams.getPassword())) {
            tokenVO = getToken();
        }
        return tokenVO;
    }

    @Override
    public TokenVO authLogin(LoginData loginData) {
        TokenVO tokenVO = new TokenVO();
        if (captchaService.checkCaptcha(loginData.getCaptchaKey(), loginData.getCaptchaCode()) &&
                        login(loginData.getUsername(), loginData.getPassword())) {
            tokenVO = getToken();
        }
        return tokenVO;
    }

    @Override
    public void logout() {
        StpUtil.logout();
    }
}
