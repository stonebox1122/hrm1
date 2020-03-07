package com.stone.hrm.service.impl;

import com.stone.hrm.dao.JobMapper;
import com.stone.hrm.pojo.Job;
import com.stone.hrm.service.JobService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private JobMapper jobMapper;

    /**
     * 查询全部列表
     * @return
     */
    @Override
    public List<Job> findAll() {
        return jobMapper.selectAll();
    }

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    @Override
    public Job findById(Integer id){
        return  jobMapper.selectByPrimaryKey(id);
    }


    /**
     * 增加
     * @param job
     */
    @Override
    public void add(Job job){
        jobMapper.insert(job);
    }


    /**
     * 修改
     * @param job
     */
    @Override
    public void update(Job job){
        jobMapper.updateByPrimaryKey(job);
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public void delete(Integer id){
        jobMapper.deleteByPrimaryKey(id);
    }


    /**
     * 条件查询
     * @param searchMap
     * @return
     */
    @Override
    public List<Job> findList(Map<String, Object> searchMap){
        Example example = createExample(searchMap);
        return jobMapper.selectByExample(example);
    }

    /**
     * 分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public Page<Job> findPage(int page, int size){
        PageHelper.startPage(page,size);
        return (Page<Job>)jobMapper.selectAll();
    }

    /**
     * 条件+分页查询
     * @param searchMap 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public Page<Job> findPage(Map<String,Object> searchMap, int page, int size){
        PageHelper.startPage(page,size);
        Example example = createExample(searchMap);
        return (Page<Job>)jobMapper.selectByExample(example);
    }

    /**
     * 构建查询对象
     * @param searchMap
     * @return
     */
    private Example createExample(Map<String, Object> searchMap){
        Example example=new Example(Job.class);
        Example.Criteria criteria = example.createCriteria();
        if(searchMap!=null){
            // 职位名称
            if(searchMap.get("name")!=null && !"".equals(searchMap.get("name"))){
                criteria.andLike("name","%"+searchMap.get("name")+"%");
           	}
            // 职位编码
            if(searchMap.get("code")!=null && !"".equals(searchMap.get("code"))){
                criteria.andLike("code","%"+searchMap.get("code")+"%");
           	}

            // ID
            if(searchMap.get("id")!=null ){
                criteria.andEqualTo("id",searchMap.get("id"));
            }
            // 部门编码
            if(searchMap.get("departmentId")!=null ){
                criteria.andEqualTo("departmentId",searchMap.get("departmentId"));
            }
            // 状态：0为禁用，1为启用
            if(searchMap.get("status")!=null ){
                criteria.andEqualTo("status",searchMap.get("status"));
            }

        }
        return example;
    }

}
