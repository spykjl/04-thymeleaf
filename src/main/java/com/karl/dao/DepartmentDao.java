package com.karl.dao;

import com.karl.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

//部门dao
@Repository
public class DepartmentDao {
    private static Map<Integer, Department> department=null;

    //模拟数据库中的数据
    static {
        department=new HashMap<Integer, Department>();

        department.put(101,new Department(101,"教学部"));
        department.put(102,new Department(102,"市场部"));
        department.put(103,new Department(103,"教研部"));
        department.put(104,new Department(104,"运营部"));
        department.put(105,new Department(105,"后勤部"));
    }

    //获取部门信息
    public Collection<Department> getDepartments(){
        return department.values();
    }


    public Department getDepartmentById(Integer id){
        return department.get(id);
    }

}
