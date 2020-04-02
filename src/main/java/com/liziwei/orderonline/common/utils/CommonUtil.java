package com.liziwei.orderonline.common.utils;

import java.lang.reflect.Field;

/**
 * @author liziwei
 * @title: CommonUtil
 * @projectName orderonline
 * @description: TODO
 * @date 2020/2/18 0:03
 */
public class CommonUtil {
    /**
     * 判断该对象是否: 返回ture表示所有属性为null  返回false表示不是所有属性都是null
     * @param obj
     * @return
     * @throws IllegalAccessException
     */
    public static boolean isAllFieldNull(Object obj){
        Class<?> aClass = obj.getClass();
        Field[] fs = aClass.getDeclaredFields();
        boolean flag=true;
        for (Field f : fs) {
            f.setAccessible(true);
            Object o = null;
            try {
                o = f.get(obj);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            if (o!=null){
                flag=false;
            }
        }
        return flag;
    }
}
