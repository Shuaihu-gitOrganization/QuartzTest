package com.atlucky.springsecuritytest.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @Date 2023/8/15 16:36
 * @Author XiaoHu
 * @Description
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class LoginBody {
    private String username;
    private String password;
}
