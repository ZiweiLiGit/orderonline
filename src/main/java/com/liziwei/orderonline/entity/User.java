package com.liziwei.orderonline.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

/**
 * @author liziwei
 * @title: User
 * @projectName orderonline
 * @description: TODO
 * @date 2020/2/7 17:26
 */

@Data
public class User {
    /**
     * 用户id
     */
    @Id
    private Integer id;

    /**
     * 用户名
     */
    private String userName;

    /**
     *用户身份证号码
     */
    private String userIdNo;

    /**
     *性别
     */
    private String sex;

    /**
     * 用户登录密码
     */
    private String password;

}
