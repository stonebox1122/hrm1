package com.stone.hrm.service;

import com.stone.hrm.pojo.Role;
import com.stone.hrm.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    /**
     * 添加新的用户，添加新的角色，并给新用户授予新角色
     */
    @Test
    @Transactional
    @Commit
    public void testAdd() {
        User user = new User();
        user.setUsername("cq00004");
        user.setStatus(1);
        user.setCreateTime(new Date());

        Role role = new Role();
        role.setName("guest");
        role.setDescription("访客");
        role.setStatus(1);
        role.setCreateTime(new Date());

        user.getRoles().add(role);

        userService.add(user);
        roleService.add(role);
    }

    /**
     * 添加新的用户，并给新用户授予角色
     */
    @Test
    @Transactional
    @Commit
    public void testAdd1() {
        User user = new User();
        user.setUsername("cq00005");
        user.setStatus(1);
        user.setCreateTime(new Date());

        //user.getRoles().add(roleService.findByNameAndStatus("user", 1));

        userService.add(user);
    }

    /**
     * 现有用户授予新角色
     */
    @Test
    @Transactional
    @Commit
    public void testAdd2() {
        //User user = userService.findByUsernameAndStatus("cq00001", 1);
        List<Role> roles = new ArrayList<>();
        //roles.add(roleService.findByNameAndStatus("admin", 1));
        //roles.add(roleService.findByNameAndStatus("user", 1));
        //user.setRoles(roles);
        //userService.update(user);
    }

    /**
     * 查询用户及其角色
     */
    @Test
    @Transactional
    @Commit
    public void testFind() {
        //User user = userService.findByUsernameAndStatus("cq00001", 1);
        //System.out.println(user);
    }

}