package com.exampleDemo;

import java.lang.reflect.Field;

public class SwapInteger {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Integer a=1,b=2;
        System.out.println("before: a="+a+",b="+b);
        swap(a,b);
        System.out.println("after: a="+a+",b="+b);
    }

    static void swap(Integer a,Integer b) throws NoSuchFieldException, IllegalAccessException {
        Field value = Integer.class.getDeclaredField("value");
        value.setAccessible(true);
//        int tmp = a.intValue();
        Integer tmp = new Integer(a.intValue());
        value.set(a,b.intValue());
        value.set(b,tmp);
        System.out.println(Integer.valueOf(tmp));
    }
}
