package com.zc.mapper;

import com.zc.pojo.User;

public interface UserMapper {
    User getByName(String userName);
}
