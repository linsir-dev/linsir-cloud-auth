package com.linsir.modules.login.vo;

import com.linsir.saas.modules.rabc.vo.UserVO;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author linsir
 * @version 1.0.0
 * @title AuthUserInfo
 * @description
 * @create 2024/8/5 21:38
 */

@Data
public class AuthUserInfo {

    private String userId;

    private String username;

    private String nickname;

    private String avatar;

    private List<String> roles;

    private List <String> perms;

    public AuthUserInfo(UserVO userVO) {
        this.userId = "11111";
        this.username = "admin";
        this.nickname = "linsir";
        this.avatar = "https://q1.qlogo.cn/g?b=qq&nk=339449197&s=640";
        this.roles = new ArrayList<>();
        roles.add("admin");
        this.perms = new ArrayList<>();
        perms.add("all");
    }
}
