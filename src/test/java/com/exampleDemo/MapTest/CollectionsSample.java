package com.exampleDemo.MapTest;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;

public class CollectionsSample {
    public static void main(String[] args) {
        /*************************************/
        //原理为创建一个包装类，基于synchronzed对其中一些方法加锁进行同步化
        Map<String, String> synchronizedMap = Collections.synchronizedMap(new HashMap());
        /*************************************/
        //基于Lock写加锁，在原数组的基础上copy一份出来进行添加，要求数据实时性不高，写数据操作复杂性能很低，适用读多写少
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList();
        list.add("aa");
        list.add(0,"zz");
        list.get(1);
        /*************************************/
        //基于ReentrantLock实现同步，其底层数据结构为数组
        ArrayBlockingQueue<String> blockingQueue = new ArrayBlockingQueue(1);
        boolean aa = blockingQueue.offer("aa"); //基于队列大小进行插入，如果已经达到了规定容量，则丢弃
        System.out.println(blockingQueue.poll());//若队列没有数据，直接返回null
        try {
            blockingQueue.put("bb"); //若队列已满，则阻塞
            System.out.println(blockingQueue.take());//若队列没有数据，则阻塞
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
