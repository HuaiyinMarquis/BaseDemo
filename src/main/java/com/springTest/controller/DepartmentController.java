package com.springTest.controller;

import com.springTest.entities.Department;
import com.springTest.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepartmentController {
    @Autowired
    private DepartmentMapper departmentMapper;

    @GetMapping("/getDep/{id}")
    public Department getDep(@PathVariable("id") Integer id){
        Department department = departmentMapper.select(id);
        return department;
    }
}
