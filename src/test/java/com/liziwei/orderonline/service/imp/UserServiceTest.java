package com.liziwei.orderonline.service.imp;

import com.liziwei.orderonline.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author liziwei
 * @title: UserServiceTest
 * @projectName orderonline
 * @description: TODO
 * @date 2020/2/7 22:48
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class UserServiceTest {

    @Resource
    private UserService userService;

    /**
     * 测试用户注册service
     */
    @Test
    void guessRegister() {
        User user = new User();
        user.setUserName("liziwei");
        user.setUserIdNo("11111111111111111111");
        user.setPassword("liziwei");
        user.setSex("女");
        int i = userService.guessRegister(user);
        System.out.println("i: " + i);
    }


    @Test
    void adminLogin(){
        User user = userService.adminLogin();
        System.out.println(user);
    }
}