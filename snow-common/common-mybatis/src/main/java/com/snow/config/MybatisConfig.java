package com.snow.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.snow.*.mapper")
public class MybatisConfig {
}
