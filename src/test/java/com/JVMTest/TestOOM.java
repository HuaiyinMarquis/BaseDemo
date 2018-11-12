package com.JVMTest;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试内存溢出，打开MemoryAnalyzer进行Dump分析
 * VM Option
 *  -XX:+HeapDumpOnOutOfMemoryError -Xms20m -Xms20m
 */
public class TestOOM {
    public static void main(String[] args) {
        List<Object> list = new ArrayList();
        for (;;) {
            list.add(new TestOOM());
        }
    }
}
