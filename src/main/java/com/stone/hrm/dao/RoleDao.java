package com.stone.hrm.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.stone.hrm.pojo.Role;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * role数据访问接口
 * @author Administrator
 *
 */
public interface RoleDao extends JpaRepository<Role,Integer>,JpaSpecificationExecutor<Role>{
    @Query(value = "select r.id, r.name, r.description " +
            "from role r, user_role ur " +
            "where r.id=ur.rid and r.staus=1 and ur.uid=?", nativeQuery = true)
    public List<Role> findByUid(Integer uid);
}
