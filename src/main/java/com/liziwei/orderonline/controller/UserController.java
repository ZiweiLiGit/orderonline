package com.liziwei.orderonline.controller;

import com.liziwei.orderonline.entity.ApiResponse;
import com.liziwei.orderonline.entity.User;
import com.liziwei.orderonline.service.imp.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author liziwei
 * @title: UserController
 * @projectName orderonline
 * @description: TODO
 * @date 2020/2/10 12:33
 */

@Controller
@RequestMapping("/api/user")
public class UserController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/table/guessTable",method = RequestMethod.POST)
    @ResponseBody
    public Object userTable(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        logger.info("显示用户列表");
        httpServletResponse.setHeader("Access-Control-Allow-Origin","*");
        httpServletResponse.setHeader("Content-Type","application/json");
        List<User> users = userService.selectAllGuess();
        return ApiResponse.createBySuccess(users);
    }


    @RequestMapping(value = "table/AdminUpdate",method = RequestMethod.POST)
    @ResponseBody
    public Object AdminUpdat(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse){

        logger.info("修改管理员信息");
        httpServletResponse.setHeader("Access-Control-Allow-Origin","*");
        httpServletResponse.setHeader("Content-Type","application/json");
        String username;
        String password;
        String userIdNo;
        String sex ;
        username = httpServletRequest.getParameter("username");
        password =  httpServletRequest.getParameter("password");
        userIdNo = httpServletRequest.getParameter("useridno");
        sex =  httpServletRequest.getParameter("sex");

        User user = new User();
        user.setUserName(username);
        user.setUserIdNo(userIdNo);
        user.setPassword(password);
        user.setSex(sex);
        User result = userService.adminUpdate(user);

        if (result!=null){
            return ApiResponse.createBySuccess("修改成功",result);
        }
        return ApiResponse.createByError("修改失败");
    }



}
