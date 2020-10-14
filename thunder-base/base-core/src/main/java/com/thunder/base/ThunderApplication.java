package com.thunder.base;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @description:
 * @author: llm
 * @create: 2020/9/3
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class ThunderApplication {
    public static void main(String[] args) {
        SpringApplication.run(ThunderApplication.class, args);
    }
}
