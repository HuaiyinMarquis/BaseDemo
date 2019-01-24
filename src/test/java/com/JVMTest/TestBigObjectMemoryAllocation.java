package com.JVMTest;

/**
 * 测试大对象直接分配到Tenure
 *  VM Option：
 *      -verbose:gc -XX:+PrintGCDetails -XX:PretenureSizeThreshold=6M -Xms20m -Xmx20m
 */
public class TestBigObjectMemoryAllocation {
    public static void main(String[] args) {
        byte[] data = new byte[7*1024*1024];
        System.gc();
    }
}
