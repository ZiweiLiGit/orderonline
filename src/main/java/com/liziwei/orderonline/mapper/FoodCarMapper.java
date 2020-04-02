package com.liziwei.orderonline.mapper;

import com.liziwei.orderonline.entity.FoodCarItem;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author liziwei
 * @title: FoodCarMapper
 * @projectName orderonline
 * @description: TODO
 * @date 2020/2/24 12:29
 */
@Repository
public interface FoodCarMapper {

    int addFoodCar(@Param("foodCarItem") FoodCarItem foodCar);


    List<FoodCarItem> selectFoodCar(@Param("userId")Integer userId);


    Integer  deleteFromFoodCar(@Param("foodCarId")Integer foodCarId);
}
