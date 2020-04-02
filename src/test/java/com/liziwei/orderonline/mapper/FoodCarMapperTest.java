package com.liziwei.orderonline.mapper;

import com.liziwei.orderonline.entity.FoodCar;
import com.liziwei.orderonline.entity.FoodCarItem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author liziwei
 * @title: FoodCarMapperTest
 * @projectName orderonline
 * @description: TODO
 * @date 2020/2/24 20:05
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class FoodCarMapperTest {

    @Autowired
    private FoodCarMapper foodCarMapper;

    @Test
    public void addFoodCar(){
        FoodCarItem foodCar = new FoodCarItem();
        foodCar.setFoodId(10);
        foodCar.setUserId(29);
        foodCar.setCount(1);

        int i = foodCarMapper.addFoodCar(foodCar);
        System.out.println(i);

    }

    @Test
    public void selectFoodCar(){
        List<FoodCarItem> foodCars = foodCarMapper.selectFoodCar(29);
        System.out.println(foodCars);
    }

    @Test
    public void deleteFromFoodCar(){
        Integer integer = foodCarMapper.deleteFromFoodCar(1);
        System.out.println(integer);
    }
}