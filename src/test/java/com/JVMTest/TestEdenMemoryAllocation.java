package com.JVMTest;

import java.io.IOException;

/**
 * 分析新生代内存分配
 * VM Option：
 *  -verbose:gc -XX:+PrintGCDetails -XX:+UseSerialGC -Xms20m -Xmx20m -XX:SurvivorRatio=8
 */
public class TestEdenMemoryAllocation {
    public static void main(String[] args) throws IOException {
        byte[] bytes1 = new byte[2*1024*1024];
        byte[] bytes2 = new byte[2*1024*1024];
        byte[] bytes3 = new byte[2*1024*1024];
        byte[] bytes4 = new byte[4*1024*1024];

        System.gc();
        System.in.read();
    }
}
