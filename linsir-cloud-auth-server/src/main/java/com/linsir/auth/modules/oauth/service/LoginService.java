package com.linsir.auth.modules.oauth.service;

import com.linsir.auth.modules.oauth.dto.LoginData;
import com.linsir.auth.vo.TokenVO;
import com.linsir.auth.vo.UserInfo;
import com.linsir.base.core.vo.results.R;
import com.linsir.saas.vo.UserVO;

/**
 * @author linsir
 * @version 1.0.0
 * @title Loginservice
 * @description
 * @create 2024/7/24 13:36
 */


public interface LoginService {


    /**
     * 判断用户名 和 密码 以及 用户相关信息是否正确
     * @param username
     * @param password
     * @return
     */
    UserVO isUser(String username, String password);

    /**
     * @description 登录写入Session
     * @author Linsir
     * @param  loginId
     * @return void
     * @time 2024/7/29 2:53
     */
    void login(Object loginId);


    /**
     * @description 获取当前用户信息
     * @author Linsir
     * @param
     * @return com.linsir.auth.vo.UserInfo
     * @time 2024/7/29 2:59
     */
    UserInfo getUserInfo();


    /**
     * @description 获取当前token
     * @author Linsir
     * @param
     * @return com.linsir.auth.vo.TokenVO
     * @time 2024/7/29 3:00
     */
    TokenVO getToken();


    /**
     * @description 用户名密码登录
     * @author Linsir
     * @param
     * @return com.linsir.auth.vo.TokenVO
     * @time 2024/7/29 3:18
     */
    TokenVO login(String username, String password);

}
