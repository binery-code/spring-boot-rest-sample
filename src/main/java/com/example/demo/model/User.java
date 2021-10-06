package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "user")
public class User {

    @Id
    private Integer id;
    private String name;
    private String age;

    public User(Integer id, String name, String age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public User() {
    }



    public Integer getId() {
        return id;
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
