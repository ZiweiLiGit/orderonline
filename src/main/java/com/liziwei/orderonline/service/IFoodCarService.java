package com.liziwei.orderonline.service;

import com.liziwei.orderonline.entity.Food;
import com.liziwei.orderonline.entity.FoodCar;
import com.liziwei.orderonline.entity.FoodCarItem;

import java.util.List;

/**
 * @author liziwei
 * @title: IFoodCarService
 * @projectName orderonline
 * @description: TODO
 * @date 2020/2/25 1:51
 */
public interface IFoodCarService {

    /**
     * 获取用户购物车
     * @param userId
     * @return
     */
    List<FoodCar> selectFoodCar(Integer userId);

    /**
     * 加入购物车
     * @param foodCarItem
     * @return
     */
    int addFoodCar(FoodCarItem foodCarItem);

    int deleteFromFoodCar(Integer foodCarId);

}
