package com.stone.hrm.dao;

import com.stone.hrm.pojo.Role;
import com.stone.hrm.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserDaoTest {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;

    /**
     * 添加新的用户，添加新的角色，并给新用户授予新角色
     */
    @Test
    @Transactional
    @Commit
    public void testAdd(){
        User user = new User();
        user.setUsername("cq00002");
        user.setStatus(1);
        user.setCreateTime(new Date());

        Role role = new Role();
        role.setName("user");
        role.setDescription("普通用户");
        role.setStatus(1);
        role.setCreateTime(new Date());

        user.getRoles().add(role);

        userMapper.insert(user);
        roleMapper.insert(role);
    }

    /**
     * 添加新的用户，并给新用户授予权限
     */
    @Test
    @Transactional
    @Commit
    public void testAdd1(){
        User user = new User();
        user.setUsername("cq00003");
        user.setStatus(1);
        user.setCreateTime(new Date());

       // user.getRoles().add(roleMapper.findByNameAndStatus("user", 1));

        userMapper.insert(user);
    }

}