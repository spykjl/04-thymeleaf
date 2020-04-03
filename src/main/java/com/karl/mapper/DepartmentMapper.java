package com.karl.mapper;

import com.karl.pojo.Department;
import com.karl.pojo.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DepartmentMapper {
    List<Department> getDepartments();

    Department getDepartmentById(int id);
}
