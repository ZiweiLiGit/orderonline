package com.liziwei.orderonline.service;

import com.liziwei.orderonline.entity.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liziwei
 * @title: IOrderItemService
 * @projectName orderonline
 * @description: TODO
 * @date 2020/2/27 1:01
 */
public interface IOrderItemService {
    void addOrderItem(OrderItem orderItem);

}
