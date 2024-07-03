package com.linsir.auth.modules.rabc.mapper;

import com.linsir.auth.modules.rabc.entity.Role;
import com.linsir.base.core.mapper.BaseCrudMapper;

import org.apache.ibatis.annotations.Mapper;

/**
 * @author Administrator
 * @title: RoleMapper
 * @projectName lins
 * @description:
 * @date 2022/1/18 12:41
 */
@Mapper
public interface RoleMapper extends BaseCrudMapper<Role> {
}
