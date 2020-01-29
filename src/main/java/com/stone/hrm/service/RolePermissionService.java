package com.stone.hrm.service;

import com.stone.hrm.pojo.RolePermission;
import com.github.pagehelper.Page;

import java.util.List;
import java.util.Map;

public interface RolePermissionService {

    /***
     * 查询所有角色权限关系
     * @return
     */
    List<RolePermission> findAll();

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    RolePermission findById(Integer id);

    /***
     * 新增角色权限关系
     * @param rolePermission
     */
    void add(RolePermission rolePermission);

    /***
     * 修改角色权限关系数据
     * @param rolePermission
     */
    void update(RolePermission rolePermission);

    /***
     * 删除角色权限关系
     * @param id
     */
    void delete(Integer id);

    /***
     * 多条件搜索角色权限关系方法
     * @param searchMap
     * @return
     */
    List<RolePermission> findList(Map<String, Object> searchMap);

    /***
     * 分页查询
     * @param page
     * @param size
     * @return
     */
    Page<RolePermission> findPage(int page, int size);

    /***
     * 多条件分页查询
     * @param searchMap
     * @param page
     * @param size
     * @return
     */
    Page<RolePermission> findPage(Map<String, Object> searchMap, int page, int size);




}
