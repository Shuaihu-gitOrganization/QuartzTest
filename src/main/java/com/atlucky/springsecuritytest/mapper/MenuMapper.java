package com.atlucky.springsecuritytest.mapper;

import com.atlucky.springsecuritytest.domain.SysMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * @Date 2023/8/17 14:05
 * @Author XiaoHu
 * @Description
 **/
public interface MenuMapper extends BaseMapper<SysMenu> {
    /**
     * 选择权限id
     *
     * @param userid 用户标识
     * @return {@link List}<{@link String}>
     */
    List<String> selectPermissionsById(Long userid);
}
