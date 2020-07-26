package com.bos.source.controller;

import com.bos.source.mapper.JObLevelMapper;
import com.bos.source.model.JObLevel;
import com.bos.source.service.JobService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "job测试")
@RestController
@RequestMapping("/job")
public class JobController {
    @Autowired
    JobService jobService;
     @Autowired
     JObLevelMapper jObLevelMapper;

    @ApiOperation("添加用户的接口")
    @PostMapping("/add")
    public  Integer  add(@RequestBody JObLevel jObLevel){
      return   jobService.add(jObLevel);

    }

    @ApiOperation("添加用户的接口insertSelective")
    @PostMapping("/add2")
    public  Integer  add2(@RequestBody JObLevel jObLevel){
        return   jObLevelMapper.insertSelective(jObLevel);

    }

    @ApiOperation("添加用户的接口insertSelective")
    @GetMapping("/getjob")
    public JObLevel getjob(Integer id){
        return   jObLevelMapper.selectByPrimaryKey(id);

    }

    @ApiOperation("删除用户的接口insertSelective")
    @DeleteMapping("/delete")
    public  Integer  delete(Integer id){
        return   jObLevelMapper.deleteByPrimaryKey(id);

    }

    @ApiOperation("删除用户的接口updateByPrimaryKey")
    @PutMapping("/update")
    public  Integer  update11(@RequestBody JObLevel jObLevel){
        return   jObLevelMapper.updateByPrimaryKey(jObLevel);

    }

    @ApiOperation("删除用户的接口updateByPrimaryKeySelective")
    @PutMapping("/update22")
    public  Integer  update22(@RequestBody JObLevel jObLevel){
        return   jObLevelMapper.updateByPrimaryKeySelective(jObLevel);

    }


    @ApiOperation("删除deletebatch")
    @DeleteMapping("/deletebatch/{ids}")
    public  Integer  deletebatch(@PathVariable("ids") Integer[] ids){
        System.out.println(ids.length);
        System.out.println(ids);
        return   jobService.deletebatch(ids);

    }

    /**
     *
      * @param name
     * @param titlelevel
     * @return JobLevel
     */

   @GetMapping("/find/{name}/{titlelevel}")
   @ApiOperation("根据姓名的等级查询joblevel")
    public List<JObLevel> findJoblevalByNameAndTitlelevel(
            @PathVariable("name") String name, @PathVariable("titlelevel") String titlelevel){

       return  jobService.findJoblevalByNameAndTitlelevel(name,titlelevel);
    }

    @PostMapping("/findjobleval")
    @ApiOperation("根据jObLevel动态查询joblevel,findjobleval")
    public   List<JObLevel> findJoblevalBy(
           @RequestBody JObLevel jObLevel){
        System.out.println(jObLevel);
        return  jobService.findJoblevalByjObLevel(jObLevel);
    }





}
