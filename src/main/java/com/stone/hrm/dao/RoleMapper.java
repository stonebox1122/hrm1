package com.stone.hrm.dao;


import com.stone.hrm.pojo.Role;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

public interface RoleMapper extends Mapper<Role> {

    @Update(value = "update tb_role set status=#{status},update_time=now() where id=#{id}")
    void updateStatusById(@Param("status") Integer status, @Param("id") Integer id);
}
