package com.thunder.eureka.thundereureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @description:
 * @author: llm
 * @create: 2020/9/3
 **/
@SpringBootApplication
@EnableEurekaServer
public class ThunderEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ThunderEurekaApplication.class, args);
    }

}
