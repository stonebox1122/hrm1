package com.stone.hrm.service;

import com.github.pagehelper.Page;
import com.stone.hrm.pojo.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeService {

    /***
     * 查询所有品牌
     * @return
     */
    List<Employee> findAll();

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    Employee findById(Integer id);

    /***
     * 新增品牌
     * @param employee
     */
    void add(Employee employee);

    /***
     * 修改品牌数据
     * @param employee
     */
    void update(Employee employee);

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
    List<Employee> findList(Map<String, Object> searchMap);

    /***
     * 分页查询
     * @param page
     * @param size
     * @return
     */
    Page<Employee> findPage(int page, int size);

    /***
     * 多条件分页查询
     * @param searchMap
     * @param page
     * @param size
     * @return
     */
    Page<Employee> findPage(Map<String, Object> searchMap, int page, int size);

    List<Employee> findManagerByOrganizationId(Integer organizationId);
}
