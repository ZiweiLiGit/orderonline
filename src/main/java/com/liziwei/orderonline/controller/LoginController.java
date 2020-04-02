package com.liziwei.orderonline.controller;

import com.liziwei.orderonline.common.enums.ResponseCode;
import com.liziwei.orderonline.common.utils.CommonUtil;
import com.liziwei.orderonline.common.utils.HttpRequestUtil;
import com.liziwei.orderonline.entity.ApiResponse;
import com.liziwei.orderonline.entity.User;
import com.liziwei.orderonline.service.imp.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author liziwei
 * @title: LoginController
 * @projectName orderonline
 * @description: TODO
 * @date 2020/2/6 14:36
 */
@Controller
@RequestMapping(value = "/api/login")
public class LoginController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/checkLogin",method = RequestMethod.POST)
    @ResponseBody
    public Object checkLogin(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        httpServletResponse.setHeader("Access-Control-Allow-Origin","*");
        httpServletResponse.setHeader("Content-Type","application/json");
        logger.info("登录验证");
        logger.info("登录主机："+ httpServletRequest.getRemoteHost());

        String username;
        String password;
        username = httpServletRequest.getParameter("username");
        password =  httpServletRequest.getParameter("password");
//        判断是否是管理员登录
        User admin = userService.adminLogin();

        if (username.equals(admin.getUserName())){
            if (password.equals(admin.getPassword())){
                return ApiResponse.adminLogin();
            }
        }
        User user = new User();
        user.setUserName(username);
        user.setPassword(password);

        User result = userService.userLogin(user);
        if (result != null){
            return ApiResponse.userLogin(result);
        }
        return ApiResponse.createByError("登录失败，密码或用户名错误！");
    }
}
