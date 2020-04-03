package com.karl.dao;

import com.karl.mapper.EmployeeMapper;
import com.karl.pojo.Department;
import com.karl.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class EmployeeDao {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private DepartmentDao departmentDao;

    //增加一个员工
    public void save(Employee employee){
        if (employee.getId()!=null&&employeeMapper.getEmp(employee.getId())!=null){
            employeeMapper.updateEmp(employee);
        }else {
            employeeMapper.addEmp(employee);
        }
    }

    public Collection<Employee> getAll(){
        List<Employee> emps = employeeMapper.getEmps();
        for (int i = 0; i < emps.size(); i++) {
            Employee employee = emps.get(i);
            employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartmentId()));
        }
        return emps;
    }

    public Employee getEmployeeById(Integer id){
        System.out.println();
        return employeeMapper.getEmp(id);
    }

    public void delete(Integer id){
        employeeMapper.deleteEmp(id);
    }
}
