package com.atlucky.springsecuritytest.handler;

import com.alibaba.fastjson.JSON;
import com.atlucky.springsecuritytest.utils.ResponseResult;
import com.atlucky.springsecuritytest.utils.WEBUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 认证入口点处理程序
 *
 * @Date 2023/8/17 17:03
 * @Author XiaoHu
 * @Description
 **/
@Component
public class AuthenticationEntryPointHandler implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        ResponseResult responseResult = new ResponseResult(HttpStatus.UNAUTHORIZED.value(),"用户认证失败请重新登录" );
        String resultJson = JSON.toJSONString(responseResult);
        //处理异常
        WEBUtils.renderString(response,resultJson);

    }
}

