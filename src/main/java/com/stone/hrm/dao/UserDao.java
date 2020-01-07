package com.stone.hrm.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.stone.hrm.pojo.User;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * user数据访问接口
 * @author Administrator
 *
 */
public interface UserDao extends JpaRepository<User,Integer>,JpaSpecificationExecutor<User>{
    @Query(value = "select id,username,password,status from user where status=1 and username=?", nativeQuery = true)
    public User findByUsername(String username);
}
