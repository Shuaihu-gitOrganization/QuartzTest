package com.atlucky.springsecuritytest.expression;

import com.atlucky.springsecuritytest.domain.LoginUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * @Date 2023/8/18 11:06
 * @Author XiaoHu
 * @Description
 **/
@Component("EX")
public class SecurityGlobalExpressionRoot {
   public boolean hasAuthority(String authority){
       //获取当前用户权限
       Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
       LoginUser loginUser = (LoginUser)authentication.getPrincipal();
       List<String> permissions = loginUser.getPermissions();

       //判断用户权限在不在authority当中
       return permissions.contains(authority);

   }
}
