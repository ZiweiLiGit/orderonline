package com.liziwei.orderonline.service.imp;

import com.liziwei.orderonline.entity.User;
import com.liziwei.orderonline.mapper.UserMapper;
import com.liziwei.orderonline.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liziwei
 * @title: UserService
 * @projectName orderonline
 * @description: TODO
 * @date 2020/2/7 22:46
 */
@Service
public class UserService implements IUserService {


    @Autowired
    private UserMapper userMapper;

    /***
     *
     * 用户登录
     * @param user
     * @return
     */
    @Override
    public User userLogin(User user) {
        return userMapper.userLogin(user);
    }

    /**
     * 用户注册
     *
     * @param user
     * @return
     */
    @Override
    public int guessRegister(User user) {
        return userMapper.guessRegister(user);
    }

    @Override
    public List<User> selectAllGuess() {
        return userMapper.selectAllGuess();
    }


    @Override
    public User adminUpdate(User user) {
        return userMapper.adminUpdate(user);
    }

    @Override
    public User adminLogin() {
        return userMapper.adminLogin();
    }


}
