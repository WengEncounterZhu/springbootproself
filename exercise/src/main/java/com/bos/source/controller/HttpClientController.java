package com.bos.source.controller;

import com.bos.source.demain.RespBean;
import com.bos.source.demain.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@Api(tags = "httpclient测试")
@RestController
public class HttpClientController {

// https://blog.csdn.net/justry_deng/article/details/81042379
    @ApiOperation("get?id=... 的接口")
    @GetMapping("/get")
    public RespBean get2(@RequestParam Integer id){

        RespBean res =new RespBean();
        res.setCode(id);
        res.setMsg("sucess");
        res.setData(new User(2,"get2","江苏2"));
        return  res;
    }

    @ApiOperation("/get/{id} 的接口")
    @GetMapping("/get/{id}")
    public RespBean get(@PathVariable Integer id){

        RespBean res =new RespBean();
        res.setCode(id);
        res.setMsg("sucess");
        res.setData(new User(1,"get","江苏"));
        return  res;
    }

    @ApiOperation("post 的接口")
    @PostMapping("/post")
    public RespBean post(@RequestBody User user){

        RespBean res =new RespBean();
        res.setCode(200);
        res.setMsg("sucess");
        res.setData(user);// new User(1,"source","江苏")
        return  res;

    }
    @ApiOperation("put 的接口")
    @PutMapping("/put")
    public RespBean put(@RequestBody User user){

        RespBean res =new RespBean();
        res.setCode(200);
        res.setMsg("sucess");
        res.setData( user);
        return  res;

    }
    @ApiOperation("delete 的接口")
    @DeleteMapping("/delete/{id}")
    public RespBean delete(@PathVariable Integer id){
        RespBean res =new RespBean();
        res.setCode(id);
        res.setMsg("sucess");
        res.setData(new User(1,"delete","江苏"));
        return  res;
    }



}
