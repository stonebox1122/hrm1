package com.stone.hrm.dao;

import com.stone.hrm.pojo.Permission;
import org.apache.ibatis.annotations.Delete;
import tk.mybatis.mapper.common.Mapper;

public interface PermissionMapper extends Mapper<Permission> {

    @Delete("delete from tb_permission where parentId = #{parentId}")
    void deleteByParentId(Integer parentId);
}
