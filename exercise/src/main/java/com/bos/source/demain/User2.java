package com.bos.source.demain;

import java.io.Serializable;

public class User2 implements Serializable {
    private Integer id;
    private String name;
    private  String password;

    public Integer getId() {
        return id;
    }

    public User2(Integer id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public User2( ) {

    }
    public User2(String name, String password) {

        this.name = name;
        this.password = password;
    }
    @Override
    public String toString() {
        return "User2{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
