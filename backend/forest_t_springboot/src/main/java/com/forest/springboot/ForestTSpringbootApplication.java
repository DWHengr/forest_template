package com.forest.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.forest.springboot.mapper")
public class ForestTSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(ForestTSpringbootApplication.class, args);
    }

}
