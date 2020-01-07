package com.stone.hrm.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.stone.hrm.pojo.RolePermission;
/**
 * rolePermission数据访问接口
 * @author Administrator
 *
 */
public interface RolePermissionDao extends JpaRepository<RolePermission,Integer>,JpaSpecificationExecutor<RolePermission>{
	
}
