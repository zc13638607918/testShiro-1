package com.zc.service.impl;

import com.zc.mapper.RoleMapper;
import com.zc.pojo.Role;
import com.zc.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName RoleServiceImpl
 * @Description TODO
 * @Author 周超
 * @Date 2020/4/9 17:13
 * @Version 1.0
 **/
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleMapper roleMapperl;
    @Override
    public Set<String> listRoles(String userName) {
        List<Role> roles = roleMapperl.listRoleByUserName(userName);
        Set<String> result = new HashSet<>();
        for (Role r:roles
             ) {
            result.add(r.getName());
        }
        return result;
    }
}
