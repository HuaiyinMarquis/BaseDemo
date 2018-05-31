package com.springTest.controller;

import com.springTest.dao.DepartmentDao;
import com.springTest.dao.EmployeeDao;
import com.springTest.entities.Department;
import com.springTest.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private DepartmentDao departmentDao;

    /**
     * 员工列表查询
     * @param model
     * @return
     */
    @GetMapping(value = "/emps")
    public String searchEmps(Model model) {
        Collection<Employee> emps = employeeDao.getAll();
        model.addAttribute("emps",emps);
        return "emp/list";
    }

    /**
     * 进入添加员工页面
     * @param model
     * @return
     */
    @GetMapping(value = "/emp")
    public String enterAdd(Model model) {
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "emp/add";
    }

    /**
     * 添加员工
     * @param employee
     * @return
     */
    @PostMapping(value = "/emp")
    public String addEmp(Employee employee) {
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    /**
     * 进入修改员工页面
     * @param id
     * @param model
     * @return
     */
    @GetMapping(value = "/emp/{id}")
    public String enterUpdate(@PathVariable("id")Integer id, Model model) {
        Employee emp = employeeDao.get(id);
        model.addAttribute("emp",emp);
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "emp/add";
    }

    /**
     * 修改员工信息
     * @param employee
     * @return
     */
    @PutMapping(value = "/emp")
    public String updateEmp(Employee employee) {
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @DeleteMapping(value = "/emp/{id}")
    public String deleteEmp(@PathVariable("id") Integer id) {
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
