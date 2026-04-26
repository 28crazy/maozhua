package com.maozhua.mz.client.config.mysqlConfig;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.maozhua.mz.infra.mapper")
public class MyBatisMysqlConfig {
}
