package com.stone.hrm.service.impl;

import com.stone.hrm.dao.EmployeeMapper;
import com.stone.hrm.pojo.Employee;
import com.stone.hrm.service.EmployeeService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    /**
     * 查询全部列表
     * @return
     */
    @Override
    public List<Employee> findAll() {
        return employeeMapper.selectAll();
    }

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    @Override
    public Employee findById(Integer id){
        return  employeeMapper.selectByPrimaryKey(id);
    }


    /**
     * 增加
     * @param employee
     */
    @Override
    public void add(Employee employee){
        employeeMapper.insert(employee);
    }


    /**
     * 修改
     * @param employee
     */
    @Override
    public void update(Employee employee){
        employeeMapper.updateByPrimaryKey(employee);
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public void delete(Integer id){
        employeeMapper.deleteByPrimaryKey(id);
    }


    /**
     * 条件查询
     * @param searchMap
     * @return
     */
    @Override
    public List<Employee> findList(Map<String, Object> searchMap){
        Example example = createExample(searchMap);
        return employeeMapper.selectByExample(example);
    }

    /**
     * 分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public Page<Employee> findPage(int page, int size){
        PageHelper.startPage(page,size);
        return (Page<Employee>)employeeMapper.selectAll();
    }

    /**
     * 条件+分页查询
     * @param searchMap 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public Page<Employee> findPage(Map<String,Object> searchMap, int page, int size){
        PageHelper.startPage(page,size);
        Example example = createExample(searchMap);
        return (Page<Employee>)employeeMapper.selectByExample(example);
    }

    /**
     * 构建查询对象
     * @param searchMap
     * @return
     */
    private Example createExample(Map<String, Object> searchMap){
        Example example=new Example(Employee.class);
        Example.Criteria criteria = example.createCriteria();
        if(searchMap!=null){
            // 员工姓名
            if(searchMap.get("name")!=null && !"".equals(searchMap.get("name"))){
                criteria.andLike("name","%"+searchMap.get("name")+"%");
           	}
            // 员工工号
            if(searchMap.get("username")!=null && !"".equals(searchMap.get("username"))){
                criteria.andLike("username","%"+searchMap.get("username")+"%");
           	}
            // 登录密码
            if(searchMap.get("password")!=null && !"".equals(searchMap.get("password"))){
                criteria.andLike("password","%"+searchMap.get("password")+"%");
           	}
            // 在职状态
            if(searchMap.get("state")!=null && !"".equals(searchMap.get("state"))){
                criteria.andLike("state","%"+searchMap.get("state")+"%");
           	}
            // 领导工号
            if(searchMap.get("managername")!=null && !"".equals(searchMap.get("managername"))){
                criteria.andLike("managername","%"+searchMap.get("managername")+"%");
           	}
            // 性别
            if(searchMap.get("sex")!=null && !"".equals(searchMap.get("sex"))){
                criteria.andLike("sex","%"+searchMap.get("sex")+"%");
           	}
            // 手机
            if(searchMap.get("phone")!=null && !"".equals(searchMap.get("phone"))){
                criteria.andLike("phone","%"+searchMap.get("phone")+"%");
           	}
            // 邮箱
            if(searchMap.get("mail")!=null && !"".equals(searchMap.get("mail"))){
                criteria.andLike("mail","%"+searchMap.get("mail")+"%");
           	}
            // 婚姻状态：单身，已婚，离异，丧偶
            if(searchMap.get("marriage")!=null && !"".equals(searchMap.get("marriage"))){
                criteria.andLike("marriage","%"+searchMap.get("marriage")+"%");
           	}
            // 国籍
            if(searchMap.get("national")!=null && !"".equals(searchMap.get("national"))){
                criteria.andLike("national","%"+searchMap.get("national")+"%");
           	}
            // 地址
            if(searchMap.get("address")!=null && !"".equals(searchMap.get("address"))){
                criteria.andLike("address","%"+searchMap.get("address")+"%");
           	}
            // 学历
            if(searchMap.get("education")!=null && !"".equals(searchMap.get("education"))){
                criteria.andLike("education","%"+searchMap.get("education")+"%");
           	}
            // 学位
            if(searchMap.get("degree")!=null && !"".equals(searchMap.get("degree"))){
                criteria.andLike("degree","%"+searchMap.get("degree")+"%");
           	}
            // 毕业院校
            if(searchMap.get("graduation_school")!=null && !"".equals(searchMap.get("graduation_school"))){
                criteria.andLike("graduation_school","%"+searchMap.get("graduation_school")+"%");
           	}
            // 职位编码
            if(searchMap.get("job_code")!=null && !"".equals(searchMap.get("job_code"))){
                criteria.andLike("job_code","%"+searchMap.get("job_code")+"%");
           	}
            // 银行名称
            if(searchMap.get("bank_name")!=null && !"".equals(searchMap.get("bank_name"))){
                criteria.andLike("bank_name","%"+searchMap.get("bank_name")+"%");
           	}
            // 银行卡号
            if(searchMap.get("bank_number")!=null && !"".equals(searchMap.get("bank_number"))){
                criteria.andLike("bank_number","%"+searchMap.get("bank_number")+"%");
           	}
            // 政治面貌
            if(searchMap.get("political_visage")!=null && !"".equals(searchMap.get("political_visage"))){
                criteria.andLike("political_visage","%"+searchMap.get("political_visage")+"%");
           	}
            // 身份证
            if(searchMap.get("id_card")!=null && !"".equals(searchMap.get("id_card"))){
                criteria.andLike("id_card","%"+searchMap.get("id_card")+"%");
           	}

            // ID
            if(searchMap.get("id")!=null ){
                criteria.andEqualTo("id",searchMap.get("id"));
            }

        }
        return example;
    }

}
