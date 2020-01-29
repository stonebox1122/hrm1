package com.stone.hrm.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.stone.hrm.common.util.TreeUtils;
import com.stone.hrm.dao.PermissionMapper;
import com.stone.hrm.service.PermissionService;
import com.stone.hrm.pojo.Permission;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

    /**
     * 查询全部列表
     * @return
     */
    @Override
    public List<Permission> findAll() {
        return permissionMapper.selectAll();
    }

    /**
     * 查询所有权限返回树形数据
     * @return
     */
    @Override
    public JSONArray findAllToTree() {
        List<Permission> permissions = permissionMapper.selectAll();
        JSONArray array = new JSONArray();
        TreeUtils.setPermissionsTree(0, permissions, array);
        return array;
    }

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    @Override
    public Permission findById(Integer id){
        return  permissionMapper.selectByPrimaryKey(id);
    }


    /**
     * 增加
     * @param permission
     */
    @Override
    public void add(Permission permission){
        permissionMapper.insert(permission);
    }


    /**
     * 修改
     * @param permission
     */
    @Override
    public void update(Permission permission){
        permissionMapper.updateByPrimaryKey(permission);
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public void delete(Integer id){
        permissionMapper.deleteByPrimaryKey(id);
        permissionMapper.deleteByParentId(id);
    }


    /**
     * 条件查询
     * @param searchMap
     * @return
     */
    @Override
    public List<Permission> findList(Map<String, Object> searchMap){
        Example example = createExample(searchMap);
        return permissionMapper.selectByExample(example);
    }

    /**
     * 分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public Page<Permission> findPage(int page, int size){
        PageHelper.startPage(page,size);
        return (Page<Permission>)permissionMapper.selectAll();
    }

    /**
     * 条件+分页查询
     * @param searchMap 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public Page<Permission> findPage(Map<String,Object> searchMap, int page, int size){
        PageHelper.startPage(page,size);
        Example example = createExample(searchMap);
        return (Page<Permission>)permissionMapper.selectByExample(example);
    }

    /**
     * 构建查询对象
     * @param searchMap
     * @return
     */
    private Example createExample(Map<String, Object> searchMap){
        Example example=new Example(Permission.class);
        Example.Criteria criteria = example.createCriteria();
        if(searchMap!=null){
            // 权限名称
            if(searchMap.get("name")!=null && !"".equals(searchMap.get("name"))){
                criteria.andLike("name","%"+searchMap.get("name")+"%");
           	}
            // CSS样式
            if(searchMap.get("css")!=null && !"".equals(searchMap.get("css"))){
                criteria.andLike("css","%"+searchMap.get("css")+"%");
           	}
            // 访问路径
            if(searchMap.get("path")!=null && !"".equals(searchMap.get("path"))){
                criteria.andLike("path","%"+searchMap.get("path")+"%");
           	}
            // 具体权限
            if(searchMap.get("permission")!=null && !"".equals(searchMap.get("permission"))){
                criteria.andLike("permission","%"+searchMap.get("permission")+"%");
           	}

            // 权限ID
            if(searchMap.get("id")!=null ){
                criteria.andEqualTo("id",searchMap.get("id"));
            }
            // 父权限ID
            if(searchMap.get("parentId")!=null ){
                criteria.andEqualTo("parentId",searchMap.get("parentId"));
            }
            // 权限类型 1为菜单 2为功能 3为API
            if(searchMap.get("type")!=null ){
                criteria.andEqualTo("type",searchMap.get("type"));
            }
            // 排序值
            if(searchMap.get("sort")!=null ){
                criteria.andEqualTo("sort",searchMap.get("sort"));
            }
            // 状态：0为禁用，1为启用
            if(searchMap.get("status")!=null ){
                criteria.andEqualTo("status",searchMap.get("status"));
            }

        }
        return example;
    }

}
