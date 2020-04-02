package com.liziwei.orderonline.mapper;

import com.liziwei.orderonline.entity.Food;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author liziwei
 * @title: FoodMapperTest
 * @projectName orderonline
 * @description: TODO
 * @date 2020/2/8 11:30
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class FoodMapperTest {

    @Autowired
    private FoodMapper foodMapper;


    @Test
    public void addFoodTest(){
        Food food = new Food();
        food.setFoodName("榨菜炒肉丝");
        food.setPrice(25d);
        food.setIntroduce("这是一道超级下饭的家常菜");
        food.setPic("zhaicaichaors.jpg");
        food.setStock(100);

        int i = foodMapper.addFood(food);
        System.out.println("i: " + i);

    }

    @Test
    public void deleteFood(){
        int id = 1;
        int i = foodMapper.deleteFood(1);
        System.out.println("i: " + i);
    }

    @Test
    public void updateFood(){
        Food food = new Food();
        food.setId(2);
        food.setFoodName("榨菜炒肉丝");
        food.setPrice(23d);
        food.setIntroduce("这是修改以后的榨菜炒肉丝");
        food.setPic("zhaicaichaors.jpg");
        food.setStock(900);
        int i = foodMapper.updateFood(food);
        System.out.println("i : " + i);
    }

    @Test
    public void selectAllFoodList(){
        List<Food> foods = foodMapper.selectAllFoodList();
        System.out.println(foods.size());
    }

    @Test
    public void selectFoodById(){
        int id = 8;
        Food food = foodMapper.selectFoodById(id);
        System.out.println(food.toString());
    }


}