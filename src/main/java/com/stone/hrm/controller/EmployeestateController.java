package com.stone.hrm.controller;
import com.stone.hrm.common.entity.PageResult;
import com.stone.hrm.common.entity.Result;
import com.stone.hrm.common.entity.StatusCode;
import com.stone.hrm.pojo.Employeestate;
import com.stone.hrm.service.EmployeestateService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
@RestController
@CrossOrigin
@RequestMapping("/employeestate")
public class EmployeestateController {


    @Autowired
    private EmployeestateService employeestateService;

    /**
     * 查询全部数据
     * @return
     */
    @GetMapping
    public Result findAll(){
        List<Employeestate> employeestateList = employeestateService.findAll();
        return new Result(true, StatusCode.OK,"查询成功",employeestateList) ;
    }

    /***
     * 根据ID查询数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result findById(@PathVariable Integer id){
        Employeestate employeestate = employeestateService.findById(id);
        return new Result(true,StatusCode.OK,"查询成功",employeestate);
    }


    /***
     * 新增数据
     * @param employeestate
     * @return
     */
    @PostMapping
    public Result add(@RequestBody Employeestate employeestate){
        employeestateService.add(employeestate);
        return new Result(true,StatusCode.OK,"添加成功");
    }


    /***
     * 修改数据
     * @param employeestate
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody Employeestate employeestate,@PathVariable Integer id){
        employeestate.setId(id);
        employeestateService.update(employeestate);
        return new Result(true,StatusCode.OK,"修改成功");
    }


    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Integer id){
        employeestateService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 多条件搜索品牌数据
     * @param searchMap
     * @return
     */
    @GetMapping(value = "/search" )
    public Result findList(@RequestParam Map searchMap){
        List<Employeestate> list = employeestateService.findList(searchMap);
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
        Page<Employeestate> pageList = employeestateService.findPage(searchMap, page, size);
        PageResult pageResult=new PageResult(pageList.getTotal(),pageList.getResult());
        return new Result(true,StatusCode.OK,"查询成功",pageResult);
    }


}
