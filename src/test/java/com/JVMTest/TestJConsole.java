package com.JVMTest;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 打开Jconsole观察堆内存动态
 * -verbose:gc -XX:+PrintGCDetails -Xms20m -Xmx20m -XX:SurvivorRatio=8 -XX:-UseParallelOldGC  -XX:+UseConcMarkSweepGC
 */
public class TestJConsole {

//    byte[] data = new byte[128*1024];
    public static void main(String[] args) {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Start monitor...");

        fill(10000);
    }

    private static void fill(int n) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss");
        System.out.println(sdf.format(new Date()));

//        List<TestJConsole> list = new ArrayList();
        for (int i=0; i<n; i++) {
            try {
                TimeUnit.SECONDS.sleep(1);
//                StringBuffer sb = new StringBuffer(data);
//                sb.append(data);
//                sb.append(data);
//                sb.append(data);
//                sb.append(data);
//                sb.append(data);
//                sb.append(data);
//                sb.append(data);
//                sb.append(data);
//                sb.append(data);
//                sb.append(i);
//                String responseStr = sb.toString();
//                System.out.println(sdf.format(new Date()) + ":" +responseStr);

                byte[] bytes = new byte[1000*1024*1024];
                bytes = null; //help GC
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            list.add(new TestJConsole());
        }
    }
}
