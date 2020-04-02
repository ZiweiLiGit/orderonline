package com.liziwei.orderonline.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.liziwei.orderonline.entity.*;
import com.liziwei.orderonline.service.imp.FoodCarService;
import com.liziwei.orderonline.service.imp.OrderIemService;
import com.liziwei.orderonline.service.imp.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * @author liziwei
 * @title: FoodCarController
 * @projectName orderonline
 * @description: TODO
 * @date 2020/2/25 1:50
 */
@Controller
@RequestMapping("/api/foodCar")
public class FoodCarController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private FoodCarService foodCarService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderIemService orderIemService;

    @RequestMapping(value = "/showFoodCar", method = RequestMethod.POST)
    @ResponseBody
    public Object showFoodCar(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        httpServletResponse.setHeader("Access-Control-Allow-Origin","*");
        httpServletResponse.setHeader("Content-Type","application/json");
        int userid = Integer.parseInt(httpServletRequest.getParameter("userid"));
        List<FoodCar> foodCars = foodCarService.selectFoodCar(userid);
        return ApiResponse.createBySuccess(foodCars);
    }
    @RequestMapping(value = "/deleteFromFoodCar", method = RequestMethod.POST)
    @ResponseBody
    public Object deleteFromFoodCar(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        httpServletResponse.setHeader("Access-Control-Allow-Origin","*");
        httpServletResponse.setHeader("Content-Type","application/json");

        int foodCarId = Integer.parseInt(httpServletRequest.getParameter("food_car_id"));

        int result = foodCarService.deleteFromFoodCar(foodCarId);
        if (result>0){
            return  ApiResponse.createBySuccess("删除成功");
        }
        return ApiResponse.createByError("删除失败");
    }
    @RequestMapping(value = "/addToOrder", method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public Object addToOrder(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,@RequestBody String jsonStr) {
        httpServletResponse.setHeader("Access-Control-Allow-Origin","*");
        httpServletResponse.setHeader("Content-Type","application/json");

        JSONArray jsonArray = JSONArray.parseArray(jsonStr);
        ArrayList<OrderItem> orderItems = new ArrayList<>();
        int userId = 0;
        double totalMoney = 0;
        if (jsonArray.size()>0){
            for (int i =0;i<jsonArray.size();i++){
                System.out.println(i + ": " + jsonArray.get(i));
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                FoodCar foodCar = jsonObject.toJavaObject(FoodCar.class);
                int foodId = foodCar.getFoodId();
                userId = foodCar.getUserId();
                int count = foodCar.getCount();
                double money = foodCar.getMoney();
                totalMoney += money;
                OrderItem orderItem = new OrderItem();
                orderItem.setCount(count);
                orderItem.setFoodId(foodId);
                orderItem.setSubtotal(foodCar.getMoney());
                orderItems.add(orderItem);
            }
            //创建订单
            Order order = new Order();
            order.setUserId(userId);
            order.setState(0);
            order.setTotalMoney(totalMoney);
            orderService.addOrder(order);
//            System.out.println(order.getId());

            for (int i = 0 ;i<orderItems.size();i++){
                orderItems.get(i).setOrderId(order.getId());
                orderIemService.addOrderItem(orderItems.get(i));
            }

            return ApiResponse.createBySuccess("下单成功");
        }
        return ApiResponse.createByError("下单失败");
    }
}
