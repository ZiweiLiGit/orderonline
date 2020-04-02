package com.liziwei.orderonline.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author liziwei
 * @title: CommonContorller
 * @projectName orderonline
 * @description: TODO
 * @date 2020/1/11 21:40
 */
@Controller
@RequestMapping(value = "/")
public class CommonController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 设置默认主页
     * @return
     */
    @RequestMapping(value = "/")
    public String index(){
        logger.info("跳转到主页");
        return "index";
    }

    /**
     * 跳转到登陆页面
     * @return
     */
    @RequestMapping(value = "/login")
    public String toLogin(){
        logger.info("跳转到登陆页面");
        return "login";
    }

    @RequestMapping(value = "/toRegister")
    public String toRegister(){
        logger.info("跳转到注册页面");
        return "register";
    }
}
