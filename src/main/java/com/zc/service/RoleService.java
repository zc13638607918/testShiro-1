package com.zc.service;

import java.util.Set;

/**
 * @ClassName RoleService
 * @Description TODO
 * @Author 周超
 * @Date 2020/4/9 17:11
 * @Version 1.0
 **/
public interface RoleService {
    Set<String > listRoles(String userName);
}
