package com.atlucky.springsecuritytest.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.Date;

/**
 * 系统菜单
 *
 * @Date 2023/8/17 13:57
 * @Author XiaoHu
 * @Description
 **/
@Slf4j
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "sys_menu")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SysMenu implements Serializable {
    private static final long serialVersionUID=1L;

    /**
     * id
     */
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;
    /**
     * 菜单名称
     */
    @TableField(value = "menu_name")
    private String menuName;
    /**
     * 路径
     */
    @TableField(value = "path")
    private String path;
    /**
     * 组件
     */
    @TableField(value = "component")
    private String component;
    /**
     * 状态
     */
    @TableField(value = "status")
    private String status;
    /**
     * 图标
     */
    @TableField(value = "icon")
    private String icon;
    /**
     * 可见
     */
    @TableField(value = "visible")
    private String visible;
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
    /**
     * 权限
     */
    @TableField(value = "perms")
    private String permissions;

}
