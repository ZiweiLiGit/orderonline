package com.liziwei.orderonline.service;

import com.liziwei.orderonline.entity.User;
import com.liziwei.orderonline.service.imp.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author liziwei
 * @title: IUserServiceTest
 * @projectName orderonline
 * @description: TODO
 * @date 2020/2/16 19:32
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class IUserServiceTest {

    @Autowired
    private UserService userService;
    @Test
    public void userLogin(){
        User user = new User();
        user.setUserName("liziwei");
        user.setPassword("password");
        User user1 = userService.userLogin(user);
        System.out.println(user1);
    }

}