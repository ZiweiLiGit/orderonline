package com.liziwei.orderonline.common.utils;

/**
 * @author liziwei
 * @title: HttpRequestUtil
 * @projectName orderonline
 * @description: TODO
 * @date 2020/2/6 16:35
 */

import com.alibaba.fastjson.JSONObject;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HttpRequestUtil {

    public static String getRequestData(HttpServletRequest httpServletRequest) throws IOException {
        synchronized (httpServletRequest) {
            StringBuilder stringBuffer = new StringBuilder("");
            ServletInputStream requestInput = httpServletRequest.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(requestInput, "UTF-8"));
            String temp;
            while ((temp = bufferedReader.readLine()) != null) {
                stringBuffer.append(temp);
            }

            bufferedReader.close();
            return stringBuffer.toString();
        }

    }

}
