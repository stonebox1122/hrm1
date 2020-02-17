package com.stone.hrm.service;

import com.stone.hrm.dto.UserDto;
import com.stone.hrm.pojo.User;
import com.github.pagehelper.Page;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Map;

public interface UserService extends UserDetailsService {

    /***
     * 查询所有用户
     * @return
     */
    List<User> findAll();

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    User findById(Integer id);

    /***
     * 新增用户
     * @param user
     */
    User add(UserDto user);

    /***
     * 修改用户数据
     * @param user
     */
    void update(User user);

    /***
     * 删除用户
     * @param id
     */
    void delete(Integer id);

    /***
     * 多条件搜索用户方法
     * @param searchMap
     * @return
     */
    List<User> findList(Map<String, Object> searchMap);

    /***
     * 分页查询
     * @param page
     * @param size
     * @return
     */
    Page<User> findPage(int page, int size);

    /***
     * 多条件分页查询
     * @param searchMap
     * @param page
     * @param size
     * @return
     */
    Page<User> findPage(Map<String, Object> searchMap, int page, int size);

    /**
     * 多条件分页查询，包含角色
     * @param searchMap
     * @param page
     * @param size
     * @return
     */
    Page<User> findAllPage(Map<String, Object> searchMap, int page, int size);

    /**
     * 修改用户状态
     * @param status
     * @param id
     * @return
     */
    User updateStatusById(Integer status, Integer id);

    void updateRole(Integer id, Integer rid);

    Page<User> findConditionPage(UserDto userDto, int page, int size);
}
