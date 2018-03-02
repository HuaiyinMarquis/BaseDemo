package com.example.demo.GabageCollectionTest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ChenMP on 2017/12/8.
 */
public class TestHeapJConsole {
    /**
     *内存占位符对象，一个OOMObject大约占64k
     */
    static class OOMObject {
        public byte[] plaseholder = new byte[64*1024];
    }

    public static void fillHeap(int num) throws InterruptedException {
        List<OOMObject> list = new ArrayList<>();

        for (int i=1; i<num; i++) {
            //稍作延迟，另监视曲线明显
            Thread.sleep(50);
            list.add(new OOMObject());
        }
        System.gc();
    }

    public static void main(String[] args) throws Exception {
        Thread.sleep(20*1000);
        fillHeap(10000);
    }

}


