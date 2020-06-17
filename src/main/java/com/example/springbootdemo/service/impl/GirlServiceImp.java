package com.example.springbootdemo.service.impl;

import com.example.springbootdemo.entity.Girl;
import com.example.springbootdemo.event.GirlEvent;
import com.example.springbootdemo.mapper.GirlMapper;
import com.example.springbootdemo.service.GirlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class GirlServiceImp implements GirlService {

    @Autowired
    GirlMapper girlMapper;

    @Autowired
    ApplicationContext applicationContext;

    @Override
    public Integer add(Girl girl) {
        GirlEvent girlEvent = new GirlEvent(this, girl);
        applicationContext.publishEvent(girlEvent);
        return girlMapper.insert(girl);
    }

    @Override
    public Girl getGirlByName(String name) {
        Girl girl = girlMapper.getGirlByname(name);
        GirlEvent girlEvent = new GirlEvent(this, girl);
        applicationContext.publishEvent(girlEvent);
        return girl;
    }
}
