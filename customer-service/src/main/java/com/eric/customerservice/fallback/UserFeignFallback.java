package com.eric.customerservice.fallback;

import com.eric.customerservice.feign.UserFeign;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * description
 *
 * @author ericzhang 2021/11/21 1:40 下午
 */
@Component
public class UserFeignFallback implements FallbackFactory<UserFeign> {

    @Override
    public UserFeign create(Throwable cause) {
        return new UserFeign() {
            @Override
            public String findAll() {
                return "服务繁忙";
            }
        };
    }
}
