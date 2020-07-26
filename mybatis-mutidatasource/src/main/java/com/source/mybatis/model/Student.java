package com.source.mybatis.model;

import java.io.Serializable;

public class Student  implements Serializable {
    private  Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public Student(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
