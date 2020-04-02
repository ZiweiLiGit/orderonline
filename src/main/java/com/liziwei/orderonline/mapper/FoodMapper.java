package com.liziwei.orderonline.mapper;

import com.liziwei.orderonline.entity.Food;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author liziwei
 * @title: FoodMapper
 * @projectName orderonline
 * @description: TODO
 * @date 2020/2/8 11:17
 */
@Repository
public interface FoodMapper {

    /**
     * 添加菜品
     * @param food
     * @return
     */
    int addFood(@Param("food")Food food);

    /**
     * 删除菜品 根据id删除
     * @param id
     * @return
     */
    int deleteFood(@Param("id")Integer id);

    /**
     * 更新菜品信息
     * @return
     */
    int updateFood(@Param("food")Food food);

    /**
     * 获取所有菜品记录
     * @return
     */
    List<Food> selectAllFoodList();

    /**
     * 根据id获取菜品记录
     *
     * @param id
     * @return
     */
    Food selectFoodById(@Param("id") Integer id);
}
