package com.stone.hrm.service.impl;

import com.stone.hrm.dao.EmployeestateMapper;
import com.stone.hrm.pojo.Employeestate;
import com.stone.hrm.service.EmployeestateService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@Service
public class EmployeestateServiceImpl implements EmployeestateService {

    @Autowired
    private EmployeestateMapper employeestateMapper;

    /**
     * 查询全部列表
     * @return
     */
    @Override
    public List<Employeestate> findAll() {
        return employeestateMapper.selectAll();
    }

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    @Override
    public Employeestate findById(Integer id){
        return  employeestateMapper.selectByPrimaryKey(id);
    }


    /**
     * 增加
     * @param employeestate
     */
    @Override
    public void add(Employeestate employeestate){
        employeestateMapper.insert(employeestate);
    }


    /**
     * 修改
     * @param employeestate
     */
    @Override
    public void update(Employeestate employeestate){
        employeestateMapper.updateByPrimaryKey(employeestate);
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public void delete(Integer id){
        employeestateMapper.deleteByPrimaryKey(id);
    }


    /**
     * 条件查询
     * @param searchMap
     * @return
     */
    @Override
    public List<Employeestate> findList(Map<String, Object> searchMap){
        Example example = createExample(searchMap);
        return employeestateMapper.selectByExample(example);
    }

    /**
     * 分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public Page<Employeestate> findPage(int page, int size){
        PageHelper.startPage(page,size);
        return (Page<Employeestate>)employeestateMapper.selectAll();
    }

    /**
     * 条件+分页查询
     * @param searchMap 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public Page<Employeestate> findPage(Map<String,Object> searchMap, int page, int size){
        PageHelper.startPage(page,size);
        Example example = createExample(searchMap);
        return (Page<Employeestate>)employeestateMapper.selectByExample(example);
    }

    /**
     * 构建查询对象
     * @param searchMap
     * @return
     */
    private Example createExample(Map<String, Object> searchMap){
        Example example=new Example(Employeestate.class);
        Example.Criteria criteria = example.createCriteria();
        if(searchMap!=null){
            // 员工状态
            if(searchMap.get("state")!=null && !"".equals(searchMap.get("state"))){
                criteria.andLike("state","%"+searchMap.get("state")+"%");
           	}

            // ID
            if(searchMap.get("id")!=null ){
                criteria.andEqualTo("id",searchMap.get("id"));
            }

        }
        return example;
    }

}
