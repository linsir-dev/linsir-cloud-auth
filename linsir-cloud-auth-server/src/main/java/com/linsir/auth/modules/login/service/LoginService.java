package com.linsir.auth.modules.login.service;

import com.linsir.modules.login.dto.LoginData;
import com.linsir.modules.login.dto.LoginParams;
import com.linsir.modules.login.vo.AuthUserInfo;
import com.linsir.modules.login.vo.SaaSUserInfo;
import com.linsir.modules.login.vo.TokenVO;
import com.linsir.saas.modules.rabc.vo.UserVO;

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
    SaaSUserInfo getUserInfo();


    /**
     * @description 获取当前用户信息
     * @author Linsir
     * @param
     * @return com.linsir.modules.login.vo.AuthUserInfo
     * @time 2024/8/5 22:18
     */
    AuthUserInfo getAuthUserInfo();

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
     boolean login(String username, String password);


     /**
      * @description saas 服务登录
      * @author Linsir
      * @param  loginParams
      * @return com.linsir.modules.login.vo.TokenVO
      * @time 2024/8/5 19:08
      */
     TokenVO saasLogin(LoginParams loginParams);


     /**
      * @description auth 登录
      * @author Linsir
      * @param  loginData
      * @return com.linsir.modules.login.vo.TokenVO
      * @time 2024/8/5 19:13
      */
     TokenVO authLogin(LoginData loginData);


     /**
      * @description 推出
      * @author Linsir
      * @param
      * @return void
      * @time 2024/8/8 8:18
      */
     void logout();
}
