package com.eric.gatewayserver.config;

import com.eric.gatewayserver.filter.MyGlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * description
 *
 * @author ericzhang 2021/11/23 3:39 下午
 */
@Configuration
public class Configure {

    @Bean
    public MyGlobalFilter create(){
        return new MyGlobalFilter();
    }

}
