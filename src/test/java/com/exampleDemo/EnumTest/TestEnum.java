package com.exampleDemo.EnumTest;

import java.util.EnumMap;
import java.util.Map;
import java.util.Set;

/**
 * 枚举可以实现接口，不可以继承类
 * java.util.EnumSet和java.util.EnumMap是两个枚举集合
 *      EnumSet保证集合中的元素不重复；EnumMap中的 key是enum类型，而value则可以是任意类型。
 * Created by ChenMP on 2018/3/19.
 */
public class TestEnum {
    public static void main(String[] args) {
        Class<Integer> type = Integer.TYPE;
        System.out.println(BaseEnum.ONE.getNum());
        for (BaseEnum baseEnum :BaseEnum.values()) {
            System.out.println(baseEnum.getNum());
        }
        System.out.println("===========================================================");
        System.out.println(RefrenceEnum.APPLE);
        System.out.println(RefrenceEnum.BANANA == RefrenceEnum.BANANA);
        RefrenceEnum orange = RefrenceEnum.ORANGE;
        switch (orange) {
            case APPLE:
                System.out.println("apple");
                break;
            case ORANGE:
                System.out.println("orange");
                break;
            case BANANA:
                System.out.println("banana");
                break;
        }
        System.out.println("===========================================================");
        System.out.println(InterfaceEnum.Food.BLACK_COFFEE);
        System.out.println("=============================Test EnumMap==============================");
        EnumMap<BaseEnum,Object> map = new EnumMap<BaseEnum, Object>(BaseEnum.class);
        map.put(BaseEnum.ONE,"1");
        map.put(BaseEnum.TWO, new Object());
        map.put(BaseEnum.THREE, null);

        for (Map.Entry<BaseEnum,Object> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }
}
