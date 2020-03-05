package com.stone.hrm.dao;

import com.stone.hrm.pojo.RolePermission;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface RolePermissionMapper extends Mapper<RolePermission> {

    @Select(value = "select t1.permission_id from tb_role_permission t1,tb_permission t2 where t1.permission_id=t2.id and t2.type=2 and t1.role_id=#{roleId}")
    List<RolePermission> findByRoleId(@Param("roleId") Integer roleId);

    @Delete(value = "delete from tb_role_permission where role_id=#{roleId}")
    void deleteByRoleId(@Param("roleId") Integer roleId);
}
