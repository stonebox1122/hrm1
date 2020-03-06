package com.stone.hrm.service;

import com.github.pagehelper.Page;
import com.stone.hrm.pojo.Leavetype;

import java.util.List;
import java.util.Map;

public interface LeavetypeService {

    /***
     * 查询所有品牌
     * @return
     */
    List<Leavetype> findAll();

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    Leavetype findById(Integer id);

    /***
     * 新增品牌
     * @param leavetype
     */
    void add(Leavetype leavetype);

    /***
     * 修改品牌数据
     * @param leavetype
     */
    void update(Leavetype leavetype);

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
    List<Leavetype> findList(Map<String, Object> searchMap);

    /***
     * 分页查询
     * @param page
     * @param size
     * @return
     */
    Page<Leavetype> findPage(int page, int size);

    /***
     * 多条件分页查询
     * @param searchMap
     * @param page
     * @param size
     * @return
     */
    Page<Leavetype> findPage(Map<String, Object> searchMap, int page, int size);




}
