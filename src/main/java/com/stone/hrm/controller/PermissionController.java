package com.stone.hrm.controller;
import com.alibaba.fastjson.JSONArray;
import com.stone.hrm.common.entity.PageResult;
import com.stone.hrm.common.entity.Result;
import com.stone.hrm.common.entity.StatusCode;
import com.stone.hrm.service.PermissionService;
import com.stone.hrm.pojo.Permission;
import com.github.pagehelper.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

@Api(tags = "系统管理：权限管理")
@RestController
@CrossOrigin
@RequestMapping("/permission")
public class PermissionController {


    @Autowired
    private PermissionService permissionService;

    /**
     * 查询全部数据
     * @return
     */
    @ApiOperation("查询所有权限")
    @GetMapping
    public Result findAll(){
        List<Permission> permissionList = permissionService.findAll();
        return new Result(true, StatusCode.OK,"查询成功",permissionList) ;
    }

    @ApiOperation("查询所有权限返回树形数据")
    @GetMapping("/tree")
    public Result findAllToTree(){
        JSONArray permissionTree = permissionService.findAllToTree();
        return new Result(true, StatusCode.OK,"查询成功",permissionTree);
    }

    /***
     * 根据ID查询数据
     * @param id
     * @return
     */
    @ApiOperation("查询指定权限")
    @GetMapping("/{id}")
    public Result findById(@PathVariable Integer id){
        Permission permission = permissionService.findById(id);
        return new Result(true,StatusCode.OK,"查询成功",permission);
    }


    /***
     * 新增数据
     * @param permission
     * @return
     */
    @ApiOperation("添加权限")
    @PostMapping
    public Result add(@RequestBody Permission permission){
        permissionService.add(permission);
        return new Result(true,StatusCode.OK,"添加成功");
    }


    /***
     * 修改数据
     * @param permission
     * @param id
     * @return
     */
    @ApiOperation("修改权限")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody Permission permission,@PathVariable Integer id){
        permission.setId(id);
        permission.setUpdateTime(Calendar.getInstance().getTime());
        permissionService.update(permission);
        return new Result(true,StatusCode.OK,"修改成功");
    }


    /***
     * 根据ID删除数据
     * @param id
     * @return
     */
    @ApiOperation("删除权限")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Integer id){
        permissionService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 多条件搜索数据
     * @param searchMap
     * @return
     */
    @ApiOperation("根据条件查询权限")
    @GetMapping(value = "/search" )
    public Result findList(@RequestParam Map searchMap){
        List<Permission> list = permissionService.findList(searchMap);
        return new Result(true,StatusCode.OK,"查询成功",list);
    }


    /***
     * 分页搜索实现
     * @param searchMap
     * @param page
     * @param size
     * @return
     */
    @ApiOperation("根据条件查询权限并分页显示")
    @GetMapping(value = "/search/{page}/{size}" )
    public Result findPage(@RequestParam Map searchMap, @PathVariable  int page, @PathVariable  int size){
        Page<Permission> pageList = permissionService.findPage(searchMap, page, size);
        PageResult pageResult=new PageResult(pageList.getTotal(),pageList.getResult());
        return new Result(true,StatusCode.OK,"查询成功",pageResult);
    }

    /**
     * 修改状态
     *
     */
    @ApiOperation("修改权限状态")
    @PutMapping(value = "/{id}/status/{status}")
    public Result updateStatus(@PathVariable Integer id, @PathVariable Integer status) {
        permissionService.updateStatusById(status, id);
        return new Result(true, StatusCode.OK, "修改成功");
    }

}
