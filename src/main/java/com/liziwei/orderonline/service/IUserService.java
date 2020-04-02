package com.liziwei.orderonline.service;

import com.liziwei.orderonline.entity.User;

import java.util.List;

/**
 * @author liziwei
 * @title: IUserService
 * @projectName orderonline
 * @description: TODO
 * @date 2020/2/7 22:45
 */
public interface IUserService {

    /**
     * 用户登录
     * @param user
     * @return
     */
    User userLogin(User user);
    /**b
     * 用户注册
     * @param user
     * @return
     */
    int guessRegister(User user);

    /**
     * 获取所有顾客信息
     * @return
     */
    List<User> selectAllGuess();



    User adminUpdate(User user);

    /**
     * 管理员登录 获取唯一管理员信息
     * @return
     */
    User adminLogin();
}
