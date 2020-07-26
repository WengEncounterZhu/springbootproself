package com.bos.source;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.bos.source.mapper")
public class HellodemoApplication {

    public static void main(String[] args) {

       System.out.println("starting .....");
        SpringApplication.run(HellodemoApplication.class, args);
        System.out.println("started finshed...");
    }

}
