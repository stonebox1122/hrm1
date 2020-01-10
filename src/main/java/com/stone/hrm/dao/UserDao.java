package com.stone.hrm.dao;

import com.stone.hrm.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * user数据访问接口
 * @author Administrator
 *
 */
public interface UserDao extends JpaRepository<User,Integer>,JpaSpecificationExecutor<User>{
    public User findByUsernameAndStatus(String username, int status);
}
