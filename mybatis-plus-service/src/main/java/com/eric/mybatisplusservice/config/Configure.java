package com.eric.mybatisplusservice.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * configure
 *
 * @author ericzhang 2021/11/17 10:12 下午
 */
@Configuration
@MapperScan(basePackages = {"com.eric.mybatisplusservice.mapper"})
public class Configure {
}
