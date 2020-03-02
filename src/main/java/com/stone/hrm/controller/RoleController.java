package com.stone.hrm.controller;
import com.stone.hrm.common.entity.PageResult;
import com.stone.hrm.common.entity.Result;
import com.stone.hrm.common.entity.StatusCode;
import com.stone.hrm.service.RoleService;
import com.stone.hrm.pojo.Role;
import com.github.pagehelper.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@Api(tags = "系统管理：角色管理")
@RestController
@CrossOrigin
@RequestMapping("/role")
public class RoleController {


    @Autowired
    private RoleService roleService;

    /**
     * 查询全部数据
     * @return
     */
    @ApiOperation("查询所有角色")
    @GetMapping
    public Result findAll(){
        List<Role> roleList = roleService.findAll();
        return new Result(true, StatusCode.OK,"查询成功",roleList) ;
    }

    /***
     * 根据ID查询数据
     * @param id
     * @return
     */
    @ApiOperation("查询指定角色")
    @GetMapping("/{id}")
    public Result findById(@PathVariable Integer id){
        Role role = roleService.findById(id);
        return new Result(true,StatusCode.OK,"查询成功",role);
    }


    /***
     * 新增数据
     * @param role
     * @return
     */
    @ApiOperation("添加角色")
    @PostMapping
    public Result add(@RequestBody Role role){
        roleService.add(role);
        return new Result(true,StatusCode.OK,"添加成功");
    }


    /***
     * 修改数据
     * @param role
     * @param id
     * @return
     */
    @ApiOperation("修改角色")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody Role role,@PathVariable Integer id){
        role.setId(id);
        roleService.update(role);
        return new Result(true,StatusCode.OK,"修改成功");
    }


    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation("删除角色")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Integer id){
        roleService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 多条件搜索品牌数据
     * @param searchMap
     * @return
     */
    @ApiOperation("根据条件查询角色")
    @GetMapping(value = "/search" )
    public Result findList(@RequestParam Map searchMap){
        List<Role> list = roleService.findList(searchMap);
        return new Result(true,StatusCode.OK,"查询成功",list);
    }


    /***
     * 分页搜索实现
     * @param searchMap
     * @param page
     * @param size
     * @return
     */
    @ApiOperation("根据条件查询角色并分页显示")
    @GetMapping(value = "/search/{page}/{size}" )
    public Result findPage(@RequestParam Map searchMap, @PathVariable  int page, @PathVariable  int size){
        Page<Role> pageList = roleService.findPage(searchMap, page, size);
        PageResult pageResult=new PageResult(pageList.getTotal(),pageList.getResult());
        return new Result(true,StatusCode.OK,"查询成功",pageResult);
    }

    /**
     * 修改状态
     *
     */
    @ApiOperation("修改角色状态")
    @PutMapping(value = "/{id}/status/{status}")
    public Result updateStatus(@PathVariable Integer id, @PathVariable Integer status) {
        roleService.updateStatusById(status, id);
        return new Result(true, StatusCode.OK, "修改成功");
    }

}
