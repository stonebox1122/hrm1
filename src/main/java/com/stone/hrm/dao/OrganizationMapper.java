package com.stone.hrm.dao;

import com.stone.hrm.pojo.Organization;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

public interface OrganizationMapper extends Mapper<Organization> {

    @Update("update tb_organization set status =  #{status} where id = #{id} ")
    void updateStatusById(@Param("status")Integer status, @Param("id")Integer id);

    void updateStatusByParentId(@Param("status")Integer status, @Param("id")Integer id);

    void deleteByParentId(@Param("id") Integer id);
}
