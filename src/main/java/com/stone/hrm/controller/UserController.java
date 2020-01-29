package com.stone.hrm.controller;

import com.stone.hrm.common.entity.PageResult;
import com.stone.hrm.common.entity.Result;
import com.stone.hrm.common.entity.StatusCode;
import com.stone.hrm.service.UserService;
import com.stone.hrm.pojo.User;
import com.github.pagehelper.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Api(tags = "系统管理：用户管理")
@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserService userService;

    /**
     * 查询全部数据
     *
     * @return
     */
    @ApiOperation("查询所有用户并分页显示")
    @GetMapping
    public Result findAll(@RequestBody Map searchMap) {
        int page = (int) searchMap.get("page");
        int size = (int) searchMap.get("size");
        Page<User> pageList = userService.findAllPage(null, page, size);
        PageResult pageResult = new PageResult(pageList.getTotal(), pageList.getResult());
        return new Result(true, StatusCode.OK, "查询成功", pageResult);
//        List<User> userList = userService.findAll();
//        return new Result(true, StatusCode.OK,"查询成功",userList) ;
    }

    /***
     * 根据ID查询数据
     * @param id
     * @return
     */
    @ApiOperation("查询指定用户")
    @GetMapping("/{id}")
    public Result findById(@PathVariable Integer id) {
        User user = userService.findById(id);
        return new Result(true, StatusCode.OK, "查询成功", user);
    }


    /***
     * 新增数据
     * @param user
     * @return
     */
    @ApiOperation("添加用户")
    @PostMapping
    public Result add(@RequestBody User user) {
        User addUser = userService.add(user);
        return new Result(true, StatusCode.OK, "添加成功", addUser);
    }


    /***
     * 修改数据
     * @param user
     * @param id
     * @return
     */
    @ApiOperation("修改用户")
    @PutMapping(value = "/{id}")
    public Result update(@RequestBody User user, @PathVariable Integer id) {
        user.setId(id);
        userService.update(user);
        return new Result(true, StatusCode.OK, "修改成功");
    }


    /***
     * 根据ID删除用户数据
     * @param id
     * @return
     */
    @ApiOperation("删除用户")
    @DeleteMapping(value = "/{id}")
    public Result delete(@PathVariable Integer id) {
        userService.delete(id);
        return new Result(true, StatusCode.OK, "删除成功");
    }

    /***
     * 多条件搜索用户数据
     * @param searchMap
     * @return
     */
    @ApiOperation("根据条件查询用户")
    @GetMapping(value = "/search")
    public Result findList(@RequestParam Map searchMap) {
        List<User> list = userService.findList(searchMap);
        return new Result(true, StatusCode.OK, "查询成功", list);
    }


    /***
     * 分页搜索实现
     * @param searchMap
     * @param page
     * @param size
     * @return
     */
    @ApiOperation("根据条件查询用户并分页显示")
    @GetMapping(value = "/search/{page}/{size}")
    public Result findPage(@RequestParam Map searchMap, @PathVariable int page, @PathVariable int size) {
        Page<User> pageList = userService.findPage(searchMap, page, size);
        PageResult pageResult = new PageResult(pageList.getTotal(), pageList.getResult());
        return new Result(true, StatusCode.OK, "查询成功", pageResult);
    }

    /**
     * 修改状态
     *
     */
    @ApiOperation("修改用户状态")
    @PutMapping(value = "/{id}/status/{status}")
    public Result updateStatus(@PathVariable Integer id, @PathVariable Integer status) {
        return new Result(true, StatusCode.OK, "修改成功", userService.updateStatusById(status, id));
    }

}
