package com.stone.hrm.service;

import com.alibaba.fastjson.JSONArray;
import com.stone.hrm.pojo.Permission;
import com.github.pagehelper.Page;

import java.util.List;
import java.util.Map;

public interface PermissionService {

    /***
     * 查询所有权限
     * @return
     */
    List<Permission> findAll();

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    Permission findById(Integer id);

    /***
     * 新增权限
     * @param permission
     */
    void add(Permission permission);

    /***
     * 修改权限数据
     * @param permission
     */
    void update(Permission permission);

    /***
     * 删除权限
     * @param id
     */
    void delete(Integer id);

    /***
     * 多条件搜索权限方法
     * @param searchMap
     * @return
     */
    List<Permission> findList(Map<String, Object> searchMap);

    /***
     * 分页查询
     * @param page
     * @param size
     * @return
     */
    Page<Permission> findPage(int page, int size);

    /***
     * 多条件分页查询
     * @param searchMap
     * @param page
     * @param size
     * @return
     */
    Page<Permission> findPage(Map<String, Object> searchMap, int page, int size);

    /**
     * 查询所有权限返回树形数据
     * @return
     */
    JSONArray findAllToTree();
}
