package com.eric.mybatisplusservice.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.apache.ibatis.type.JdbcType;

/**
 * DemoUser
 *
 * @author ericzhang 2021/11/17 7:51 下午
 */
@Data
@TableName(value="demo_user")
public class DemoUser {


    @TableField(jdbcType = JdbcType.INTEGER, value = "user_id")
    private Integer userId;
    @TableField(jdbcType = JdbcType.VARCHAR, value = "user_name")
    private String userName;
    @TableField(jdbcType = JdbcType.INTEGER, value = "user_gender")
    private Integer userGender;

}
