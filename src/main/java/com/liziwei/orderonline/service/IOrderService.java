package com.liziwei.orderonline.service;

import com.liziwei.orderonline.entity.Food;
import com.liziwei.orderonline.entity.Order;

import java.util.List;

/**
 * @author liziwei
 * @title: OrderService
 * @projectName orderonline
 * @description: TODO
 * @date 2020/2/16 22:55
 */
public interface IOrderService {

    /**
     * 下单
     * @param order
     * @return
     */
    void addOrder (Order order);

    /**
     * 支付订单
     *
     * @param id
     * @return
     */
    int payOrder(int id);

    /**
     * 根据用户id查询用户 所有订单 包括 未支付的订单
     * @return
     */
    List<Order> selectAllOrderById(Integer userId);


    /**
     * 查看单个用户已支付的订单
     * @return
     */
    List<Order> selectUserPayedOrder(Integer userId);


    /**
     * 查看单个用户已支付的订单
     *
     * @param userId
     * @return
     */
    List<Order> selectUserUnPayedOrder(Integer userId);


    /**
     * 查看所有用户的已支付的订单
     * @return
     */
    List<Order> selectAllPayedOrder();


    /**
     * 查看所有用户未支付的订单
     * @return
     */
    List<Order> selectAllUnPayedOrder();


}

