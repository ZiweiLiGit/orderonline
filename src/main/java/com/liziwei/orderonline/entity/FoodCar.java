package com.liziwei.orderonline.entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author liziwei
 * @title: FoodCar
 * @projectName orderonline
 * @description: TODO
 * @date 2020/2/25 21:12
 */
@Data
public class FoodCar {

    /**
     * 购物车里菜品记录id
     */
    private Integer id;

    /**
     * 对应用户id
     */
    private int userId;

    /**
     * 对应菜品id
     */
    private int foodId;

    /**
     * 菜名
     */
    private String foodName;
    /**
     * 价格
     */
    private Double price;
    /**
     * 价格
     */
    private String pic;
    /**
     * 介绍
     */
    private String introduce;
    /**
     * 库存
     */
    private Integer stock;

    /**
     * 数量
     */
    private int count;

    /**
     * 单条价格
     */
    private double money;


}
