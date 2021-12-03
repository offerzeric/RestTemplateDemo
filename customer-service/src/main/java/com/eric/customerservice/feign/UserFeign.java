package com.eric.customerservice.feign;

import com.eric.customerservice.config.FeignLoggingConfig;
import com.eric.customerservice.fallback.UserFeignFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * description
 *
 * @author ericzhang 2021/11/21 1:36 下午
 */
@FeignClient(fallbackFactory = UserFeignFallback.class, name = "server-service",configuration = FeignLoggingConfig.class)
//feignClient不会自己加serveltcontext
@RequestMapping("/eric/user")
public interface UserFeign {

    @RequestMapping("/findAll")
     String findAll();


}
