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

        department.put(1001,new Department(1001,"教学部"));
        department.put(1002,new Department(1002,"市场部"));
        department.put(1003,new Department(1003,"教研部"));
        department.put(1004,new Department(1004,"运营部"));
        department.put(1005,new Department(1005,"后勤部"));
    }

    //获取部门信息
    public Collection<Department> getDepartments(){
        return department.values();
    }


    public Department getDepartmentById(Integer id){
        return department.get(id);
    }

}
