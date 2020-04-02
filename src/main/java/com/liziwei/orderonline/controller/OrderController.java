package com.liziwei.orderonline.controller;

import com.liziwei.orderonline.entity.ApiResponse;
import com.liziwei.orderonline.entity.Order;
import com.liziwei.orderonline.entity.OrderItem;
import com.liziwei.orderonline.service.imp.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * @author liziwei
 * @title: OrderController
 * @projectName orderonline
 * @description: TODO
 * @date 2020/2/17 0:03
 */

@Controller
@RequestMapping("api/order")
public class OrderController {


    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/showOrder",method = RequestMethod.POST)
    @ResponseBody
    public Object addOrder(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        int userId = Integer.parseInt(httpServletRequest.getParameter("user_id"));
        List<Order> orders = orderService.selectAllOrderById(userId);
        if (orders.size()>0){
            return ApiResponse.createBySuccess("获取成功",orders);
        }
        return ApiResponse.createBySuccess("没有订单");

    }





}
