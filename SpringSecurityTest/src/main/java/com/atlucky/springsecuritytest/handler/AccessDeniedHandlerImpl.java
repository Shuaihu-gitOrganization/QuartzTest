package com.atlucky.springsecuritytest.handler;
import com.alibaba.fastjson.JSON;
import com.atlucky.springsecuritytest.utils.ResponseResult;
import com.atlucky.springsecuritytest.utils.WEBUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 拒绝访问处理器impl
 *
 * @Date 2023/8/17 17:27
 * @Author XiaoHu
 * @Description
 **/
@Component
public class AccessDeniedHandlerImpl implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        ResponseResult responseResult = new ResponseResult(HttpStatus.FORBIDDEN.value(),"权限不足" );
        String resultJson = JSON.toJSONString(responseResult);
        //处理异常
        WEBUtils.renderString(response,resultJson);
    }
}
