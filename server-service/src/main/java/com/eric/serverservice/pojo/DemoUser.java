package com.eric.serverservice.pojo;

import lombok.Data;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.type.JdbcType;
import tk.mybatis.mapper.annotation.ColumnType;

import javax.annotation.Generated;
import javax.persistence.Table;

/**
 * description
 *
 * @author ericzhang 2021/11/17 7:51 下午
 */
@Data
@Table(name="demo_user")
public class DemoUser {

    @ColumnType(jdbcType = JdbcType.INTEGER, column = "user_id")
    private Integer userId;
    @ColumnType(jdbcType = JdbcType.VARCHAR, column = "user_id")
    private String userName;
    @ColumnType(jdbcType = JdbcType.INTEGER, column = "user_gender")
    private Integer userGender;

}
