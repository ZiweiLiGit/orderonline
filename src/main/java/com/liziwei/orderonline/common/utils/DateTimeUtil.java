package com.liziwei.orderonline.common.utils;

import java.time.LocalDateTime;

/**
 * @author liziwei
 * @title: DateTimeUtil
 * @projectName orderonline
 * @description: TODO
 * @date 2020/2/8 14:18
 */
public class DateTimeUtil {
    /**
     * 获取当前事件
     * @return
     */
    public static LocalDateTime getLocalDateTime(){
        LocalDateTime localDateTime = LocalDateTime.now();
        return localDateTime;
    }
}
