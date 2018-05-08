package com.exampleDemo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by ChenMP on 2017/12/19.
 */
public class TestDate {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
        System.out.println(sdf.format(new Date()));
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//        System.out.println(sdf.format(new Date()));
//        Calendar instance = Calendar.getInstance();
//        instance.set(Calendar.DAY_OF_MONTH,instance.get(Calendar.DAY_OF_MONTH)-1);
//        System.out.println(sdf.format(instance.getTime()));
    }
}
