package com.liziwei.orderonline.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

/**
 * @author liziwei
 * @title: Food
 * @projectName orderonline
 * @description: TODO
 * @date 2020/2/8 11:17
 */
@Data
public class Food {

    /**
     * id
     */
    @Id
    private Integer id;

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



}
