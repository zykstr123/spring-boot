package com.example.springbootdemo.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Scheduler {

    // 每隔1分钟刷新一次
    //被@PostConstruct修饰的方法会在服务器加载Servlet的时候运行
    @PostConstruct
    @Scheduled(fixedRate = 60 * 1000)
    public void testTask() {
        System.out.println("-----------");
    }
}
