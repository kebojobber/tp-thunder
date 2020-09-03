package com.thunder.base;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @description:
 * @author: llm
 * @create: 2020/9/3
 **/
@SpringBootApplication
@MapperScan("com.thunder.base.mapper")
public class ThunderApplication {
    public static void main(String[] args) {
        SpringApplication.run(ThunderApplication.class, args);
    }
}
