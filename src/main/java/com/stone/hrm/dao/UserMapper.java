package com.stone.hrm.dao;


import com.stone.hrm.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

public interface UserMapper extends Mapper<User> {

    User findByUsername(@Param("username") String username);

    List<User> selectAllWithRole();

    @Update(value = "update tb_user set status=#{status},update_time=now() where id=#{id}")
    void updateStatusById(@Param("status") Integer status, @Param("id") Integer id);

    @Update(value = "update tb_user_role set role_id=#{rid},update_time=now() where user_id=#{id}")
    void updateRole(@Param("id") Integer id, @Param("rid") Integer rid);

    List<User> findConditionPage(@Param("username")String username, @Param("roleId")Integer roleId, @Param("status")Integer status, @Param("beginCreateTime")Date beginCreateTime, @Param("endCreateTime")Date endCreateTime);
}
