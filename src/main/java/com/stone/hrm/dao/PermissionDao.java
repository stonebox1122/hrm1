package com.stone.hrm.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.stone.hrm.pojo.Permission;
/**
 * permission数据访问接口
 * @author Administrator
 *
 */
public interface PermissionDao extends JpaRepository<Permission,Integer>,JpaSpecificationExecutor<Permission>{
	
}
