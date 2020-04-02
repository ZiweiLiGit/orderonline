package com.liziwei.orderonline.mapper;

import com.liziwei.orderonline.entity.Order;
import com.liziwei.orderonline.entity.OrderItem;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author liziwei
 * @title: OrderItemMapper
 * @projectName orderonline
 * @description: TODO
 * @date 2020/2/8 13:07
 */
@Repository
public interface OrderItemMapper {

    /**
     * 添加进 订单
     * @param orderItem
     * @return
     */
    void addOrderItem(@Param("orderItem")OrderItem orderItem);


}
