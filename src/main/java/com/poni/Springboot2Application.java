package com.poni;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import tk.mybatis.spring.annotation.MapperScan;


@SpringBootApplication
//扫描Mybatis mapper包路径
@MapperScan(basePackages = "com.poni.mapper")
//开启定时任务
//@EnableScheduling
//开启异步调用方法
@EnableAsync
public class Springboot2Application {

	public static void main(String[] args) {
		SpringApplication.run(Springboot2Application.class, args);
	}
}
