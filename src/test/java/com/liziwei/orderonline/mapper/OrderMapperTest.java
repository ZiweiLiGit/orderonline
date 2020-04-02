package com.liziwei.orderonline.mapper;

import com.liziwei.orderonline.common.utils.DateTimeUtil;
import com.liziwei.orderonline.entity.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author liziwei
 * @title: OrderMapperTest
 * @projectName orderonline
 * @description: TODO
 * @date 2020/2/8 13:58
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMapperTest {

    @Autowired
    private OrderMapper orderMapper;

    @Test
    public void addOrder(){

        Order order = new Order();
        order.setUserId(25);
        order.setTotalMoney(100.25d);
        order.setState(0);
        orderMapper.addOrder(order);
        System.out.println(order.getId());
    }

    @Test
    public void payOrder(){
        int id = 1;
        int i = orderMapper.payOrder(id);
        System.out.println("i : " + i);
    }

    @Test
    public void selectAllOrderById(){
        int userId = 29;
        List<Order> orders = orderMapper.selectAllOrderById(userId);
        System.out.println("siez: " + orders.size());
    }

    @Test
    public void selectUserPayedOrder(){
        int userId = 25;
        List<Order> orders = orderMapper.selectUserPayedOrder(userId);
        System.out.println("size: " + orders.size());
    }
    @Test
    public void selectUserUnPayedOrder(){
        int userId = 25;
        List<Order> orders = orderMapper.selectUserUnPayedOrder(userId);
        System.out.println("size: " + orders.size());
    }

    @Test
    public void selectAllPayedOrder(){
        List<Order> orders = orderMapper.selectAllPayedOrder();
        System.out.println("size: " + orders.size());
    }


    @Test
    public void selectAllUnPayedOrder(){
        List<Order> orders = orderMapper.selectAllUnPayedOrder();
        System.out.println("size: " + orders.size());
    }
}