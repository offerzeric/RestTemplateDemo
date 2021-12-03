package com.eric.mybatisplusservice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.eric.mybatisplusservice.pojo.DemoUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * UserMapper
 *
 * @author ericzhang 2021/11/17 10:28 下午
 */
@Mapper
@Repository
public interface UserMapper extends BaseMapper<DemoUser> {

}
