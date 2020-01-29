package com.stone.hrm.service;

import com.stone.hrm.pojo.UserRole;
import com.github.pagehelper.Page;

import java.util.List;
import java.util.Map;

public interface UserRoleService {

    /***
     * 查询所有用户角色关系
     * @return
     */
    List<UserRole> findAll();

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    UserRole findById(Integer id);

    /***
     * 新增用户角色关系
     * @param userRole
     */
    void add(UserRole userRole);

    /***
     * 修改用户角色关系数据
     * @param userRole
     */
    void update(UserRole userRole);

    /***
     * 删除用户角色关系
     * @param id
     */
    void delete(Integer id);

    /***
     * 多条件搜索用户角色关系方法
     * @param searchMap
     * @return
     */
    List<UserRole> findList(Map<String, Object> searchMap);

    /***
     * 分页查询
     * @param page
     * @param size
     * @return
     */
    Page<UserRole> findPage(int page, int size);

    /***
     * 多条件分页查询
     * @param searchMap
     * @param page
     * @param size
     * @return
     */
    Page<UserRole> findPage(Map<String, Object> searchMap, int page, int size);
    
}
