package com.stone.hrm.controller;
import com.stone.hrm.common.entity.PageResult;
import com.stone.hrm.common.entity.Result;
import com.stone.hrm.common.entity.StatusCode;
import com.stone.hrm.service.UserRoleService;
import com.stone.hrm.pojo.UserRole;
import com.github.pagehelper.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@Api(tags = "系统管理：用户角色关联管理")
@RestController
@CrossOrigin
@RequestMapping("/userRole")
public class UserRoleController {


    @Autowired
    private UserRoleService userRoleService;

    /**
     * 查询全部数据
     * @return
     */
    @ApiOperation("查询所有用户角色关联")
    @GetMapping
    public Result findAll(){
        List<UserRole> userRoleList = userRoleService.findAll();
        return new Result(true, StatusCode.OK,"查询成功",userRoleList) ;
    }

    /***
     * 根据ID查询数据
     * @param id
     * @return
     */
    @ApiOperation("查询指定用户角色关联")
    @GetMapping("/{id}")
    public Result findById(@PathVariable Integer id){
        UserRole userRole = userRoleService.findById(id);
        return new Result(true,StatusCode.OK,"查询成功",userRole);
    }


    /***
     * 新增数据
     * @param userRole
     * @return
     */
    @ApiOperation("添加用户角色关联")
    @PostMapping
    public Result add(@RequestBody UserRole userRole){
        userRoleService.add(userRole);
        return new Result(true,StatusCode.OK,"添加成功");
    }


    /***
     * 修改数据
     * @param userRole
     * @param id
     * @return
     */
    @ApiOperation("修改用户角色关联")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody UserRole userRole,@PathVariable Integer id){
        userRole.setId(id);
        userRoleService.update(userRole);
        return new Result(true,StatusCode.OK,"修改成功");
    }


    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation("删除用户角色关联")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Integer id){
        userRoleService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 多条件搜索品牌数据
     * @param searchMap
     * @return
     */
    @ApiOperation("根据条件查询用户角色关联")
    @GetMapping(value = "/search" )
    public Result findList(@RequestParam Map searchMap){
        List<UserRole> list = userRoleService.findList(searchMap);
        return new Result(true,StatusCode.OK,"查询成功",list);
    }


    /***
     * 分页搜索实现
     * @param searchMap
     * @param page
     * @param size
     * @return
     */
    @ApiOperation("根据条件查询用户角色关联并分页显示")
    @GetMapping(value = "/search/{page}/{size}" )
    public Result findPage(@RequestParam Map searchMap, @PathVariable  int page, @PathVariable  int size){
        Page<UserRole> pageList = userRoleService.findPage(searchMap, page, size);
        PageResult pageResult=new PageResult(pageList.getTotal(),pageList.getResult());
        return new Result(true,StatusCode.OK,"查询成功",pageResult);
    }

}
