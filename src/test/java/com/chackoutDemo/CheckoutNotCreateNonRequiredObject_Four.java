package com.chackoutDemo;

import java.util.Calendar;
import java.util.Date;

/**
 * subject：避免创建不必要的对象
 * Created by ChenMP on 2018/4/3.
 */
public class CheckoutNotCreateNonRequiredObject_Four {
    public static void main(String[] args) {
        /**
         * 为什么用1而不是用2
         * new Boolean("true") VS Boolean.valueOf("true") 优劣
         */
        String strObj = new String("Test string"); // 1.
        String str = "Test string"; // 2.
        strObj.intern(); //把String保存到常量池

        /**
         * 下面是重用对象的一个例子：
         */
        System.out.println(new WomanPrototype(new Date()).isLoli());
        /**
         * 自动装箱在这上面的理解
         */
        long t1 = System.currentTimeMillis();
        Long sumL = 0L;
        for (int i=0; i<Integer.MAX_VALUE; i++) {
            sumL += i;
        }
        long t2 = System.currentTimeMillis();
        /******************************************************/
        long suml = 0L;
        for (int i=0; i<Integer.MAX_VALUE; i++) {
            suml += i;
        }
        long t3 = System.currentTimeMillis();
        System.out.println("第一种花费的时间为：" + (t2-t1));
        System.out.println("第二种花费的时间为：" + (t3-t2));
        /**
         * 小对象的创建好回收动作是非常廉价的
         * 通过"对象池"来避免创建对象并不是一种很好的做法，出发池中的对象是非常重量级的
         */
    }
}

class WomanPrototype {
    private final Date birthDate;

    public WomanPrototype(Date birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isLoli() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR,1990);
        calendar.set(Calendar.MONTH,0);
        calendar.set(Calendar.DAY_OF_MONTH,1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);//时
        calendar.set(Calendar.MINUTE, 0);//分
        calendar.set(Calendar.SECOND, 0);//秒
        return calendar.getTime().before(birthDate);
    }
}

class WomanSingleton {
    private final Date birthDate;
    private static final Date compareDate;

    public WomanSingleton(Date birthDate) {
        this.birthDate = birthDate;
    }

    static {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR,1990);
        calendar.set(Calendar.MONTH,0);
        calendar.set(Calendar.DAY_OF_MONTH,1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);//时
        calendar.set(Calendar.MINUTE, 0);//分
        calendar.set(Calendar.SECOND, 0);//秒
        compareDate = calendar.getTime();
    }


}
