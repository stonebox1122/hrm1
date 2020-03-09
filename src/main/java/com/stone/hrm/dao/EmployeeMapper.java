package com.stone.hrm.dao;

import com.stone.hrm.pojo.Employee;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface EmployeeMapper extends Mapper<Employee> {

    @Select("select t1.id id,t1.name name,t1.username username from tb_employee t1,tb_job t2 where t1.job_id=t2.id and t1.organization_id=#{organizationId} and t2.level>=10")
    List<Employee> findManagerByOrganizationId(@Param("organizationId") Integer organizationId);
}
