package com.example.springbootdemo.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

@Configuration
public class RabbitConfig {
    @Resource
    AmqpAdmin amqpAdmin;

    public static final String queue = "TestDirectQueue";
    public static final String exchange = "TestDirectExchange";
    public static final String key = "test";

    @PostConstruct
    public void createQueue() {
        Queue testQueue = new Queue(queue);
        amqpAdmin.declareQueue(testQueue);
        TopicExchange testExchange = new TopicExchange(exchange);
        amqpAdmin.declareExchange(testExchange);
        Binding postCreateBind = BindingBuilder
                .bind(testQueue)
                .to(testExchange)
                .with(key);
        amqpAdmin.declareBinding(postCreateBind);
    }
}
