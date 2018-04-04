package com.chackoutDemo;

import java.util.EnumSet;
import java.util.concurrent.Executors;

/**
 * subject：考虑用静态方法代替构造器（跟设计模式中的工厂方法模式是不同的）
 * Created by ChenMP on 2018/4/2.
 */
public class CheckoutStaticFactoryMethod_One {
    public static void main(String[] args) {
        /**
         * 为何使用静态工厂方法创建对象？
         *  1、第一大优势：有名称
         *      基于面向对象内部封装外部不可见的原则，我们并不清楚调用该的构造方法时所传参数的具体含义，很有可能会有误解
         *      因为静态工厂方法可以有方法名称，我们可以通过方法名称判断入参具体含义
         */
        Apple.getAppleUseColorFrom("Read","Tokyo");
        /**
         *  2、第二大优势：不必每次调用都创建一个新的对象
         *      因为创建对象的代价很高，一些重复的对象是不必要创建的，我们可以将构建好的实例缓存起来。example：
         */
        Boolean.valueOf(true);
        /**
         *  3、第三大优势：可以返回原返回类型的任何子类型对象，这样我们就有了更大的灵活性
         */
        EnumSet<Color> enumSet = EnumSet.noneOf(Color.class);
        enumSet.add(Color.BLACK);
        enumSet.add(Color.RED);
        enumSet.add(Color.YELLOW);
        System.out.println("enumSet:" + enumSet);
        /**
         *  4、第四大优势：在创建参数化实例的时候，使代码变得简洁
         *      在一些可以使用默认参数的地方可以省去一些代码
         */
        Executors.newFixedThreadPool(4);
        /**
         * 主要缺点：
         *  1、类如果不包含public和protected的构造方法，就不能被子类化（第三大优势）
         *  2、与其他静态方法实际上没有任何区别
         */

    }

}
class Apple {
    private String color;
    private String from;

    public Apple(String a, String b) {
        this.color = a;
        this.from = b;
    }

    public static Apple getAppleUseColorFrom(String a, String b) { //先color后from
        return new Apple(a,b);
    }

    public static Apple getAppleUseFromColor(String b, String a) { //先from后color
        return new Apple(a,b);
    }

    @Override
    public String toString() {
        return "Apple{" +
                "color='" + color + '\'' +
                ", from='" + from + '\'' +
                '}';
    }
}
