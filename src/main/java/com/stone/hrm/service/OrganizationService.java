package com.stone.hrm.service;

import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.Page;
import com.stone.hrm.pojo.Organization;

import java.util.List;
import java.util.Map;

public interface OrganizationService {

    /***
     * 查询所有品牌
     * @return
     */
    List<Organization> findAll();

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    Organization findById(Integer id);

    /***
     * 新增品牌
     * @param organization
     */
    void add(Organization organization);

    /***
     * 修改品牌数据
     * @param organization
     */
    void update(Organization organization);

    /***
     * 删除品牌
     * @param id
     */
    void delete(Integer id);

    /***
     * 多条件搜索品牌方法
     * @param searchMap
     * @return
     */
    List<Organization> findList(Map<String, Object> searchMap);

    /***
     * 分页查询
     * @param page
     * @param size
     * @return
     */
    Page<Organization> findPage(int page, int size);

    /***
     * 多条件分页查询
     * @param searchMap
     * @param page
     * @param size
     * @return
     */
    Page<Organization> findPage(Map<String, Object> searchMap, int page, int size);

    /**
     * 查询所有组织返回树形数据
     * @return
     */
    JSONArray findAllToTree();

    /**
     * 修改组织状态
     * @param status
     * @param id
     */
    void updateStatusById(Integer status, Integer id);
}
