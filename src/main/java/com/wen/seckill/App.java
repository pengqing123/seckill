package com.wen.seckill;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.wen.seckill.dao.SeckillDao;
@SpringBootApplication
public class App {
	@Resource
	private  SeckillDao seckillDao;
    public static void main(String[] args) {
        SpringApplication.run(App.class,args);

        System.out.println("hello world");
    }
}

