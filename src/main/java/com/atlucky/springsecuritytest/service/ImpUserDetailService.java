package com.atlucky.springsecuritytest.service;

import com.atlucky.springsecuritytest.domain.LoginUser;
import com.atlucky.springsecuritytest.domain.User;
import com.atlucky.springsecuritytest.mapper.UserMapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @Date 2023/8/14 15:14
 * @Author XiaoHu
 * @Description
 **/
@Service
public class ImpUserDetailService implements UserDetailsService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //查询用户信息
        LambdaQueryWrapper<User> userLambdaQueryWrapper = new LambdaQueryWrapper<>();
        userLambdaQueryWrapper.eq(User::getUserName,username);
        User user = userMapper.selectOne(userLambdaQueryWrapper);
        if(Objects.isNull(user)){
            throw new RuntimeException("用户不存在！");
        }
        //TODO 查询对应的权限
        //数据封装UserDetail

        return new LoginUser(user);
    }
}
