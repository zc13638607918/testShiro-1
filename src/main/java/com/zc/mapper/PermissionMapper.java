package com.zc.mapper;

import com.zc.pojo.Permission;

import java.util.List;

public interface PermissionMapper {
    List<Permission> listPermissionByUserName(String userName);
}
