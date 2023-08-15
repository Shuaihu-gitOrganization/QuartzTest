package com.atlucky.springsecuritytest.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * @Date 2023/8/14 9:37
 * @Author XiaoHu
 * @Description 用户表实体类
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("user")
public class User implements Serializable {


    private static final long serialVersionUID=1L;
    /**
     * id
     */
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;
    /**
     * 用户名
     */
    @TableField(value = "username")
    private String userName;
    /**
     * 昵称
     */
    @TableField(value = "nickname")
    private String nickName;
    /**
     * 密码
     */
    @TableField(value = "password")
    private String password;
    /**
     * 状态
     */
    @TableField(value = "status")
    private String status;
    /**
     * 电子邮件
     */
    @TableField(value = "email")
    private String email;
    /**
     * 用户类型
     */
    @TableField(value = "usertype")
    private String userType;
    /**
     * 创建
     */
    @TableField(value = "createby")
    private Long createBy;
    /**
     * 创建时间
     */
    @TableField(value = "createtime")
    private Date createTime;
    /**
     * 更新
     */
    @TableField(value = "updateby")
    private Long updateBy;

    /**
     * 更新时间
     */
    @TableField(value = "updatetime")
    private Date updateTime;
    /**
     * 删除标志
     */
    @TableField(value = "delflag")
    private Integer delFlag;
}
