package com.stone.hrm.dao;

import com.stone.hrm.pojo.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * role数据访问接口
 * @author Administrator
 *
 */
public interface RoleDao extends JpaRepository<Role,Integer>,JpaSpecificationExecutor<Role>{
    public Role findByNameAndStatus(String name, int status);
}
