package com.lv.mybatis.mapper;

import com.lv.mybatis.pojo.User;

import java.util.List;

public interface UserMapper {
    int insertUser();
    int updateUser();
    int deleteUser();
    //根据id查询用户信息
    User getUserById();
    List<User> getAllUser();
}
