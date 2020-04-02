package com.liziwei.orderonline.controller;

import com.liziwei.orderonline.entity.ApiResponse;
import com.liziwei.orderonline.entity.Food;
import com.liziwei.orderonline.entity.FoodCarItem;
import com.liziwei.orderonline.service.imp.FoodCarService;
import com.liziwei.orderonline.service.imp.FoodService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author liziwei
 * @title: FoodController
 * @projectName orderonline
 * @description: TODO
 * @date 2020/2/16 20:26
 */
@Controller
@RequestMapping(value = "/api/food")
public class FoodController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private FoodService foodService;
    @Autowired
    private FoodCarService foodCarService;

    @RequestMapping("addFood")
    @ResponseBody
    public Object addFood(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        httpServletResponse.setHeader("Access-Control-Allow-Origin","*");
        httpServletResponse.setHeader("Content-Type","application/json");
        logger.info("添加菜品信息");

        String foodName = httpServletRequest.getParameter("foodname");
        Double price = Double.parseDouble(httpServletRequest.getParameter("price"));

        String pic = httpServletRequest.getParameter("images");

        String introduce = httpServletRequest.getParameter("introduce");
        int stock = Integer.parseInt(httpServletRequest.getParameter("stock"));

        Food food = new Food();
        food.setFoodName(foodName);
        food.setPic(pic);
        food.setIntroduce(introduce);
        food.setStock(stock);
        food.setPrice(price);

        int i = foodService.addFood(food);
        if (i != 0) {
            return ApiResponse.createBySuccess("保存成功");
        }
        return ApiResponse.createByError("保存失败");
    }

    @RequestMapping(value = "/uploadImg",method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public Object uploadImg(@RequestParam("file") MultipartFile multipartFile, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        httpServletResponse.setHeader("Access-Control-Allow-Origin","*");
        String prefix = "";
        String dateStr = "";
        //保存上传
        OutputStream out = null;
        InputStream fileInput = null;
        try{
            if (multipartFile!=null){
                String originName = multipartFile.getOriginalFilename();
                prefix = originName.substring(originName.lastIndexOf('.')+1);
                Date date = new Date();
                String uuid = UUID.randomUUID()+"";
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                dateStr = simpleDateFormat.format(date);
                String filepath = "D:\\Works\\liziwei\\src\\main\\resources\\static\\assets\\images\\dataImages\\" + dateStr + "\\" + uuid + "." + prefix;
                File files=new File(filepath);
                //打印查看上传路径
                System.out.println(filepath);
                if(!files.getParentFile().exists()){
                    files.getParentFile().mkdirs();
                }
                multipartFile.transferTo(files);
                Map<String,Object> map2=new HashMap<>();
                Map<String,Object> map=new HashMap<>();
                map.put("code",0);
                map.put("msg","上传成功");
                map.put("data",map2);
//                http://localhost:63342/orderonline/static/assets/images/dataImages/2020-02-22/2af1b80a-9be4-4c60-b435-d3049174a2e2.jpg
                map2.put("src","http://localhost:63342/orderonline/static/assets/images" + "/dataImages/"+ dateStr+"/"+uuid+"." + prefix);
                return map;
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally{
            try {
                if(out!=null){
                    out.close();
                }
                if(fileInput!=null){
                    fileInput.close();
                }
            } catch (IOException e) {
            }
        }
        Map<String,Object> map=new HashMap<>();
        map.put("code",1);
        map.put("msg","上传失败");
        return map;

    }

    @RequestMapping(value = "selectAllFoodList",method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public Object selectAllFoodList(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse){

        httpServletResponse.setHeader("Access-Control-Allow-Origin","*");
        logger.info("获取所有菜品信息");

        List<Food> foods = foodService.selectAllFoodList();
        if (foods!=null && foods.size()!=0){
            return ApiResponse.createBySuccess(foods);
        }else if (foods!=null && foods.size() == 0){
            return ApiResponse.createBySuccess("没有菜品");
        }
        return ApiResponse.createByError("获取失败");
    }

    @RequestMapping(value = "updateFood",method = RequestMethod.POST)
    @ResponseBody
    public Object updateFood(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse){

        String id = httpServletRequest.getParameter("id");
        String foodName = httpServletRequest.getParameter("foodName");
        Double price =Double.parseDouble(httpServletRequest.getParameter("price"));

        String pic = httpServletRequest.getParameter("pic");

        String introduce = httpServletRequest.getParameter("introduce");
        int stock = Integer.parseInt(httpServletRequest.getParameter("stock"));

        Food food = new Food();
        food.setFoodName(foodName);
        food.setPic(pic);
        food.setIntroduce(introduce);
        food.setStock(stock);
        food.setPrice(price);

        logger.info("更新菜品 id: " + id);

        int result = foodService.updateFood(food);
        if (result != 0){
            return ApiResponse.createBySuccess("更新成功");
        }
        return ApiResponse.createByError("更新失败");
    }



    @RequestMapping(value = "deleteFood",method = RequestMethod.POST)
    @ResponseBody
    public Object deleteFood(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse){
        int id = Integer.parseInt(httpServletRequest.getParameter("id"));

        int result = foodService.deleteFood(id);


        if (result != 0){
            return ApiResponse.createBySuccess("删除成功");
        }
        return ApiResponse.createByError("删除失败");
    }


    /**
     * 加入购物车
     * @param httpServletRequest
     * @param httpServletResponse
     * @return
     */
    @RequestMapping(value = "/addToFoodCar",method = RequestMethod.POST)
    @ResponseBody
    public Object addToFoodCar(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse){
        httpServletResponse.setHeader("Access-Control-Allow-Origin","*");
        httpServletResponse.setHeader("Content-Type","application/json");
        int userId = Integer.parseInt(httpServletRequest.getParameter("user_id"));
        int foodId = Integer.parseInt(httpServletRequest.getParameter("food_id"));
        int count = 1;

        FoodCarItem foodCar = new FoodCarItem();
        foodCar.setUserId(userId);
        foodCar.setFoodId(foodId);
        foodCar.setCount(count);
        int result = foodCarService.addFoodCar(foodCar);
        if (result>0){
            return ApiResponse.createBySuccess("添加成功");
        }
        return ApiResponse.createByError("添加 失败");

    }
}
