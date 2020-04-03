package com.karl.dao;

import com.karl.mapper.EmployeeMapper;
import com.karl.mapper.UserMapper;
import com.karl.pojo.Employee;
import com.karl.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public class UserDao {

    @Autowired
    private UserMapper userMapper;

    public User getUserByName(String username){
        return userMapper.getUserByName(username);
    }
}
