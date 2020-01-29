package com.stone.hrm.service.impl;

import com.stone.hrm.dao.UserRoleMapper;
import com.stone.hrm.service.UserRoleService;
import com.stone.hrm.pojo.UserRole;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    private UserRoleMapper userRoleMapper;

    /**
     * 查询全部列表
     * @return
     */
    @Override
    public List<UserRole> findAll() {
        return userRoleMapper.selectAll();
    }

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    @Override
    public UserRole findById(Integer id){
        return  userRoleMapper.selectByPrimaryKey(id);
    }


    /**
     * 增加
     * @param userRole
     */
    @Override
    public void add(UserRole userRole){
        userRoleMapper.insert(userRole);
    }


    /**
     * 修改
     * @param userRole
     */
    @Override
    public void update(UserRole userRole){
        userRoleMapper.updateByPrimaryKey(userRole);
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public void delete(Integer id){
        userRoleMapper.deleteByPrimaryKey(id);
    }


    /**
     * 条件查询
     * @param searchMap
     * @return
     */
    @Override
    public List<UserRole> findList(Map<String, Object> searchMap){
        Example example = createExample(searchMap);
        return userRoleMapper.selectByExample(example);
    }

    /**
     * 分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public Page<UserRole> findPage(int page, int size){
        PageHelper.startPage(page,size);
        return (Page<UserRole>)userRoleMapper.selectAll();
    }

    /**
     * 条件+分页查询
     * @param searchMap 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public Page<UserRole> findPage(Map<String,Object> searchMap, int page, int size){
        PageHelper.startPage(page,size);
        Example example = createExample(searchMap);
        return (Page<UserRole>)userRoleMapper.selectByExample(example);
    }

    /**
     * 构建查询对象
     * @param searchMap
     * @return
     */
    private Example createExample(Map<String, Object> searchMap){
        Example example=new Example(UserRole.class);
        Example.Criteria criteria = example.createCriteria();
        if(searchMap!=null){

            // ID
            if(searchMap.get("id")!=null ){
                criteria.andEqualTo("id",searchMap.get("id"));
            }
            // 用户ID
            if(searchMap.get("userId")!=null ){
                criteria.andEqualTo("userId",searchMap.get("userId"));
            }
            // 角色ID
            if(searchMap.get("roleId")!=null ){
                criteria.andEqualTo("roleId",searchMap.get("roleId"));
            }

        }
        return example;
    }

}
