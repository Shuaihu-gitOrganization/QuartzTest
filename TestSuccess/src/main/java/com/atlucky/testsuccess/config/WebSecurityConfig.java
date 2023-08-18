package com.atlucky.testsuccess.config;

import com.atlucky.testsuccess.handler.LoginSuccessHandler;
import com.atlucky.testsuccess.handler.LoginFailureHandler;
import com.atlucky.testsuccess.handler.UserLogoutSuccessHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.annotation.Resource;

/**
 * @Date 2023/8/14 15:41
 * @Author XiaoHu
 * @Description
 **/
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)//开启前置鉴权
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    private LoginSuccessHandler loginSuccessHandler;

    @Resource
    private LoginFailureHandler loginFailureHandler;
    @Resource
    private UserLogoutSuccessHandler logoutSuccessHandler;
    /*@Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }*/

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin().successHandler(loginSuccessHandler).failureHandler(loginFailureHandler);
        http.logout().logoutSuccessHandler(logoutSuccessHandler);
        http.authorizeRequests().anyRequest().authenticated();

    }
}

