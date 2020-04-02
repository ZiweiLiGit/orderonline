package com.liziwei.orderonline.service.imp;

import com.liziwei.orderonline.entity.Food;
import com.liziwei.orderonline.mapper.FoodMapper;
import com.liziwei.orderonline.service.IFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liziwei
 * @title: FoodService
 * @projectName orderonline
 * @description: TODO
 * @date 2020/2/16 20:21
 */
@Service
public class FoodService implements IFoodService {

    @Autowired
    private FoodMapper foodMapper;
    @Override
    public int addFood(Food food) {
        return foodMapper.addFood(food);
    }

    @Override
    public int deleteFood(int id) {
        return foodMapper.deleteFood(id);
    }

    @Override
    public int updateFood(Food food) {
        return foodMapper.updateFood(food);
    }

    @Override
    public List<Food> selectAllFoodList() {
        return foodMapper.selectAllFoodList();
    }

    @Override
    public Food selectFoodById(int id) {
        return foodMapper.selectFoodById(id);
    }
}
