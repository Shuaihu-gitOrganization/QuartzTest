package com.atlucky.springsecuritytest.controller;

import com.atlucky.springsecuritytest.domain.LoginBody;
import com.atlucky.springsecuritytest.domain.User;
import com.atlucky.springsecuritytest.service.LoginService;
import com.atlucky.springsecuritytest.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Date 2023/8/15 16:23
 * @Author XiaoHu
 * @Description
 **/
@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;
    @PostMapping("/api/login")
    public ResponseResult login(@RequestBody LoginBody loginBody){
        return loginService.login(loginBody);
    }
}
