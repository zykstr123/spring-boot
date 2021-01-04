package com.example.springbootdemo.listener;

import com.example.springbootdemo.event.GirlEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class GirlListener {

    @EventListener(classes = GirlEvent.class)
    @Async
    void writeLog(GirlEvent girlEvent) {
//        System.out.println("log event: " + girlEvent.getGirl());
    }
}
