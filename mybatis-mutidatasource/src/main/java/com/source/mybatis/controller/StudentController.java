package com.source.mybatis.controller;

import com.source.mybatis.model.Student;
import com.source.mybatis.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
    @Autowired
    StudentService studentService;
    @GetMapping("/one")
    public Student findone(){
       return studentService.findone();
    }

    @GetMapping("/two")
    public Student findtwo(){
        return studentService.findtwo();
    }

    @GetMapping("/three")
    public Student findthree(){
        return studentService.findthree();
    }


}
