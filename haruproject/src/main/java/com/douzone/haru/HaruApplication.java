package com.douzone.haru;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
@EnableAspectJAutoProxy
@SpringBootApplication
public class HaruApplication {

	public static void main(String[] args) {
		SpringApplication.run(HaruApplication.class, args);
	}

}
