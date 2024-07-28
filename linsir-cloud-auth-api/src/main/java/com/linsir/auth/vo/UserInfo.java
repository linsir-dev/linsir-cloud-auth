package com.linsir.auth.vo;

import lombok.Data;

import java.util.List;

/**
 * @author linsir
 * @version 1.0.0
 * @title UserInfo
 * @description
 * @create 2024/7/24 13:58
 */


@Data
public class UserInfo {

    public int userId;

    private String username;

    private String nickname;

    private String avatar;

    private List<String> roles;

    private List<String> perms;
}
