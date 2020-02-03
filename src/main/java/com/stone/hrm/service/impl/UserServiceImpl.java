package com.stone.hrm.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.stone.hrm.dao.RoleMapper;
import com.stone.hrm.dao.UserMapper;
import com.stone.hrm.dao.UserRoleMapper;
import com.stone.hrm.dto.UserDto;
import com.stone.hrm.pojo.User;
import com.stone.hrm.pojo.UserRole;
import com.stone.hrm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    /**
     * 查询全部列表
     *
     * @return
     */
    @Override
    public List<User> findAll() {
        return userMapper.selectAll();
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @return
     */
    @Override
    public User findById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }


    /**
     * 增加
     *
     * @param user
     */
    @Override
    public User add(UserDto user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userMapper.insert(user);
        UserRole userRole = new UserRole();
        userRole.setUserId(user.getId());
        userRole.setRoleId(user.getRoleId());
        userRoleMapper.insert(userRole);
        return findById(user.getId());
    }


    /**
     * 修改
     *
     * @param user
     */
    @Override
    public void update(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setUpdateTime(Calendar.getInstance().getTime());
        userMapper.updateByPrimaryKey(user);
    }

    /**
     * 删除
     *
     * @param id
     */
    @Override
    public void delete(Integer id) {
        userMapper.deleteByPrimaryKey(id);
    }


    /**
     * 条件查询
     *
     * @param searchMap
     * @return
     */
    @Override
    public List<User> findList(Map<String, Object> searchMap) {
        Example example = createExample(searchMap);
        return userMapper.selectByExample(example);
    }

    /**
     * 分页查询
     *
     * @param page
     * @param size
     * @return
     */
    @Override
    public Page<User> findPage(int page, int size) {
        PageHelper.startPage(page, size);
        return (Page<User>) userMapper.selectAll();
    }

    /**
     * 条件+分页查询
     *
     * @param searchMap 查询条件
     * @param page      页码
     * @param size      页大小
     * @return 分页结果
     */
    @Override
    public Page<User> findPage(Map<String, Object> searchMap, int page, int size) {
        PageHelper.startPage(page, size);
        Example example = createExample(searchMap);
        return (Page<User>) userMapper.selectByExample(example);
    }

    @Override
    public Page<User> findAllPage(Map<String, Object> searchMap, int page, int size) {
        PageHelper.startPage(page, size);
        //Example example = createExample(searchMap);
        return (Page<User>) userMapper.selectAllWithRole();
    }

    @Override
    public User updateStatusById(Integer status, Integer id) {
        userMapper.updateStatusById(status, id);
        return findById(id);
    }

    @Override
    public void updateRole(Integer id, Integer rid) {
        userMapper.updateRole(id, rid);
    }

    /**
     * 构建查询对象
     *
     * @param searchMap
     * @return
     */
    private Example createExample(Map<String, Object> searchMap) {
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        if (searchMap != null) {
            // 员工工号
            if (searchMap.get("username") != null && !"".equals(searchMap.get("username"))) {
                criteria.andLike("username", "%" + searchMap.get("username") + "%");
            }
            // 登录密码
            if (searchMap.get("password") != null && !"".equals(searchMap.get("password"))) {
                criteria.andLike("password", "%" + searchMap.get("password") + "%");
            }

            // 用户ID
            if (searchMap.get("id") != null) {
                criteria.andEqualTo("id", searchMap.get("id"));
            }
            // 状态：0为禁用，1为启用
            if (searchMap.get("status") != null) {
                criteria.andEqualTo("status", searchMap.get("status"));
            }

        }
        return example;
    }

    /**
     * 认证业务 参考：https://www.bilibili.com/video/av74851468
     *
     * @param username 用户在浏览器输入的用户名
     * @return UserDetails 是SpringSecurity自己的用户对象
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userMapper.findByUsername(username);
    }
}
