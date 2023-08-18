package com.atlucky.springsecuritytest.domain;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Date 2023/8/14 15:25
 * @Author XiaoHu
 * @Description
 **/
@Data
@AllArgsConstructor
@Slf4j
@NoArgsConstructor
public class LoginUser implements UserDetails {

    private User user;
    private List<String> permissions;
    @JSONField(serialize = false)
    private List<SimpleGrantedAuthority> authorities;

    public LoginUser(User user, List<String> list) {
        this.user=user;
        this.permissions=list;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //permissions中的权限信息封装到SimpleGrantedAuthority中
        /*ArrayList<GrantedAuthority> authorities = new ArrayList<>();
        for (String permission:
        permissions) {
            SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(permission);
            grantedAuthorities.add(simpleGrantedAuthority);
        }*/
        if (!Objects.isNull(authorities)){
            return  authorities;
        }
        List<SimpleGrantedAuthority> authorities = permissions
                .stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());

        return authorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
