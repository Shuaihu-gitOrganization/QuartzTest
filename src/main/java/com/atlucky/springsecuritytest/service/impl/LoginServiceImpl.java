package com.atlucky.springsecuritytest.service.impl;

import com.atlucky.springsecuritytest.domain.LoginBody;
import com.atlucky.springsecuritytest.domain.User;
import com.atlucky.springsecuritytest.mapper.UserMapper;
import com.atlucky.springsecuritytest.service.LoginService;
import com.atlucky.springsecuritytest.utils.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Service;

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



    @Override
    public ResponseResult login(LoginBody loginBody) {
        //AuthenticationManager进行用户认证

        //如果认证没有通过，给出提示

        //如果认证通过，使用userid生成jwt

        //把完整的用户信息存入Redis userid作为key

        return null;
    }
}
