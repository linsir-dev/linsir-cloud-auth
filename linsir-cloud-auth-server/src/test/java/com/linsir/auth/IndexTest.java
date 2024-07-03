package com.linsir.auth;

import com.linsir.auth.modules.rabc.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class IndexTest {


    @Autowired
    private UserService userService;


    @Test
    public void userServiceTest()
    {
        System.out.println(userService);
    }
}
