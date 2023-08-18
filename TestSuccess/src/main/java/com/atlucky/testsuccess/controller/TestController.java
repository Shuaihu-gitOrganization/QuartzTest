package com.atlucky.testsuccess.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Date 2023/8/18 11:48
 * @Author XiaoHu
 * @Description
 **/
@RestController
@RequestMapping("/test")
public class TestController {
    @GetMapping("/getTest")
    public String getTest(){
        return "new Test";
    }
}
