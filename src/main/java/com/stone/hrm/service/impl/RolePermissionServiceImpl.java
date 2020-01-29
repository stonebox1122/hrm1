package com.stone.hrm.service.impl;

import com.stone.hrm.dao.RolePermissionMapper;
import com.stone.hrm.service.RolePermissionService;
import com.stone.hrm.pojo.RolePermission;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@Service
public class RolePermissionServiceImpl implements RolePermissionService {

    @Autowired
    private RolePermissionMapper rolePermissionMapper;

    /**
     * 查询全部列表
     * @return
     */
    @Override
    public List<RolePermission> findAll() {
        return rolePermissionMapper.selectAll();
    }

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    @Override
    public RolePermission findById(Integer id){
        return  rolePermissionMapper.selectByPrimaryKey(id);
    }


    /**
     * 增加
     * @param rolePermission
     */
    @Override
    public void add(RolePermission rolePermission){
        rolePermissionMapper.insert(rolePermission);
    }


    /**
     * 修改
     * @param rolePermission
     */
    @Override
    public void update(RolePermission rolePermission){
        rolePermissionMapper.updateByPrimaryKey(rolePermission);
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public void delete(Integer id){
        rolePermissionMapper.deleteByPrimaryKey(id);
    }


    /**
     * 条件查询
     * @param searchMap
     * @return
     */
    @Override
    public List<RolePermission> findList(Map<String, Object> searchMap){
        Example example = createExample(searchMap);
        return rolePermissionMapper.selectByExample(example);
    }

    /**
     * 分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public Page<RolePermission> findPage(int page, int size){
        PageHelper.startPage(page,size);
        return (Page<RolePermission>)rolePermissionMapper.selectAll();
    }

    /**
     * 条件+分页查询
     * @param searchMap 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public Page<RolePermission> findPage(Map<String,Object> searchMap, int page, int size){
        PageHelper.startPage(page,size);
        Example example = createExample(searchMap);
        return (Page<RolePermission>)rolePermissionMapper.selectByExample(example);
    }

    /**
     * 构建查询对象
     * @param searchMap
     * @return
     */
    private Example createExample(Map<String, Object> searchMap){
        Example example=new Example(RolePermission.class);
        Example.Criteria criteria = example.createCriteria();
        if(searchMap!=null){

            // ID
            if(searchMap.get("id")!=null ){
                criteria.andEqualTo("id",searchMap.get("id"));
            }
            // 角色ID
            if(searchMap.get("roleId")!=null ){
                criteria.andEqualTo("roleId",searchMap.get("roleId"));
            }
            // 权限ID
            if(searchMap.get("permissionId")!=null ){
                criteria.andEqualTo("permissionId",searchMap.get("permissionId"));
            }

        }
        return example;
    }

}
