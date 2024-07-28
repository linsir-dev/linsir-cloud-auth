package com.linsir.auth.modules.oauth.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.linsir.auth.code.AuthCode;
import com.linsir.auth.exception.AuthException;
import com.linsir.auth.modules.oauth.dto.LoginData;
import com.linsir.auth.modules.oauth.service.LoginService;
import com.linsir.auth.vo.TokenVO;
import com.linsir.auth.vo.UserInfo;
import com.linsir.base.core.vo.jsonResults.JsonResult;
import com.linsir.base.core.vo.results.R;
import com.linsir.saas.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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

        if (Objects.equals(username, "admin") || Objects.equals(password, "123")) {
            userVO.setId(111111);
            userVO.setUsername("admin");
        }
        return userVO;
    }

    @Override
    public void login(Object loginId) {
        StpUtil.login(loginId);
        log.info("{},登录成功",StpUtil.getLoginId());
    }

    @Override
    public UserInfo getUserInfo() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(StpUtil.getLoginIdAsInt());
        log.info("当前用户id：{}",StpUtil.getLoginId());
        userInfo.setAvatar("https://oss.youlai.tech/youlai-boot/2023/05/16/811270ef31f548af9cffc026dfc3777b.gif");
        return userInfo;
    }

    @Override
    public TokenVO getToken() {
        TokenVO tokenVO = new TokenVO();
        tokenVO.setTokenType("Bearer ");
        tokenVO.setAccessToken(StpUtil.getTokenValue());
        return tokenVO;
    }

    @Override
    public TokenVO login(String username, String password) {
        UserVO userVO = isUser(username, password);
        if (userVO!=null)
        {
            login(userVO.getId());
            return getToken();
        }
        else
        {
            throw AuthException.authException(AuthCode.AUTH_TOKEN_NOT_GET);
        }
    }


}
