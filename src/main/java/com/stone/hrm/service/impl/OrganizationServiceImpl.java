package com.stone.hrm.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.stone.hrm.common.util.TreeUtils;
import com.stone.hrm.dao.OrganizationMapper;
import com.stone.hrm.pojo.Organization;
import com.stone.hrm.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class OrganizationServiceImpl implements OrganizationService {

    @Autowired
    private OrganizationMapper organizationMapper;

    /**
     * 查询全部列表
     * @return
     */
    @Override
    public List<Organization> findAll() {
        return organizationMapper.selectAll();
    }

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    @Override
    public Organization findById(Integer id){
        return  organizationMapper.selectByPrimaryKey(id);
    }


    /**
     * 增加
     * @param organization
     */
    @Override
    public void add(Organization organization){
        organizationMapper.insert(organization);
    }


    /**
     * 修改
     * @param organization
     */
    @Override
    public void update(Organization organization){
        organizationMapper.updateByPrimaryKey(organization);
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public void delete(Integer id){
        organizationMapper.deleteByPrimaryKey(id);
        organizationMapper.deleteByParentId(id);
    }


    /**
     * 条件查询
     * @param searchMap
     * @return
     */
    @Override
    public List<Organization> findList(Map<String, Object> searchMap){
        Example example = createExample(searchMap);
        return organizationMapper.selectByExample(example);
    }

    /**
     * 分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public Page<Organization> findPage(int page, int size){
        PageHelper.startPage(page,size);
        return (Page<Organization>)organizationMapper.selectAll();
    }

    /**
     * 条件+分页查询
     * @param searchMap 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public Page<Organization> findPage(Map<String,Object> searchMap, int page, int size){
        PageHelper.startPage(page,size);
        Example example = createExample(searchMap);
        return (Page<Organization>)organizationMapper.selectByExample(example);
    }

    @Override
    public JSONArray findAllToTree() {
        List<Organization> organizations = organizationMapper.selectAll();
        JSONArray array = new JSONArray();
        TreeUtils.setOrganizationsTree(0, organizations, array);
        return array;
    }

    @Override
    public void updateStatusById(Integer status, Integer id) {
        organizationMapper.updateStatusById(status, id);
        organizationMapper.updateStatusByParentId(status, id);
    }

    /**
     * 构建查询对象
     * @param searchMap
     * @return
     */
    private Example createExample(Map<String, Object> searchMap){
        Example example=new Example(Organization.class);
        Example.Criteria criteria = example.createCriteria();
        if(searchMap!=null){
            // 组织名称
            if(searchMap.get("name")!=null && !"".equals(searchMap.get("name"))){
                criteria.andLike("name","%"+searchMap.get("name")+"%");
           	}
            // 组织代码
            if(searchMap.get("code")!=null && !"".equals(searchMap.get("code"))){
                criteria.andLike("code","%"+searchMap.get("code")+"%");
           	}
            // 组织地址
            if(searchMap.get("address")!=null && !"".equals(searchMap.get("address"))){
                criteria.andLike("address","%"+searchMap.get("address")+"%");
           	}
            // 法人代表
            if(searchMap.get("legal_representative")!=null && !"".equals(searchMap.get("legal_representative"))){
                criteria.andLike("legal_representative","%"+searchMap.get("legal_representative")+"%");
           	}
            // 组织电话
            if(searchMap.get("phone")!=null && !"".equals(searchMap.get("phone"))){
                criteria.andLike("phone","%"+searchMap.get("phone")+"%");
           	}
            // 组织邮箱
            if(searchMap.get("mail")!=null && !"".equals(searchMap.get("mail"))){
                criteria.andLike("mail","%"+searchMap.get("mail")+"%");
           	}

            // ID
            if(searchMap.get("id")!=null ){
                criteria.andEqualTo("id",searchMap.get("id"));
            }
            // 父级ID
            if(searchMap.get("pid")!=null ){
                criteria.andEqualTo("pid",searchMap.get("pid"));
            }
            // 状态：0为禁用，1为启用
            if(searchMap.get("status")!=null ){
                criteria.andEqualTo("status",searchMap.get("status"));
            }

        }
        return example;
    }

}
