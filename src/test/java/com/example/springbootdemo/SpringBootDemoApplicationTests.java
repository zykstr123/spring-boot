package com.example.springbootdemo;

import com.example.springbootdemo.service.GirlService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootDemoApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	GirlService girlService;

	@Test
	void increase() {
		girlService.increase(1);
	}
}
