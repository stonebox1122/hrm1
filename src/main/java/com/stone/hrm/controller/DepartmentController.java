package com.stone.hrm.controller;
import com.alibaba.fastjson.JSONArray;
import com.stone.hrm.common.entity.PageResult;
import com.stone.hrm.common.entity.Result;
import com.stone.hrm.common.entity.StatusCode;
import com.stone.hrm.pojo.Department;
import com.stone.hrm.service.DepartmentService;
import com.github.pagehelper.Page;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/department")
public class DepartmentController {


    @Autowired
    private DepartmentService departmentService;

    /**
     * 查询全部数据
     * @return
     */
    @GetMapping
    public Result findAll(){
        List<Department> departmentList = departmentService.findAll();
        return new Result(true, StatusCode.OK,"查询成功",departmentList) ;
    }

    /***
     * 根据ID查询数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result findById(@PathVariable Integer id){
        Department department = departmentService.findById(id);
        return new Result(true,StatusCode.OK,"查询成功",department);
    }


    /***
     * 新增数据
     * @param department
     * @return
     */
    @PostMapping
    public Result add(@RequestBody Department department){
        departmentService.add(department);
        return new Result(true,StatusCode.OK,"添加成功");
    }


    /***
     * 修改数据
     * @param department
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody Department department,@PathVariable Integer id){
        department.setId(id);
        department.setUpdateTime(Calendar.getInstance().getTime());
        departmentService.update(department);
        return new Result(true,StatusCode.OK,"修改成功");
    }


    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Integer id){
        departmentService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 多条件搜索品牌数据
     * @param searchMap
     * @return
     */
    @GetMapping(value = "/search" )
    public Result findList(@RequestParam Map searchMap){
        List<Department> list = departmentService.findList(searchMap);
        return new Result(true,StatusCode.OK,"查询成功",list);
    }


    /***
     * 分页搜索实现
     * @param searchMap
     * @param page
     * @param size
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result findPage(@RequestParam Map searchMap, @PathVariable  int page, @PathVariable  int size){
        Page<Department> pageList = departmentService.findPage(searchMap, page, size);
        PageResult pageResult=new PageResult(pageList.getTotal(),pageList.getResult());
        return new Result(true,StatusCode.OK,"查询成功",pageResult);
    }

    @ApiOperation("查询所有部门返回树形数据")
    @GetMapping("/tree")
    public Result findAllToTree(){
        JSONArray departmentTree = departmentService.findAllToTree();
        return new Result(true, StatusCode.OK,"查询成功",departmentTree);
    }

    /**
     * 修改状态
     *
     */
    @ApiOperation("修改部门状态")
    @PutMapping(value = "/{id}/status/{status}")
    public Result updateStatus(@PathVariable Integer id, @PathVariable Integer status) {
        departmentService.updateStatusById(status, id);
        return new Result(true, StatusCode.OK, "修改成功");
    }

    @ApiOperation("根据组织Id查询所有部门返回树形数据")
    @GetMapping("/tree/{organizationId}")
    public Result findByOrganizationIdToTree(@PathVariable Integer organizationId){
        JSONArray departmentTree = departmentService.findByOrganizationIdToTree(organizationId);
        return new Result(true, StatusCode.OK,"查询成功",departmentTree);
    }
}
