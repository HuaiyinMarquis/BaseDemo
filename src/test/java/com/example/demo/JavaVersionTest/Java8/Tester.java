package com.example.demo.JavaVersionTest.Java8;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * Created by ChenMP on 2017/11/8.
 */
public class Tester {
    public static void main(String[] args) {

        SayHello sayHello = (name) -> {
            System.out.println("hello，"+name);
            return name;
        };

        Calculate calculate = (a,b)->{
            return a.add(b);
        };

   }
}

interface SayHello {
    String say(String name);
}

interface Calculate {
    BigDecimal doSomeThing(BigDecimal a , BigDecimal b);
}
