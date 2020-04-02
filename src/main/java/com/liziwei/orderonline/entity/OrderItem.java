package com.liziwei.orderonline.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

/**
 * @author liziwei
 * @title: OrderItem
 * @projectName orderonline
 * @description: TODO
 * @date 2020/2/8 13:03
 */

@Data
public class OrderItem {

    /**
     * 主键
     */
    @Id
    private Integer id;

    /**
     * 苏亮
     */
    private Integer count;

    /**
     * 总价
     */
    private Double subtotal;

    /**
     * 所属订单号
     */
    private Integer orderId;

    /**
     * 菜品id
     */
    private Integer foodId;
}
