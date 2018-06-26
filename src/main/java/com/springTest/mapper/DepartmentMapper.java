package com.springTest.mapper;

import com.springTest.entities.Department;

public interface DepartmentMapper {

    public void insert(Department department);

    public Department select(Integer id);
}
