package com.stone.hrm.controller;
import com.stone.hrm.common.entity.PageResult;
import com.stone.hrm.common.entity.Result;
import com.stone.hrm.common.entity.StatusCode;
import com.stone.hrm.service.RolePermissionService;
import com.stone.hrm.pojo.RolePermission;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
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
    @GetMapping(value = "/search/{page}/{size}" )
    public Result findPage(@RequestParam Map searchMap, @PathVariable  int page, @PathVariable  int size){
        Page<RolePermission> pageList = rolePermissionService.findPage(searchMap, page, size);
        PageResult pageResult=new PageResult(pageList.getTotal(),pageList.getResult());
        return new Result(true,StatusCode.OK,"查询成功",pageResult);
    }

}
