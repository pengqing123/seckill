package com.wen.seckill;

import javax.annotation.Resource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.alibaba.fastjson.parser.ParserConfig;
import com.wen.seckill.dao.SeckillDao;
@SpringBootApplication
public class App {
	@Resource
	private  SeckillDao seckillDao;
    public static void main(String[] args) {
        SpringApplication.run(App.class,args);
        //fastjson  白名单
        System.out.println("hello world");
    }
}

