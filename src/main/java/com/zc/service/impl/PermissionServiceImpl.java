package com.zc.service.impl;

import com.zc.mapper.PermissionMapper;
import com.zc.pojo.Permission;
import com.zc.pojo.User;
import com.zc.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName PermissionServiceImpl
 * @Description TODO
 * @Author 周超
 * @Date 2020/4/9 17:47
 * @Version 1.0
 **/
@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    PermissionMapper permissionMapper;
    @Override
    public Set<String> listPermissions(String userName) {
        List<Permission> list = permissionMapper.listPermissionByUserName(userName);
        Set<String> result=new HashSet<>();
        for (Permission p:list
             ) {
            result.add(p.getName());
        }
                return result;
    }
}
