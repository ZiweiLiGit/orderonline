package com.liziwei.orderonline.service.imp;

import com.liziwei.orderonline.entity.Order;
import com.liziwei.orderonline.mapper.OrderMapper;
import com.liziwei.orderonline.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liziwei
 * @title: OrderService
 * @projectName orderonline
 * @description: TODO
 * @date 2020/2/16 23:08
 */
@Service
public class OrderService implements IOrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public void addOrder(Order order) {
        orderMapper.addOrder(order);
    }

    @Override
    public int payOrder(int id) {
        return orderMapper.payOrder(id);
    }

    @Override
    public List<Order> selectAllOrderById(Integer userId) {
        return orderMapper.selectAllOrderById(userId);
    }

    @Override
    public List<Order> selectUserPayedOrder(Integer userId) {
        return orderMapper.selectUserPayedOrder(userId);
    }



    @Override
    public List<Order> selectUserUnPayedOrder(Integer userId) {
        return orderMapper.selectUserUnPayedOrder(userId);
    }

    @Override
    public List<Order> selectAllPayedOrder() {
        return orderMapper.selectAllPayedOrder();
    }

    @Override
    public List<Order> selectAllUnPayedOrder() {
        return orderMapper.selectAllUnPayedOrder();
    }
}
