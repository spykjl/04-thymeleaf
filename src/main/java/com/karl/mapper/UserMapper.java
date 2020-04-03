package com.karl.mapper;

import com.karl.pojo.Employee;
import com.karl.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    User getUserByName(String name);
}
