package com.JVMTest;

import java.util.ArrayList;
import java.util.List;

/**
 * 打开Jconsole观察堆内存动态
 */
public class TestJConsole {
    public static void main(String[] args) {
        byte[] data = new byte[128*1024];
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Start monitor...");

        fill(10000);
    }

    private static void fill(int n) {
        List<TestJConsole> list = new ArrayList();
        for (int i=0; i<n; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list.add(new TestJConsole());
        }
    }
}
