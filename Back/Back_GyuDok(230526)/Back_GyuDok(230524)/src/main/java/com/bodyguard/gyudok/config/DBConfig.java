package com.bodyguard.gyudok.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.bodyguard.gyudok.model.dao")
public class DBConfig {

}
