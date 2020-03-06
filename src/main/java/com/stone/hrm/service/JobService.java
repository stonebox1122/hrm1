package com.stone.hrm.service;

import com.github.pagehelper.Page;
import com.stone.hrm.pojo.Job;

import java.util.List;
import java.util.Map;

public interface JobService {

    /***
     * 查询所有品牌
     * @return
     */
    List<Job> findAll();

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    Job findById(Integer id);

    /***
     * 新增品牌
     * @param job
     */
    void add(Job job);

    /***
     * 修改品牌数据
     * @param job
     */
    void update(Job job);

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
    List<Job> findList(Map<String, Object> searchMap);

    /***
     * 分页查询
     * @param page
     * @param size
     * @return
     */
    Page<Job> findPage(int page, int size);

    /***
     * 多条件分页查询
     * @param searchMap
     * @param page
     * @param size
     * @return
     */
    Page<Job> findPage(Map<String, Object> searchMap, int page, int size);




}
