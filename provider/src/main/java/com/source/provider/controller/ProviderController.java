package com.source.provider.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderController {
    @GetMapping("/httpget")
    public String sop(String name){
        System.out.println("参数名称为："+name);
        if(null!=name){
            System.out.println("name长度为："+name.length()+"name内容："+name);
        }
        return name;
    }
}
