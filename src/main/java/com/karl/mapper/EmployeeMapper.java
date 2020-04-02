package com.karl.mapper;

import com.karl.pojo.Employee;
import com.karl.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface EmployeeMapper {
    List<Employee> getEmps();

    Employee getEmp(int id);

    int addEmp(Employee user);

    int updateEmp(Employee user);

    int deleteEmp(int id);
}
