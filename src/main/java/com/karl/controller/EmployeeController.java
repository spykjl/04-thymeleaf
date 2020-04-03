package com.karl.controller;

import com.karl.dao.DepartmentDao;
import com.karl.dao.EmployeeDao;
import com.karl.pojo.Department;
import com.karl.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;

    @RequestMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps",employees);
        return "emp/list";
    }

    @GetMapping("/emp")
    public String toAddPage(Model model){
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments",departments);
        return "emp/add";
    }

    @PostMapping("/emp")
    public String addEmp(Employee employee){
        //添加的操作
        employeeDao.save(employee);//保存员工信息

        return "redirect:/emps";
    }

    @GetMapping("/empDel/{id}")
    public String empDel(@PathVariable Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }


    @GetMapping("/emp/{id}")
    public String fixEmp(@PathVariable Integer id,Model model){
        Employee emp = employeeDao.getEmployeeById(id);
        model.addAttribute("emp",emp);
        Collection<Department> departments = departmentDao.getDepartments();
        System.out.println(departments);
        model.addAttribute("departments",departments);
        return "emp/updata";
    }

    @PostMapping("/updateEmp")
    public String updateEmp(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }

}
