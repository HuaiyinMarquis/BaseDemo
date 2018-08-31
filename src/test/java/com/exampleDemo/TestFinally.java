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
            "dd".intern();Integer.valueOf(2);
            System.out.println(getStr());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static String getStr() {
        try {
            throw new Exception("抛出异常");
        } catch (Exception e) {
            throw e;
        } finally {
            return "return finally";
        }
    }
}
