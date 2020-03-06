package com.stone.hrm.service.impl;

import com.stone.hrm.dao.LeavetypeMapper;
import com.stone.hrm.pojo.Leavetype;
import com.stone.hrm.service.LeavetypeService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@Service
public class LeavetypeServiceImpl implements LeavetypeService {

    @Autowired
    private LeavetypeMapper leavetypeMapper;

    /**
     * 查询全部列表
     * @return
     */
    @Override
    public List<Leavetype> findAll() {
        return leavetypeMapper.selectAll();
    }

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    @Override
    public Leavetype findById(Integer id){
        return  leavetypeMapper.selectByPrimaryKey(id);
    }


    /**
     * 增加
     * @param leavetype
     */
    @Override
    public void add(Leavetype leavetype){
        leavetypeMapper.insert(leavetype);
    }


    /**
     * 修改
     * @param leavetype
     */
    @Override
    public void update(Leavetype leavetype){
        leavetypeMapper.updateByPrimaryKey(leavetype);
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public void delete(Integer id){
        leavetypeMapper.deleteByPrimaryKey(id);
    }


    /**
     * 条件查询
     * @param searchMap
     * @return
     */
    @Override
    public List<Leavetype> findList(Map<String, Object> searchMap){
        Example example = createExample(searchMap);
        return leavetypeMapper.selectByExample(example);
    }

    /**
     * 分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public Page<Leavetype> findPage(int page, int size){
        PageHelper.startPage(page,size);
        return (Page<Leavetype>)leavetypeMapper.selectAll();
    }

    /**
     * 条件+分页查询
     * @param searchMap 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public Page<Leavetype> findPage(Map<String,Object> searchMap, int page, int size){
        PageHelper.startPage(page,size);
        Example example = createExample(searchMap);
        return (Page<Leavetype>)leavetypeMapper.selectByExample(example);
    }

    /**
     * 构建查询对象
     * @param searchMap
     * @return
     */
    private Example createExample(Map<String, Object> searchMap){
        Example example=new Example(Leavetype.class);
        Example.Criteria criteria = example.createCriteria();
        if(searchMap!=null){
            // 请假类型
            if(searchMap.get("type")!=null && !"".equals(searchMap.get("type"))){
                criteria.andLike("type","%"+searchMap.get("type")+"%");
           	}

            // ID
            if(searchMap.get("id")!=null ){
                criteria.andEqualTo("id",searchMap.get("id"));
            }

        }
        return example;
    }

}
