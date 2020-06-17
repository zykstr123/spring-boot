package com.example.springbootdemo.service.impl;

import com.example.springbootdemo.entity.Girl;
import com.example.springbootdemo.mapper.GirlMapper;
import com.example.springbootdemo.service.GirlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GirlServiceImp implements GirlService {

    @Autowired
    GirlMapper girlMapper;

    @Override
    public Integer add(Girl girl) {

        return girlMapper.insert(girl);
    }

    @Override
    public Girl getGirlByName(String name) {
        return girlMapper.getGirlByname(name);
    }
}
