package com.liziwei.orderonline.mapper;

import com.liziwei.orderonline.entity.OrderItem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author liziwei
 * @title: OrderItemMapperTest
 * @projectName orderonline
 * @description: TODO
 * @date 2020/2/27 0:57
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderItemMapperTest {

    @Autowired
    private OrderItemMapper orderItemMapper;

    @Test
    public void addOrderItem(){
        OrderItem orderItem = new OrderItem();
        orderItem.setFoodId(8);
        orderItem.setCount(1);
        orderItem.setSubtotal(16d);
        orderItem.setOrderId(1);

        orderItemMapper.addOrderItem(orderItem);

        System.out.println(orderItem.getId());
    }




}