package com.eric.customerservice.intercept;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;

/**
 * description
 *
 * @author ericzhang 2021/11/20 2:23 下午
 */
@Component
@Order(value = 0)
public class NormalHandlerIntecepter implements HandlerInterceptor {

    private Logger logger  = LoggerFactory.getLogger(NormalHandlerIntecepter.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        byte[] bytes = request.getRequestURI().getBytes(StandardCharsets.UTF_8);
        logger.info(String.valueOf(bytes));
        Cookie[] cookies = request.getCookies();
        logger.info(String.valueOf(cookies));
        String authType = request.getAuthType();
        logger.info(String.valueOf(authType));
        String method = request.getMethod();
        logger.info(String.valueOf(method));
        return Boolean.TRUE;
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        logger.info("post Handler");
    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        logger.info("afterCompletion");
    }

}
