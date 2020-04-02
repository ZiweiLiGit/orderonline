package com.liziwei.orderonline.service;

import com.liziwei.orderonline.entity.Food;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author liziwei
 * @title: IFoodService
 * @projectName orderonline
 * @description: TODO
 * @date 2020/2/16 20:19
 */
public interface IFoodService {

    /**
     * 添加食物
     * @param food
     * @return
     */
    int addFood(Food food);

    /**
     * 根据菜品id删除菜品
     * @param id
     * @return
     */
    int deleteFood(int id);

    /**
     * 修改菜品信息
     * @param food
     * @return
     */
    int updateFood(Food food);

    /**
     * 获取所有菜品
     *
     * @return
     */
    List<Food> selectAllFoodList();

    /**
     * 根据菜品id获取菜品信息
     * @param id
     * @return
     */
    Food selectFoodById(int id);

}
