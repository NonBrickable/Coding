package com.lv.mybatis.test;

import com.lv.mybatis.mapper.SelectMapper;
import com.lv.mybatis.pojo.User;
import com.lv.mybatis.SqlSessionUtil;
import org.apache.ibatis.logging.stdout.StdOutImpl;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class SelectMapperTest{
    @Test
    public void testGetUserById(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        Object mapper = sqlSession.getMapper(SelectMapper.class);
        User user = ((SelectMapper) mapper).getUserById(1);
        System.out.println(user);
    }

    @Test
    public void testGetAllUser(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        Object mapper = sqlSession.getMapper(SelectMapper.class);
        List<User> users = ((SelectMapper) mapper).getAllUser();
        for(User user:users){
            System.out.println(user);
        }
    }
    @Test
    public void testGetCount(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        Object mapper = sqlSession.getMapper(SelectMapper.class);
        Integer count = ((SelectMapper) mapper).getCount();
        System.out.println(count);
    }

    @Test
    public void testGetUserByIdToMap(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        Object mapper = sqlSession.getMapper(SelectMapper.class);
        Map<String, Object> userByIdToMap = ((SelectMapper) mapper).getUserByIdToMap(1);
        //{password=123456, gender=男, id=1, age=23, email=12345@qq.com, username=admin}
        System.out.println(userByIdToMap);
    }

    /**
     * {1={password=123456, gender=男, id=1, age=23, email=12345@qq.com, username=admin}
     * ,14={password=123456, gender=女, id=14, age=33, email=123@qq.com, username=root}}
     */
    @Test
    public void testGetAllUserToMap(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        Object mapper = sqlSession.getMapper(SelectMapper.class);
        Map<String, Object> map = ((SelectMapper) mapper).getAllUserToMap();
        System.out.println(map);
    }
}
