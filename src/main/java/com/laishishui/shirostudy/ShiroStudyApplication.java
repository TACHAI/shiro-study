package com.laishishui.shirostudy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SpringBootApplication
@MapperScan(basePackages = {"com.laishishui.shirostudy.mapper"})
public class ShiroStudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShiroStudyApplication.class, args);
    }

}
