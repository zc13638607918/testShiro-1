package com.zc.service;

import java.util.Set;

public interface PermissionService {
    Set<String> listPermissions(String userName);
}
