package com.stone.hrm.service.impl;

import com.stone.hrm.dao.DepartmentMapper;
import com.stone.hrm.pojo.Department;
import com.stone.hrm.service.DepartmentService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    /**
     * 查询全部列表
     * @return
     */
    @Override
    public List<Department> findAll() {
        return departmentMapper.selectAll();
    }

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    @Override
    public Department findById(Integer id){
        return  departmentMapper.selectByPrimaryKey(id);
    }


    /**
     * 增加
     * @param department
     */
    @Override
    public void add(Department department){
        departmentMapper.insert(department);
    }


    /**
     * 修改
     * @param department
     */
    @Override
    public void update(Department department){
        departmentMapper.updateByPrimaryKey(department);
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public void delete(Integer id){
        departmentMapper.deleteByPrimaryKey(id);
    }


    /**
     * 条件查询
     * @param searchMap
     * @return
     */
    @Override
    public List<Department> findList(Map<String, Object> searchMap){
        Example example = createExample(searchMap);
        return departmentMapper.selectByExample(example);
    }

    /**
     * 分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public Page<Department> findPage(int page, int size){
        PageHelper.startPage(page,size);
        return (Page<Department>)departmentMapper.selectAll();
    }

    /**
     * 条件+分页查询
     * @param searchMap 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public Page<Department> findPage(Map<String,Object> searchMap, int page, int size){
        PageHelper.startPage(page,size);
        Example example = createExample(searchMap);
        return (Page<Department>)departmentMapper.selectByExample(example);
    }

    /**
     * 构建查询对象
     * @param searchMap
     * @return
     */
    private Example createExample(Map<String, Object> searchMap){
        Example example=new Example(Department.class);
        Example.Criteria criteria = example.createCriteria();
        if(searchMap!=null){
            // 部门名称
            if(searchMap.get("name")!=null && !"".equals(searchMap.get("name"))){
                criteria.andLike("name","%"+searchMap.get("name")+"%");
           	}
            // 部门编码
            if(searchMap.get("code")!=null && !"".equals(searchMap.get("code"))){
                criteria.andLike("code","%"+searchMap.get("code")+"%");
           	}
            // 组织编码
            if(searchMap.get("organization_code")!=null && !"".equals(searchMap.get("organization_code"))){
                criteria.andLike("organization_code","%"+searchMap.get("organization_code")+"%");
           	}
            // 父级部门编码
            if(searchMap.get("pcode")!=null && !"".equals(searchMap.get("pcode"))){
                criteria.andLike("pcode","%"+searchMap.get("pcode")+"%");
           	}

            // ID
            if(searchMap.get("id")!=null ){
                criteria.andEqualTo("id",searchMap.get("id"));
            }
            // 状态：0为禁用，1为启用
            if(searchMap.get("status")!=null ){
                criteria.andEqualTo("status",searchMap.get("status"));
            }

        }
        return example;
    }

}
