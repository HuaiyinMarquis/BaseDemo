package com.example.demo;

/**
 * Created by ChenMP on 2018/3/28.
 */
public class TestFinally {
    public static void main(String[] args) {
        try {
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
