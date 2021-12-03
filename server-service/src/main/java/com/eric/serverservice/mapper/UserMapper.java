package com.eric.serverservice.mapper;

import com.eric.serverservice.pojo.DemoUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.BaseMapper;

/**
 * 直接继承接口就可以 实现类在不同的BaseSelectProvider BaseInsertProvider BaseDeleteProvider中
 *
 * @author ericzhang 2021/11/17 8:41 下午
 */
@Mapper
@Repository
public interface UserMapper extends BaseMapper<DemoUser> {
}
