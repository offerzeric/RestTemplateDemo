package com.eric.customerservice.intercept;

import org.apache.http.HttpException;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.protocol.HttpContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import reactor.util.annotation.Nullable;

import java.io.IOException;

/**
 * HandlerInterceptor是最常规的，其拦截的http请求是来自于客户端浏览器之类的，是最常见的http请求拦截器；
 *
 * ClientHttpRequestInterceptor是对RestTemplate的请求进行拦截的，在项目中直接使用restTemplate.getForObject的时候，会对这种请求进行拦截，只对RestTempalte拦截器或者Ribbon拦截器；
 *
 * RequestInterceptor常被称为是Feign拦截器，由于Feign调用底层实际上还是http调用，因此也是一个http拦截器，在项目中使用Feign调用的时候，可以使用此拦截器；
 *
 * @author ericzhang 2021/11/20 12:44 下午
 */
@Order(value = 0)
@Component
public class TestClientHttpIntercept implements ClientHttpRequestInterceptor {

    private Logger logger = LoggerFactory.getLogger("TestIntercept");

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        logger.info(request.toString(),body.toString());
        return execution.execute(request,body);
    }
}
