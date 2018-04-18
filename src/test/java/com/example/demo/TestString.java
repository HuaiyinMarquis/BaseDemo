package com.example.demo;

import org.junit.Test;

/**
 * Created by ChenMP on 2018/4/18.
 */
public class TestString {
    @Test
    public void testIntern() {
        String str1 = new StringBuilder("计算机").append( "软件" ).toString();
        System.out.println(str1.intern()==str1);
        String str2 = new StringBuilder("ja").append( "va" ).toString();
        System.out.println(str2.intern()==str2);
        String str3 = new StringBuilder("ma").append( "in" ).toString();
        System.out.println(str3.intern()==str3);
        String str4 = new StringBuilder("NN").append( "GX" ).toString();
        System.out.println(str4.intern()==str4);
    }
}
