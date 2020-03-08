package com.stone.hrm.dao;

import com.stone.hrm.pojo.Department;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

public interface DepartmentMapper extends Mapper<Department> {

    @Update("update tb_department set status =  #{status} where id = #{id} ")
    void updateStatusById(@Param("status")Integer status, @Param("id")Integer id);

    void updateStatusByParentId(@Param("status")Integer status, @Param("id")Integer id);

    void deleteByParentId(Integer id);
}
