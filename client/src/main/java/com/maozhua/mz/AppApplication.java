package com.maozhua.mz;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.maozhua.mz.infra.mapper")
@SpringBootApplication(scanBasePackages = "com.maozhua.mz")
public class AppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

}