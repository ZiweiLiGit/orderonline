package com.liziwei.orderonline.service.imp;

import com.liziwei.orderonline.entity.Order;
import com.liziwei.orderonline.entity.OrderItem;
import com.liziwei.orderonline.mapper.OrderItemMapper;
import com.liziwei.orderonline.service.IOrderItemService;
import com.liziwei.orderonline.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liziwei
 * @title: OrderIemService
 * @projectName orderonline
 * @description: TODO
 * @date 2020/2/27 1:02
 */
@Service
public class OrderIemService implements IOrderItemService {

    @Autowired
    private OrderItemMapper orderItemMapper;
    @Override
    public void addOrderItem(OrderItem orderItem) {
        orderItemMapper.addOrderItem(orderItem);
    }
}
