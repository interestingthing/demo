package com.client.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper{

    List<User> list();

    User getOne(int id);
    
}