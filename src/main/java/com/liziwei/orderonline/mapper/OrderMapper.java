package com.liziwei.orderonline.mapper;

import com.liziwei.orderonline.entity.Order;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author liziwei
 * @title: OrderMapper
 * @projectName orderonline
 * @description: TODO
 * @date 2020/2/8 13:18
 */
@Repository
public interface OrderMapper {

    /**
     * 下单
     */
    void addOrder(@Param("order")Order order);

    /**
     * 支付订单 把订单状态从0改为1
     * @param id
     * @return
     */
    int payOrder(@Param("id")Integer id);


    /**
     * 根据用户id查询用户 所有订单 包括 未支付的订单
     * @param userId
     * @return
     */
    List<Order> selectAllOrderById(@Param("userId")Integer userId);

    /**
     * 查看单个用户已支付的订单
     * @param userId
     * @return
     */
    List<Order> selectUserPayedOrder(@Param("userId")Integer userId);
    /**
     * 查看单个用户已支付的订单
     * @param userId
     * @return
     */
    List<Order> selectUserUnPayedOrder(@Param("userId")Integer userId);

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
