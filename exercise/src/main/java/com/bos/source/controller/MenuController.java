package com.bos.source.controller;


import com.bos.source.mapper.ClassroomMapper;
import com.bos.source.model.Classroom;
import com.bos.source.model.Menu;
import com.bos.source.service.MenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(tags = "Menu测试")
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    MenuService menuService;
     @Autowired
     ClassroomMapper classroomMapper;

    @ApiOperation("添加用户的接口")
    @GetMapping("/getByHrid/{id}")
    public List<Menu> getMenusByHrId(@PathVariable Integer id ){
        System.out.println("MenuController:"+id);
        return menuService.getMenusByHrId(id);

    }

    @ApiOperation("getAllStudents")
    @GetMapping("/getAllStudents")
    public List<Classroom> getAllStudents( ){

        return classroomMapper.getAllStudents();

    }


}
