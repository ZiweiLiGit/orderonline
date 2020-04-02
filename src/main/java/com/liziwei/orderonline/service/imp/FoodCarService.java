package com.liziwei.orderonline.service.imp;

import com.liziwei.orderonline.entity.Food;
import com.liziwei.orderonline.entity.FoodCar;
import com.liziwei.orderonline.entity.FoodCarItem;
import com.liziwei.orderonline.mapper.FoodCarMapper;
import com.liziwei.orderonline.mapper.FoodMapper;
import com.liziwei.orderonline.service.IFoodCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liziwei
 * @title: FoodCarService
 * @projectName orderonline
 * @description: TODO
 * @date 2020/2/25 9:00
 */
@Service
public class FoodCarService implements IFoodCarService {

    @Autowired
    private FoodCarMapper foodCarMapper;
    @Autowired
    private FoodMapper foodMapper;


    @Override
    public List<FoodCar> selectFoodCar(Integer userId) {

        List<FoodCarItem> foodCarItemList = foodCarMapper.selectFoodCar(userId);
        List<FoodCar> foodCarList = new ArrayList<>();
        for (int i = 0; i < foodCarItemList.size(); i++) {
            FoodCar foodCar = new FoodCar();
            foodCar.setId(foodCarItemList.get(i).getId());
            foodCar.setUserId(foodCarItemList.get(i).getUserId());
            Food food = foodMapper.selectFoodById(foodCarItemList.get(i).getFoodId());
            foodCar.setFoodId(food.getId());
            foodCar.setUserId(userId);
            foodCar.setFoodName(food.getFoodName());
            foodCar.setIntroduce(food.getIntroduce());
            foodCar.setPic(food.getPic());
            foodCar.setPrice(food.getPrice());
            foodCar.setStock(food.getStock());
            foodCar.setMoney(food.getPrice() * foodCar.getCount());
            foodCarList.add(foodCar);
        }


        return foodCarList;
    }

    @Override
    public int addFoodCar(FoodCarItem foodCarItem) {
        return foodCarMapper.addFoodCar(foodCarItem);
    }

    @Override
    public int deleteFromFoodCar(Integer foodCarId) {
        return foodCarMapper.deleteFromFoodCar(foodCarId);
    }
}
