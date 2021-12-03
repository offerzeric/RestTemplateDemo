package com.eric.gatewayserver.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.net.InetAddress;
import java.net.URI;
import java.util.Arrays;
import java.util.List;

/**
 * 自定义局部过滤器
 *
 * @author ericzhang 2021/11/23 2:58 下午
 */
@Component
public class MyParamGatewayFilterFactory extends AbstractGatewayFilterFactory<MyParamGatewayFilterFactory.Config> {

    private Logger logger = LoggerFactory.getLogger(MyParamGatewayFilterFactory.class);

    public static final String PARAM = "param";

    public MyParamGatewayFilterFactory() {
        super(MyParamGatewayFilterFactory.Config.class);
    }


    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList(PARAM);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return new GatewayFilter() {
            @Override
            public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
                URI uri = exchange.getRequest().getURI();
                logger.info(uri.toString());
                return chain.filter(exchange);
            }
        };
    }

    static class Config{
         private String name;

         public String getName() {
             return name;
         }

         public void setName(String name) {
             this.name = name;
         }

        @Override
        public String toString() {
            return "Config{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

}
