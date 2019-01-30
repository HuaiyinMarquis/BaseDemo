package com.exampleDemo;

import org.junit.Test;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by ChenMP on 2018/4/18.
 */
public class TestString {
    @Test
    public void testIntern() {
        String str1 = new StringBuilder("计算机").append( "软件" ).toString();
        System.out.println(str1.intern()==str1);  //false
        String str2 = new StringBuilder("ja").append( "va" ).toString();
        System.out.println(str2.intern()==str2);
        String str3 = new StringBuilder("ma").append( "in" ).toString();
        System.out.println(str3.intern()==str3);
        String str4 = new StringBuilder("NN").append( "GX" ).toString();
        System.out.println(str4.intern()==str4);
        String str5 = new StringBuilder("asdga").append( "GX" ).toString();
        System.out.println(str5.intern()==str5);
    }

    @Test
    public void testN() {
        System.out.println("你\n好");
    }

    @Test
    public void testSub() {
        String a = "0123456789";
        System.out.println(a.substring(1,6));
    }

    @Test
    public void testInteger() {
        Integer in = Integer.valueOf(2);
        Integer i = new Integer(2);
        System.out.println(in == i);
        System.out.println(Integer.toBinaryString(7));

    }

    @Test
    public void testExecutors() {
        Executors.newCachedThreadPool();
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Executors.newSingleThreadExecutor();
        Executors.newScheduledThreadPool(10);

        AtomicInteger i = new AtomicInteger(1);
        i.incrementAndGet();
//        AtomicIntegerFieldUpdater
//        AtomicLongFieldUpdater
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        lock.unlock();

        System.out.println(Integer.MAX_VALUE);
        System.out.println(Long.MAX_VALUE);
        System.out.println(i);
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        threadLocal.set("");
        threadLocal.get();
    }

    @Test
    public void testArray() {
        int[] is = new int[10];
        System.out.println(is[5]);

        StringBuffer sb = new StringBuffer();
        Arrays.asList(is).forEach((t) -> {
            System.out.println(":"+t);
            sb.append(t);});
        System.out.println(sb.toString());

        String[] s = new String[2];
        System.out.println(s[0]);
    }

    @Test
    public void testStr() {
        String a = "1234567890";
        String aa = new String("1234567890");
        System.out.println(a == aa);
        System.out.println(aa.equals(a));
        System.out.println(a.substring(1,2));
    }
}
