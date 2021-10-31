package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/dummy")
public class DummyController {


    @GetMapping("/")
    public List<String> getDummy(){

        List l = new ArrayList();
        l.add("dum1");
        l.add("dum2");

        return l;
    }
}
