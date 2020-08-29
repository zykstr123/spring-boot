package com.example.springbootdemo;

import com.example.springbootdemo.reactor.GreetingWebClient;
import com.example.springbootdemo.redis.RedisApi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.net.MalformedURLException;
import java.net.URL;

@SpringBootApplication
@EnableScheduling
public class SpringBootDemoApplication {
	public static void main(String[] args) {
		ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(SpringBootDemoApplication.class, args);
		//  I/O error on POST request for "http://localhost:9411/api/v2/spans"   zipkin没启动
		GreetingWebClient gwc = new GreetingWebClient();
		try {
			RedisApi.addLink("1", new URL("www.baidu.com"));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		System.out.println(gwc.getResult());
	}
}
