package com.atlucky.springsecuritytest.service;

import com.atlucky.springsecuritytest.domain.User;
import com.atlucky.springsecuritytest.utils.ResponseResult;

/**
 * @Date 2023/8/15 16:31
 * @Author XiaoHu
 * @Description
 **/

public interface LoginService {
    public ResponseResult login(User user);

    public ResponseResult logout();
}
