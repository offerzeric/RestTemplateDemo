package com.eric.customerservice.config;

import com.eric.customerservice.intercept.NormalHandlerIntecepter;
//import com.eric.customerservice.intercept.TestClientHttpIntercept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * description
 *
 * @author ericzhang 2021/11/20 2:11 下午
 */
@Configuration
public class NormalIntecepterWebMvcConfigure implements WebMvcConfigurer {

    @Autowired
    private NormalHandlerIntecepter normalHandlerIntecepter;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration interceptorRegistration = registry.addInterceptor(normalHandlerIntecepter);
        interceptorRegistration.addPathPatterns("/**");
    }
}
