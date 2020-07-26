package com.source.mybatis.service;

import com.source.mybatis.mapper1.StudentMapperOne;
import com.source.mybatis.mapper2.StudentMapperTwo;
import com.source.mybatis.mapper3.StudentMapperThree;
import com.source.mybatis.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    StudentMapperOne studentMapperOne;

    @Autowired
    StudentMapperTwo studentMapperTwo;

     @Autowired
     StudentMapperThree studentMapperThree;
    public Student findone(){
        Student student = studentMapperOne.selectone();
        System.out.println("findone"+student);
        return student;
    }


    public Student findtwo(){
        Student student = studentMapperTwo.selecttwo();
        System.out.println("findtwo"+student);
        return student;
    }

   public Student findthree(){
        Student student = studentMapperThree.selectthree();
        System.out.println("findhree"+student);
        return student;
    }
}
