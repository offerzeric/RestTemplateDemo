package com.eric.customerservice.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * description
 *
 * @author ericzhang 2021/11/21 2:44 下午
 */
@Configuration
public class FeignLoggingConfig {

    @Bean
    public Logger.Level feignLoggerLever(){
        return Logger.Level.FULL;
    }

}
