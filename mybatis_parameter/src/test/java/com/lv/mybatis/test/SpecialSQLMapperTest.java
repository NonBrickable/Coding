package com.lv.mybatis.test;

import com.lv.mybatis.mapper.SpecialSQLMapper;
import com.lv.mybatis.pojo.User;
import com.lv.mybatis.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.sql.SQLOutput;
import java.util.List;

public class SpecialSQLMapperTest {
    @Test
    public void testGetUserByLike(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        Object mapper = sqlSession.getMapper(SpecialSQLMapper.class);
        List<User> like = ((SpecialSQLMapper) mapper).getUserByLike("a");
        System.out.println(like);
    }
    @Test
    public void testDeleteMoreUser(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        Object mapper = sqlSession.getMapper(SpecialSQLMapper.class);
        ((SpecialSQLMapper) mapper).deleteMoreUser("9,10");
    }
    @Test
    public void testgetUserList(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        Object mapper = sqlSession.getMapper(SpecialSQLMapper.class);
        List<User> list = ((SpecialSQLMapper) mapper).getUserList("mybatis");
        list.forEach(System.out::println);
    }
    @Test
    public void testInsertUser(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        Object mapper = sqlSession.getMapper(SpecialSQLMapper.class);
        User user = new User(null,"xiaoming","123456",23,"男","12345@qq.com");
        ((SpecialSQLMapper) mapper).insertUser(user);
        System.out.println(user);
    }
}
