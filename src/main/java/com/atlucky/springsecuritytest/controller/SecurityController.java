package com.atlucky.springsecuritytest.controller;


import lombok.extern.slf4j.Slf4j;
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
    public String startGet(){
        return "Hello Security";
    }
}
