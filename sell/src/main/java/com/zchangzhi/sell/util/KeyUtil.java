package com.zchangzhi.sell.util;

import java.util.Random;

public class KeyUtil {
    /**
     * 生成唯一主键
     * 格式: 时间+随机数
     * 被修饰的代码块称为同步语句块，
     * */
    public static synchronized String  genUniqueKey(){
        Random random = new Random();
        System.currentTimeMillis();
        Integer i = random.nextInt(899999) + 100000;
        return System.currentTimeMillis()+String.valueOf(i);
    }
}
