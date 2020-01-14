package com.stone.hrm.dao;

import com.stone.hrm.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * user数据访问接口
 * @author Administrator
 *
 */
public interface UserDao extends JpaRepository<User,Integer>,JpaSpecificationExecutor<User>{
    User findByUsernameAndStatus(String username, int status);

    @Modifying
    @Query(value = "update tb_user set status=? where id=?", nativeQuery = true)
    int updateStatusById(int status, int id);

    @Modifying
    @Query(value = "insert into tb_user_role(user_id,role_id) values(?,?)", nativeQuery = true)
    void insertRoleById(int userId, int roleId);
}
