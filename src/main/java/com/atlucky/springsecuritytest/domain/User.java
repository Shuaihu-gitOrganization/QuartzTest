package com.atlucky.springsecuritytest.domain;

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
public class User implements Serializable {
    @Serial
    private static final long serialVersionUID=1L;
    /**
     * id
     */
    private Long id;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 昵称
     */
    private String nickName;
    /**
     * 密码
     */
    private String password;
    /**
     * 状态
     */
    private String status;
    /**
     * 电子邮件
     */
    private String email;
    /**
     * 用户类型
     */
    private String userType;
    /**
     * 创建
     */
    private Long createBy;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新
     */
    private Long updateBy;

    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 删除标志
     */
    private Integer delFlag;
}
