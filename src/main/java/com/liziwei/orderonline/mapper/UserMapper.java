package com.liziwei.orderonline.mapper;

import com.liziwei.orderonline.entity.Food;
import com.liziwei.orderonline.entity.User;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author liziwei
 * @title: UserMapper
 * @projectName orderonline
 * @description: TODO
 * @date 2020/2/7 17:25
 */
@Repository
public interface UserMapper {

    /**
     * 用户登录
     * @param user
     * @return
     */
    User userLogin(@Param("user")User user);

    /**
     * 注册用户
     * @param user
     * @return
     */
    int guessRegister(@Param("user")User user);



    /**
     * 注销用户
     * @param id
     * @return
     */
    int deleteUser(@Param("id") Integer id);

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    int updateUser(@Param("food")User user);

    /**
     * 用户修改密码
     * @param password
     * @param id
     * @return
     */
    int updatePassword(@Param("password")String password,@Param("id")Integer id);

    /**
     * 获取所有顾客信息
     * @return
     */
    List<User> selectAllGuess();

    /**
     * 管理员登陆  获取唯一的管理员账号
     * @return
     */
    User adminLogin();

    /**
     * 修改管理员信息
     * @param user
     * @return
     */
    User adminUpdate(@Param("User") User user);

}
