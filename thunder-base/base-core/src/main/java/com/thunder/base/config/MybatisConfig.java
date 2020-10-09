package com.thunder.base.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @description:
 * @author: llm
 * @create: 2020/9/4
 **/
@Configuration
@MapperScan("com.thunder.base.mapper")
public class MybatisConfig {
}
