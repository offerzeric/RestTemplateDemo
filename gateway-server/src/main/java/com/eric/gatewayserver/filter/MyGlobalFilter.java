package com.eric.gatewayserver.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.util.Assert;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.lang.annotation.Annotation;
import java.util.List;

/**
 * description
 *
 * @author ericzhang 2021/11/23 3:32 下午
 */
@Configuration
public class MyGlobalFilter implements GlobalFilter,Order {

    private Logger logger = LoggerFactory.getLogger(MyGlobalFilter.class);


    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        List<String> token = exchange.getRequest().getQueryParams().get("token");
        try {
            Assert.notNull(token);
        }catch (Exception w){
            throw new RuntimeException("没有token");
        }
        logger.info(token.toString());
        return chain.filter(exchange);
    }

    @Override
    public int value() {
        return -1;
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }
}
