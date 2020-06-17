package com.example.springbootdemo.mapper;

import com.example.springbootdemo.entity.Girl;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface GirlMapper {
    Integer insert(@Param("girl") Girl girl);

    Girl getGirlByname(@Param("name") String name);
}
