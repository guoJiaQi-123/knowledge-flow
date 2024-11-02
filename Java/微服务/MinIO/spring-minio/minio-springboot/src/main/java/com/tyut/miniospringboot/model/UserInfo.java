package com.tyut.miniospringboot.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName t_user_info
 */
@TableName(value ="t_user_info")
@Data
public class UserInfo implements Serializable {
    /**
     * 主键id自增
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 昵称
     */
    private String nick;

    /**
     * 密码
     */
    private String password;

    /**
     * 性别（0女 1男）
     */
    private Integer sex;

    /**
     * 手机
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 住址
     */
    private String address;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}