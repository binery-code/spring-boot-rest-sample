package com.example.demo.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "user")
public class User {

    @Id
    private Integer id;
    private String name;
    private String age;

}
