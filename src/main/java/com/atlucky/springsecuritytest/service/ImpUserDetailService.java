package com.atlucky.springsecuritytest.service;

import com.atlucky.springsecuritytest.domain.LoginUser;
import com.atlucky.springsecuritytest.domain.User;
import com.atlucky.springsecuritytest.mapper.MenuMapper;
import com.atlucky.springsecuritytest.mapper.UserMapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @Date 2023/8/14 15:14
 * @Author XiaoHu
 * @Description
 **/
@Service
public class ImpUserDetailService implements UserDetailsService {
    @Resource
    private UserMapper userMapper;

    @Resource
    private MenuMapper menuMapper;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //查询用户信息
        LambdaQueryWrapper<User> userLambdaQueryWrapper = new LambdaQueryWrapper<>();
        userLambdaQueryWrapper.eq(User::getUserName,username);
        User user = userMapper.selectOne(userLambdaQueryWrapper);
        if(Objects.isNull(user)){
            throw new RuntimeException("用户不存在！");
        }
        //ToDo 查询对应的权限
        List<String> list = menuMapper.selectPermissionsById(user.getId());
        //List<String> list = new ArrayList<String>(Arrays.asList("test","admin"));
        //数据封装UserDetail

        return new LoginUser(user,list);
    }
}
