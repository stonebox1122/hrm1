package com.stone.hrm.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.stone.hrm.pojo.UserRole;
/**
 * userRole数据访问接口
 * @author Administrator
 *
 */
public interface UserRoleDao extends JpaRepository<UserRole,Integer>,JpaSpecificationExecutor<UserRole>{
	
}
