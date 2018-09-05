package com.exampleDemo;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ChenMP on 2018/3/28.
 */
public class TestFinally extends WeakReference<TestFinally> {
    public TestFinally(TestFinally referent) {
        super(referent);
    }

    public static void main(String[] args) {
        try {
            System.out.println(getStr());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static String getStr() throws Exception {
        try {
            throw new Exception("抛出异常");
        } finally {
            return "return finally";
        }
    }
}
