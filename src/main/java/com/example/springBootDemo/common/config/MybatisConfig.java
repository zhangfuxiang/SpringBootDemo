package com.example.springBootDemo.common.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @Auther: zhangfx
 * @Date: 2019/3/1 10:46
 * @Description:
 */
@Configuration
@Slf4j
@ImportResource(locations= {"classpath:config/mybatis-config.xml"})
public class MybatisConfig {

}
