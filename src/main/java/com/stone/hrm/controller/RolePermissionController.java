package com.stone.hrm.controller;
import com.stone.hrm.common.entity.PageResult;
import com.stone.hrm.common.entity.Result;
import com.stone.hrm.common.entity.StatusCode;
import com.stone.hrm.service.RolePermissionService;
import com.stone.hrm.pojo.RolePermission;
import com.github.pagehelper.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@Api(tags = "系统管理：角色权限关联管理")
@RestController
@CrossOrigin
@RequestMapping("/rolePermission")
public class RolePermissionController {


    @Autowired
    private RolePermissionService rolePermissionService;

    /**
     * 查询全部数据
     * @return
     */
    @ApiOperation("查询所有角色权限关联")
    @GetMapping
    public Result findAll(){
        List<RolePermission> rolePermissionList = rolePermissionService.findAll();
        return new Result(true, StatusCode.OK,"查询成功",rolePermissionList) ;
    }

    /***
     * 根据ID查询数据
     * @param id
     * @return
     */
    @ApiOperation("查询指定角色权限关联")
    @GetMapping("/{id}")
    public Result findById(@PathVariable Integer id){
        RolePermission rolePermission = rolePermissionService.findById(id);
        return new Result(true,StatusCode.OK,"查询成功",rolePermission);
    }


    /***
     * 新增数据
     * @param rolePermission
     * @return
     */
    @ApiOperation("添加角色权限关联")
    @PostMapping
    public Result add(@RequestBody RolePermission rolePermission){
        rolePermissionService.add(rolePermission);
        return new Result(true,StatusCode.OK,"添加成功");
    }


    /***
     * 修改数据
     * @param rolePermission
     * @param id
     * @return
     */
    @ApiOperation("修改角色权限关联")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody RolePermission rolePermission,@PathVariable Integer id){
        rolePermission.setId(id);
        rolePermissionService.update(rolePermission);
        return new Result(true,StatusCode.OK,"修改成功");
    }


    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation("删除角色权限关联")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Integer id){
        rolePermissionService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 多条件搜索品牌数据
     * @param searchMap
     * @return
     */
    @ApiOperation("根据条件查询角色权限关联")
    @GetMapping(value = "/search" )
    public Result findList(@RequestParam Map searchMap){
        List<RolePermission> list = rolePermissionService.findList(searchMap);
        return new Result(true,StatusCode.OK,"查询成功",list);
    }


    /***
     * 分页搜索实现
     * @param searchMap
     * @param page
     * @param size
     * @return
     */
    @ApiOperation("根据条件查询角色权限关联并分页显示")
    @GetMapping(value = "/search/{page}/{size}" )
    public Result findPage(@RequestParam Map searchMap, @PathVariable  int page, @PathVariable  int size){
        Page<RolePermission> pageList = rolePermissionService.findPage(searchMap, page, size);
        PageResult pageResult=new PageResult(pageList.getTotal(),pageList.getResult());
        return new Result(true,StatusCode.OK,"查询成功",pageResult);
    }

    /***
     * 根据角色ID查询数据
     * @param roleId
     * @return
     */
    @ApiOperation("查询指定角色的权限")
    @GetMapping("/role/{roleId}")
    public Result findByRoleId(@PathVariable Integer roleId){
        List<RolePermission> rolePermissionList = rolePermissionService.findByRoleId(roleId);
        return new Result(true,StatusCode.OK,"查询成功",rolePermissionList);
    }

    /**
     *
     * @param roleId
     * @return
     */
    @ApiOperation("修改角色对应的权限")
    @PostMapping(value = "/role/{roleId}" )
    public Result updateByRoleId(@PathVariable Integer roleId, @RequestBody List<RolePermission> rolePermissionList){
        rolePermissionService.updateByRoleId(roleId, rolePermissionList);
        return new Result(true,StatusCode.OK,"修改角色成功");
    }

}
