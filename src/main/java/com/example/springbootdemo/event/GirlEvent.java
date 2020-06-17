package com.example.springbootdemo.event;

import com.example.springbootdemo.entity.Girl;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class GirlEvent extends ApplicationEvent {

    private Girl girl;

    public GirlEvent(Object source, Girl girl) {
        super(source);
        this.girl = girl;
    }
}
