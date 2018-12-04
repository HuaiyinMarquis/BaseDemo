package com.exampleDemo.ThreadLocalTest;

public class TestFinal {
    static String str = "one";

    public TestFinal(String str) {
        this.str = str;
    }

    public static void main(String[] args) {
        new TestFinal("two");
        System.out.println(TestFinal.str);

        ThreadLocal threadLocal = new ThreadLocal();
        threadLocal.set("33");
        showValue();
    }

    public static void showValue() {
        ThreadLocal threadLocal = new ThreadLocal();
        System.out.println(threadLocal.get());
    }
}
