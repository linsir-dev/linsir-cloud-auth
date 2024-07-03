package com.linsir.auth.modules.rabc.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.linsir.auth.modules.rabc.entity.User;
import com.linsir.auth.modules.rabc.mapper.UserMapper;
import com.linsir.auth.modules.rabc.service.UserService;
import com.linsir.auth.modules.rabc.vo.UserVO;
import com.linsir.base.core.binding.Binder;


import com.linsir.base.core.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

import static com.baomidou.mybatisplus.extension.toolkit.Db.getOne;

/**
 * description:
 *
 * @author [linsir]
 * @version 0.0.1
 * @date 2022/09/01 18:30:15
 */

@Service
public class UserServiceImpl extends BaseServiceImpl<UserMapper, User> implements UserService {

    /**
     * 按照名称获取 用户信息
     * @param account
     * @return
     */
    @Override
    public UserVO getByAccount(String account) {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("account",account);
        User user = getOne(userQueryWrapper);
        return Binder.convertAndBindRelations(user,UserVO.class);
    }
}
