package com.stone.hrm.dao;

import com.stone.hrm.pojo.Permission;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

public interface PermissionMapper extends Mapper<Permission> {

    void deleteByParentId(@Param("parentId")Integer parentId);

    void updateStatusByParentId(@Param("status")Integer status, @Param("id")Integer id);

    @Update("update tb_permission set status =  #{status} where id = #{id} ")
    void updateStatusById(@Param("status")Integer status, @Param("id")Integer id);
}
