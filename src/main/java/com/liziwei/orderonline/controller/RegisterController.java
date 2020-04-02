package com.liziwei.orderonline.controller;

import com.liziwei.orderonline.common.enums.ResponseCode;
import com.liziwei.orderonline.common.utils.HttpRequestUtil;
import com.liziwei.orderonline.entity.ApiResponse;
import com.liziwei.orderonline.entity.User;
import com.liziwei.orderonline.service.imp.UserService;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author liziwei
 * @title: RegisterContorller
 * @projectName orderonline
 * @description: TODO
 * @date 2020/2/7 12:24
 */
@Controller
@RequestMapping(value = "/api/register")
public class RegisterController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private UserService userService;

    /**
     * 检查用户用户名可用性
     * @param httpServletRequest
     * @return
     */
    @RequestMapping(value = "/checkUsername", method = RequestMethod.POST)
    public Object checkUserName(HttpServletRequest httpServletRequest) {
        logger.info("检查用户用户名可用性");
        return "";
    }

    /**
     * 用户提交注册
     * 接受参数 json（username，password，useridno，sex）
     * 返回参数 json（status）
     * @param httpServletRequest
     * @return
     */
    @RequestMapping(value = "/registerSub", method = RequestMethod.POST)
    @ResponseBody
    public Object register(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        logger.info("用户提交注册");
        httpServletResponse.setHeader("Access-Control-Allow-Origin","*");
        httpServletResponse.setHeader("Content-Type","application/json");
        String username = httpServletRequest.getParameter("username");
        String password = httpServletRequest.getParameter("password");
        String userIdNo = httpServletRequest.getParameter("useridno");
        String sex = httpServletRequest.getParameter("sex");

        User user = new User();
        user.setUserName(username);
        user.setUserIdNo(userIdNo);
        user.setPassword(password);
        user.setSex(sex);

        int result = userService.guessRegister(user);
        if (result>0){
            //注册成功
            return ApiResponse.createBySuccess("注册成功");
        }
        //注册失败
        return ApiResponse.createByError("注册失败");
    }
}
