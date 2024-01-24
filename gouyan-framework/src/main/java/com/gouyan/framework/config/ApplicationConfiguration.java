package com.gouyan.framework.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Aixchen
 * @date 2024/1/24 14:39
 */
@Configuration
//配置要扫描mapper的包
@MapperScan("com.gouyan.**.mapper")
public class ApplicationConfiguration {
}
