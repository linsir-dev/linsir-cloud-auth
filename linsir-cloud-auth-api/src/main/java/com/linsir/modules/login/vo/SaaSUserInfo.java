package com.linsir.modules.login.vo;

import com.linsir.saas.modules.rabc.vo.UserVO;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author linsir
 * @version 1.0.0
 * @title UserInfo
 * @description
 * @create 2024/7/24 13:58
 */


@Data
public class SaaSUserInfo {

    public int userId;

    private String username;

    private String realname;

    private String email;

    private String phone;

    private String address;

    private String avatar;

    private String desc;

    private String password;

    private String accessToken;

    private List<SaaSRole> roles;

    public SaaSUserInfo(UserVO uservo) {
        this.userId = 1111;
        this.username = "admin";
        this.realname = "喻肖林";
        this.email = "admin@linsir.com";
        this.phone = "+86 88888888";
        this.address = "aaaa";
        this.avatar = "https://q1.qlogo.cn/g?b=qq&nk=339449197&s=640";
        this.desc ="模拟数据";
        this.password = "123456";
        this.accessToken = "xxxx";
        this.roles = new ArrayList<>();
        SaaSRole role = new SaaSRole();
        role.setName("Super Admin");
        role.setValue("super");
        this.roles.add(role);
    }


}
