package com.example.springbootdemo.controller;

import com.example.springbootdemo.entity.Girl;
import com.example.springbootdemo.service.GirlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GirlController {

    @Autowired
    GirlService girlService;

    @PostMapping(value = "/add", produces = "application/json;charset=UTF-8")
    public Integer addGirl(Girl girl) {
        return girlService.add(girl);
    }

    @GetMapping(value = "/get", produces = "application/json;charset=UTF-8")
    public Girl getGirl(String name) {
        return girlService.getGirlByName(name);
    }
}
