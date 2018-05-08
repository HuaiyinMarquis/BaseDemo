package com.exampleDemo.ConstructorTest;

/**
 * Created by ChenMP on 2018/2/27.
 */
public class Son extends Father {

    public Son(String name) {
        super(name);
    }

    public Son() {
        System.out.println("Son构造方法");
    }

    {
        System.out.println("Son对象方法块");
    }

    static{
        System.out.println("Son 静态方法块");
    }

    public static void main(String[] args) {
        new Son();

        StringBuffer sb = new StringBuffer();
        sb.append("a").append("b").append("c");
        System.out.println(new String(sb));
        String str = "abcd";
        System.out.println(str.codePointAt(1));
        System.out.println(str.codePointBefore(3));
        StringBuilder sb1 = new StringBuilder();

        /**不指定泛型的时候*/
        int i=Son.add(1, 2); //这两个参数都是Integer，所以T为Integer类型
        Number f=Son.add(1, 1.2);//这两个参数一个是Integer，以风格是Float，所以取同一父类的最小级，为Number
        Object o=Son.add(1, "asd");//这两个参数一个是Integer，以风格是Float，所以取同一父类的最小级，为Object

        /**指定泛型的时候*/
        int a=Son.<Integer>add(1, 2);//指定了Integer，所以只能为Integer类型或者其子类
//        int b=Son.<Integer>add(1, 2.2);//编译错误，指定了Integer，不能为Float
        Number c=Son.<Number>add(1, 2.2); //指定为Number，所以可以为Integer和Float
        System.out.println(c);
    }

    public static <T> T add(T x,T y){
        return y;
    }
}
