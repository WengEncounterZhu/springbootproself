package com.bos.source.controller;

import com.bos.source.demain.User2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// https://www.cnblogs.com/zhangjianbing/p/8992897.html
@RestController
//@CrossOrigin(origins = "http://localhost:8081/login", maxAge = 36000)
public class LoginController {
    @Autowired
   JdbcTemplate jdbcTemplate;

    @GetMapping ("/login2")
    public User2 test(){
        return new User2(1,"中国" ,"123");
    }

    @PostMapping("/login")
   // @CrossOrigin(origins = "http://localhost:8081/login", maxAge = 36000)
    public User2 login(@RequestBody User2 user){
        System.out.println(user);
    List<User2> list=  jdbcTemplate.query("select *from user where name=? and password=?",new Object[]{
            user.getName(),user.getPassword()
            },
                new BeanPropertyRowMapper(User2.class) );
        System.out.println(list);

        if(list!=null&&list.size()>0){
            return list.get(0);
        }else{
            return new User2(null,null,null);
        }
          //new User2(1,"中国" ,"123");
    }
}
