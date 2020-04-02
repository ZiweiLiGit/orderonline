package com.liziwei.orderonline.mapper;

import com.liziwei.orderonline.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author liziwei
 * @title: UserMapperTest
 * @projectName orderonline
 * @description: TODO
 * @date 2020/2/7 19:43
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    /**
     * 测试用户登录功能
     */
    @Test
    public void userLogin(){
        User user = new User();
        user.setUserName("liziwei");
        user.setPassword("password");
        User user1 = userMapper.userLogin(user);
        System.out.println(user1);
    }

    /**
     * 测试用户注册userMapper接口
     * userRegister方法
     *
     */
    @Test
    public void guessRegister(){
        User user = new User();
        user.setUserName("liziwei");
        user.setSex("女");
        user.setUserIdNo("123456789987877654");
        user.setPassword("password");

        int result = userMapper.guessRegister(user);
        System.out.println("result: " + result);
    }


    @Test
    public void deleteUser(){
        int id = 24;
        int i = userMapper.deleteUser(id);
        System.out.println("i : " + i);
    }

    @Test
    public void updateUser(){
        User user = new User();
        user.setId(25);
        user.setUserName("这是25号");
        user.setSex("女");
        user.setUserIdNo("123456789987877654");

        int i = userMapper.updateUser(user);
        System.out.println("i: "+ i);

    }
    @Test
    public void updatePassword(){
        int id = 25;
        String newPassword = "thisisnewPassword";
        int i = userMapper.updatePassword(newPassword, id);
        System.out.println("i: " + i);
    }
    @Test
    public void selectAllGuess(){
        List<User> users = userMapper.selectAllGuess();
        System.out.println(users.size());
    }


    @Test
    public void adminUpdate(){
        User user = new User();
        user.setId(30);
        user.setUserName("修改后的用户名");
        user.setSex("男");
        user.setUserIdNo("121212121211");
        User user1 = userMapper.adminUpdate(user);
        System.out.println(user1);
    }

    @Test
    public void adminLogin(){
        User user = userMapper.adminLogin();
        System.out.println(user);
    }

}