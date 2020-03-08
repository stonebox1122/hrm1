package com.stone.hrm.dao;

import com.stone.hrm.pojo.Employee;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface EmployeeMapper extends Mapper<Employee> {

    @Select(value = "select id,name,username from tb_employee")
    List<Employee> findAllManager();
}
