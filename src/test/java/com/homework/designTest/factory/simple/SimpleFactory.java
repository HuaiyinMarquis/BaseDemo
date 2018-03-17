package com.homework.designTest.factory.simple;

import com.homework.designTest.factory.MenNiu;
import com.homework.designTest.factory.Milk;
import com.homework.designTest.factory.YiLi;

/**
 * Created by ChenMP on 2018/3/4.
 */
public class SimpleFactory {
    public static Milk get(String milk) {
        if (milk.equals("MenNiu"))
            return new MenNiu();
        else if (milk.equals("YiLi"))
            return new YiLi();
        else
            return null;
   }
}
