package com.stone.hrm.service;

import com.github.pagehelper.Page;
import com.stone.hrm.pojo.Employeestate;

import java.util.List;
import java.util.Map;

public interface EmployeestateService {

    /***
     * 查询所有品牌
     * @return
     */
    List<Employeestate> findAll();

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    Employeestate findById(Integer id);

    /***
     * 新增品牌
     * @param employeestate
     */
    void add(Employeestate employeestate);

    /***
     * 修改品牌数据
     * @param employeestate
     */
    void update(Employeestate employeestate);

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
    List<Employeestate> findList(Map<String, Object> searchMap);

    /***
     * 分页查询
     * @param page
     * @param size
     * @return
     */
    Page<Employeestate> findPage(int page, int size);

    /***
     * 多条件分页查询
     * @param searchMap
     * @param page
     * @param size
     * @return
     */
    Page<Employeestate> findPage(Map<String, Object> searchMap, int page, int size);




}
