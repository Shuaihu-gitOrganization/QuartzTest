package com.atlucky.springsecuritytest.controller;


import com.atlucky.springsecuritytest.domain.LoginUser;
import jdk.jfr.Percentage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Date 2023/8/9 13:26
 * @Author XiaoHu
 * @Description
 **/
@RestController
@Slf4j
@RequestMapping("/api")
public class SecurityController {

    @GetMapping("/start")
    //@PreAuthorize("hasAuthority('sys:dept:list')")
//    @PreAuthorize("hasAnyAuthority('sys:dept:list','sys:test:list')")//测试任意权限
    @PreAuthorize("@EX.hasAuthority('sys:dept:list')")//自定义权限校验SPEL表达式
    public String startGet(){
        return "Hello Security";
    }
    @GetMapping("/getUser")
    @PreAuthorize("@EX.hasAuthority('sys:dept:list')")//自定义权限校验SPEL表达式
    public String getLoginUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser user = (LoginUser) authentication.getPrincipal();
        return user.toString();
    }


}
