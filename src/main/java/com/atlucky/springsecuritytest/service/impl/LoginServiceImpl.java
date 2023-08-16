package com.atlucky.springsecuritytest.service.impl;

import com.atlucky.springsecuritytest.domain.LoginBody;
import com.atlucky.springsecuritytest.domain.LoginUser;
import com.atlucky.springsecuritytest.domain.User;
import com.atlucky.springsecuritytest.mapper.UserMapper;
import com.atlucky.springsecuritytest.service.LoginService;
import com.atlucky.springsecuritytest.utils.JwtUtils;
import com.atlucky.springsecuritytest.utils.RedisCache;
import com.atlucky.springsecuritytest.utils.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Objects;

/**
 * @Date 2023/8/15 16:32
 * @Author XiaoHu
 * @Description
 **/
@Service
@Slf4j
public class LoginServiceImpl implements LoginService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private RedisCache redisCache;

    @Override
    public ResponseResult login(User user) {
        //AuthenticationManager进行用户认证
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(user.getUserName(),user.getPassword());
        Authentication authenticate = authenticationManager.authenticate(token);
        //如果认证没有通过，给出提示
        if (Objects.isNull(authenticate)){
            throw new RuntimeException("认证失败！");
        }
        //如果认证通过，使用userid生成jwt
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        //把完整的用户信息存入Redis userid作为key
        String userid = loginUser.getUser().getId().toString();
        String jwt = JwtUtils.createJwt(userid);
        HashMap<String, String> map = new HashMap<>();
        map.put("token",jwt);
        redisCache.setCacheObject("login_"+userid,loginUser);
        return new ResponseResult<>(200,"登录成功",map);
    }
}
