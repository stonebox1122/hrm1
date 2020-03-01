package com.stone.hrm.controller;
import com.stone.hrm.common.entity.PageResult;
import com.stone.hrm.common.entity.Result;
import com.stone.hrm.common.entity.StatusCode;
import com.stone.hrm.pojo.Icon;
import com.stone.hrm.service.IconService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/icon")
public class IconController {


    @Autowired
    private IconService iconService;

    /**
     * 查询全部数据
     * @return
     */
    @GetMapping
    public Result findAll(){
        List<Icon> iconList = iconService.findAll();
        return new Result(true, StatusCode.OK,"查询成功",iconList) ;
    }

    /***
     * 根据ID查询数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result findById(@PathVariable Integer id){
        Icon icon = iconService.findById(id);
        return new Result(true,StatusCode.OK,"查询成功",icon);
    }


    /***
     * 新增数据
     * @param icon
     * @return
     */
    @PostMapping
    public Result add(@RequestBody Icon icon){
        iconService.add(icon);
        return new Result(true,StatusCode.OK,"添加成功");
    }


    /***
     * 修改数据
     * @param icon
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody Icon icon,@PathVariable Integer id){
        icon.setId(id);
        iconService.update(icon);
        return new Result(true,StatusCode.OK,"修改成功");
    }


    /***
     * 根据ID删除数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Integer id){
        iconService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 多条件搜索数据
     * @param searchMap
     * @return
     */
    @GetMapping(value = "/search" )
    public Result findList(@RequestParam Map searchMap){
        List<Icon> list = iconService.findList(searchMap);
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
        Page<Icon> pageList = iconService.findPage(searchMap, page, size);
        PageResult pageResult=new PageResult(pageList.getTotal(),pageList.getResult());
        return new Result(true,StatusCode.OK,"查询成功",pageResult);
    }


}
