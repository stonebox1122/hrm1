package com.stone.hrm.controller;
import com.alibaba.fastjson.JSONArray;
import com.stone.hrm.common.entity.PageResult;
import com.stone.hrm.common.entity.Result;
import com.stone.hrm.common.entity.StatusCode;
import com.stone.hrm.pojo.Organization;
import com.stone.hrm.service.OrganizationService;
import com.github.pagehelper.Page;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/organization")
public class OrganizationController {


    @Autowired
    private OrganizationService organizationService;

    /**
     * 查询全部数据
     * @return
     */
    @GetMapping
    public Result findAll(){
        List<Organization> organizationList = organizationService.findAll();
        return new Result(true, StatusCode.OK,"查询成功",organizationList) ;
    }

    /***
     * 根据ID查询数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result findById(@PathVariable Integer id){
        Organization organization = organizationService.findById(id);
        return new Result(true,StatusCode.OK,"查询成功",organization);
    }


    /***
     * 新增数据
     * @param organization
     * @return
     */
    @PostMapping
    public Result add(@RequestBody Organization organization){
        organizationService.add(organization);
        return new Result(true,StatusCode.OK,"添加成功");
    }


    /***
     * 修改数据
     * @param organization
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody Organization organization,@PathVariable Integer id){
        organization.setId(id);
        organization.setUpdateTime(Calendar.getInstance().getTime());
        organizationService.update(organization);
        return new Result(true,StatusCode.OK,"修改成功");
    }


    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Integer id){
        organizationService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 多条件搜索品牌数据
     * @param searchMap
     * @return
     */
    @GetMapping(value = "/search" )
    public Result findList(@RequestParam Map searchMap){
        List<Organization> list = organizationService.findList(searchMap);
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
        Page<Organization> pageList = organizationService.findPage(searchMap, page, size);
        PageResult pageResult=new PageResult(pageList.getTotal(),pageList.getResult());
        return new Result(true,StatusCode.OK,"查询成功",pageResult);
    }

    @ApiOperation("查询所有组织返回树形数据")
    @GetMapping("/tree")
    public Result findAllToTree(){
        JSONArray organizationTree = organizationService.findAllToTree();
        return new Result(true, StatusCode.OK,"查询成功",organizationTree);
    }

    /**
     * 修改状态
     *
     */
    @ApiOperation("修改组织状态")
    @PutMapping(value = "/{id}/status/{status}")
    public Result updateStatus(@PathVariable Integer id, @PathVariable Integer status) {
        organizationService.updateStatusById(status, id);
        return new Result(true, StatusCode.OK, "修改成功");
    }

}
