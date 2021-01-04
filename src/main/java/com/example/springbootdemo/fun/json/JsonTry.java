package com.example.springbootdemo.fun.json;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;


public class JsonTry {
    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "Norman");
        map.put("age", 25);
        ObjectMapper objectMapper = new ObjectMapper();
        People people = objectMapper.convertValue(map, People.class);
        System.out.println(people.getAge());
    }
}

class People {
    private String name;
    private Integer age;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
