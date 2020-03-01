package com.stone.hrm.service;


import com.github.pagehelper.Page;
import com.stone.hrm.pojo.Icon;

import java.util.List;
import java.util.Map;

public interface IconService {

    /***
     * 查询所有品牌
     * @return
     */
    List<Icon> findAll();

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    Icon findById(Integer id);

    /***
     * 新增品牌
     * @param icon
     */
    void add(Icon icon);

    /***
     * 修改品牌数据
     * @param icon
     */
    void update(Icon icon);

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
    List<Icon> findList(Map<String, Object> searchMap);

    /***
     * 分页查询
     * @param page
     * @param size
     * @return
     */
    Page<Icon> findPage(int page, int size);

    /***
     * 多条件分页查询
     * @param searchMap
     * @param page
     * @param size
     * @return
     */
    Page<Icon> findPage(Map<String, Object> searchMap, int page, int size);

}
