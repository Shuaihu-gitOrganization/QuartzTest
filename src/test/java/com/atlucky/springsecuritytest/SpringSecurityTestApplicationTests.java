package com.atlucky.springsecuritytest;

import com.atlucky.springsecuritytest.domain.User;
import com.atlucky.springsecuritytest.mapper.MenuMapper;
import com.atlucky.springsecuritytest.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.mockito.exceptions.misusing.CannotStubVoidMethodWithReturnValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

@SpringBootTest
@Slf4j
class SpringSecurityTestApplicationTests {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private MenuMapper menuMapper;

    @Test
    void contextLoads() {
        List<User> users = userMapper.selectList(null);
        log.info("用户信息查询{}",users);
    }

    @Test
    public void  testBCryptPasswordEncoder(){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//        String encode = encoder.encode("123456");
//        String encoded = encoder.encode("123456");
//        log.info("{}",encode);
//        log.info("{}",encoded);
        boolean matches = encoder.matches("123456",
                "$2a$10$vX8ioKVdPXalfDwDRr6gO.oc9wMFLPUW.4xsSHKMLcKgw693XgtBK");
        log.info("{}",matches);
    }

    @Test
    public void testPermissionsById(){
        List<String> list = menuMapper.selectPermissionsById(1L);
        list.forEach(System.out::println);
    }

}
