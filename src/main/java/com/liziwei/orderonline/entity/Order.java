package com.liziwei.orderonline.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.sql.Timestamp;

/**
 * @author liziwei
 * @title: Order
 * @projectName orderonline
 * @description: TODO
 * @date 2020/2/8 13:00
 */
@Data
public class Order {

    /**
     * 主键
     */
    @Id
    private Integer id;

    /**
     * 订单总价价格
     */
    private Double totalMoney;

    /**
     * 下单时间
     */
    private Timestamp createTime;

    /**
     * 下单人id
     */
    private Integer userId;

    /**
     * 订单状态
     */
    private Integer state;


}
