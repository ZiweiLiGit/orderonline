package com.liziwei.orderonline.common.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Calendar;
import java.util.Random;
import java.util.UUID;

/**
 * @author liziwei
 * @title: UploadUtil
 * @projectName orderonline
 * @description: TODO
 * @date 2020/2/20 17:00
 */
public class UploadUtil {
    /**
     * 获取文件真实名称
     * 由于浏览器的不同获取的名称可能为:c:/upload/1.jpg或者1.jpg ---123aas.jpg
     * 最终获取的为  1.jpg
     * @param name 上传上来的文件名称
     * @return	真实名称
     */
    public static String getRealName(String name){
        //获取最后一个"/"
        int index = name.lastIndexOf("\\");
        return name.substring(index+1);
    }
    /**
     * 获取随机名称
     * @param realName 真实名称
     * @return uuid 随机名称
     */
    public static String getUUIDName(String realName){
        //realname  可能是  1.jpg   也可能是  1
        //获取后缀名
        int index = realName.lastIndexOf(".");
        if(index==-1){
            return UUID.randomUUID().toString().replace("-", "").toUpperCase();
        }else{
            return UUID.randomUUID().toString().replace("-", "").toUpperCase()+realName.substring(index);
        }
    }
    /**
     * 获取文件目录,可以获取256个随机目录
     * @return 随机目录
     */
    public static String getDir(){
        String s="0123456789ABCDEF";
        Random r = new Random();
        return "/"+s.charAt(r.nextInt(16))+"/"+s.charAt(r.nextInt(16));
    }

    public static void main(String[] args) {
        //String s="G:\\day17-基础加强\\resource\\1.jpg";
		/*String s="1.jgp";
		String realName = getRealName(s);
		System.out.println(realName);

		String uuidName = getUUIDName(realName);
		System.out.println(uuidName);*/

        String dir = getDir();
        System.out.println(dir);
    }


}