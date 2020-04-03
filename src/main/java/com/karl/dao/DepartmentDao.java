package com.karl.dao;

import com.karl.mapper.DepartmentMapper;
import com.karl.pojo.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;

//部门dao
@Repository
public class DepartmentDao {
    @Autowired
    DepartmentMapper departmentMapper;


    //获取部门信息
    public Collection<Department> getDepartments(){
        return departmentMapper.getDepartments();
    }


    public Department getDepartmentById(Integer id){
        return departmentMapper.getDepartmentById(id);
    }

}
