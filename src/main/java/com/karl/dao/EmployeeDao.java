package com.karl.dao;

import com.karl.pojo.Department;
import com.karl.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeDao {
    private static Map<Integer, Employee> employees=null;

    @Autowired
    private DepartmentDao departmentDao;

    //模拟数据库中的数据
    static {
        employees=new HashMap<Integer, Employee>();

        employees.put(1001,new Employee(1001,"Karl","jialongkou@163.com",1,new Department(1001,"教学部")));
        employees.put(1002,new Employee(1002,"Tom","jialongkou@163.com",0,new Department(1002,"市场部")));
        employees.put(1003,new Employee(1003,"Vivi","jialongkou@163.com",1,new Department(1003,"教研部")));
        employees.put(1004,new Employee(1004,"jack","jialongkou@163.com",0,new Department(1004,"运营部")));
        employees.put(1005,new Employee(1005,"Dom","jialongkou@163.com",1,new Department(1005,"后勤部")));
    }

    //增加一个员工
    //主键自增
    private static Integer initId=1006;

    public void save(Employee employee){
        if (employee.getId()==null) {
            employee.setId(initId++);
        }
        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));

        employees.put(employee.getId(),employee);
    }

    public Collection<Employee> getAll(){
        return employees.values();
    }

    public Employee getEmployeeById(Integer id){
        System.out.println();
        return employees.get(id);
    }

    public void delete(Integer id){
        employees.remove(id);
    }
}
