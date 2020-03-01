package com.stone.hrm.service.impl;

import com.stone.hrm.dao.IconMapper;
import com.stone.hrm.pojo.Icon;
import com.stone.hrm.service.IconService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@Service
public class IconServiceImpl implements IconService {

    @Autowired
    private IconMapper iconMapper;

    /**
     * 查询全部列表
     * @return
     */
    @Override
    public List<Icon> findAll() {
        return iconMapper.selectAll();
    }

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    @Override
    public Icon findById(Integer id){
        return  iconMapper.selectByPrimaryKey(id);
    }


    /**
     * 增加
     * @param icon
     */
    @Override
    public void add(Icon icon){
        iconMapper.insert(icon);
    }


    /**
     * 修改
     * @param icon
     */
    @Override
    public void update(Icon icon){
        iconMapper.updateByPrimaryKey(icon);
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public void delete(Integer id){
        iconMapper.deleteByPrimaryKey(id);
    }


    /**
     * 条件查询
     * @param searchMap
     * @return
     */
    @Override
    public List<Icon> findList(Map<String, Object> searchMap){
        Example example = createExample(searchMap);
        return iconMapper.selectByExample(example);
    }

    /**
     * 分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public Page<Icon> findPage(int page, int size){
        PageHelper.startPage(page,size);
        return (Page<Icon>)iconMapper.selectAll();
    }

    /**
     * 条件+分页查询
     * @param searchMap 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public Page<Icon> findPage(Map<String,Object> searchMap, int page, int size){
        PageHelper.startPage(page,size);
        Example example = createExample(searchMap);
        return (Page<Icon>)iconMapper.selectByExample(example);
    }

    /**
     * 构建查询对象
     * @param searchMap
     * @return
     */
    private Example createExample(Map<String, Object> searchMap){
        Example example=new Example(Icon.class);
        Example.Criteria criteria = example.createCriteria();
        if(searchMap!=null){
            // name
            if(searchMap.get("name")!=null && !"".equals(searchMap.get("name"))){
                criteria.andLike("name","%"+searchMap.get("name")+"%");
           	}

            // id
            if(searchMap.get("id")!=null ){
                criteria.andEqualTo("id",searchMap.get("id"));
            }

        }
        return example;
    }

}
