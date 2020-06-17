package com.example.springbootdemo.service;

import com.example.springbootdemo.entity.Girl;

public interface GirlService {

    Integer add(Girl girl);

    Girl getGirlByName(String name);
}
