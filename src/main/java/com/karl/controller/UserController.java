package com.karl.controller;

import com.karl.pojo.User;
import com.karl.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserMapper userMapper;

    @GetMapping("queryUserList")
    public List<User> queryUserList(){
        return userMapper.queryUserList();
    }

    @GetMapping("queryUserById/{id}")
    public User queryUserById(@PathVariable("id") int id){
        return userMapper.queryUserById(id);
    }

    @GetMapping("addUser/{username}/{age}")
    public User addUser(@PathVariable("username") String username,@PathVariable("age") int age ){
        User user = new User();
        user.setUsername(username);
        user.setAge(age);
        userMapper.addUser(user);
        return user;
    }
}
