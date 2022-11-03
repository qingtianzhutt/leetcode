package com.example.demo.mp;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 用户信息实体类
 */
@Data
@TableName("pcs_sys_user_details")
public class UserEntity {
    /**
     * 用户名
     */
    @TableField("id")
    @TableId
    private String id;
    /**
     * 昵称
     */
    @TableField("user_id")
    private String userId;
    /**
     * 密码
     */
    @TableField("nickName")
    private String nickName;
}