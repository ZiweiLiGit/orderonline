package com.liziwei.orderonline.service.imp;

import com.liziwei.orderonline.entity.Food;
import com.liziwei.orderonline.entity.FoodCar;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author liziwei
 * @title: FoodCarServiceTest
 * @projectName orderonline
 * @description: TODO
 * @date 2020/2/25 9:43
 */

@RunWith(SpringRunner.class)
@SpringBootTest
class FoodCarServiceTest {

    @Autowired
    private FoodCarService foodCarService;
    @Test
    void selectFoodCar() {

        List<FoodCar> foodCar = foodCarService.selectFoodCar(29);
        System.out.println(foodCar);

    }
    @Test
    void deleteFromFoodCar(){
        int i = foodCarService.deleteFromFoodCar(2);
        System.out.println(i);
    }
}