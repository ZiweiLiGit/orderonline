package com.liziwei.orderonline.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

/**
 * @author liziwei
 * @title: FoodCar
 * @projectName orderonline
 * @description: TODO
 * @date 2020/2/24 12:33
 */
@Data
public class FoodCarItem {

    /**
     * 主键 购物车id
     */
    @Id
    private Integer id;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 菜品id
     */
    private Integer foodId;

    /**
     * 数量
     */
    private Integer count;
}
