package com.zc.mapper;

import com.zc.pojo.Role;

import java.util.List;

public interface RoleMapper {
    List<Role> listRoleByUserName(String userName);
}
