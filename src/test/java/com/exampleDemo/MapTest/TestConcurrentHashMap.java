package com.exampleDemo.MapTest;

import java.util.concurrent.ConcurrentHashMap;

public class TestConcurrentHashMap {
    public static void main(String[] args) {
        /**
         * 分析ConcurrentHashMap源码（基于1.8）
         *  初始化数据table发生在第一次put方法里面，实现了懒加载
         *  初始化的时候利用sizeCtl进行互斥的操作，利用CAS的方式更改数据状态
         *  更加细粒度的对“桶级别”进行互斥的锁操作
         *  在put操作的最后会加入更新size的逻辑操作
         */
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        map.put("k1","v1");
        map.get("k1");
        map.size();
    }
}
/**************************ConcurrentHashMap源码********************************/
//final V putVal(K key, V value, boolean onlyIfAbsent) {
//    if (key == null || value == null) throw new NullPointerException();
//    int hash = spread(key.hashCode());
//    int binCount = 0;
//    for (Node<K,V>[] tab = table;;) {
//        Node<K,V> f; int n, i, fh;
//        if (tab == null || (n = tab.length) == 0) 如果table为空，则初始化table，长度默认为14
//            tab = initTable();
//        else if ((f = tabAt(tab, i = (n - 1) & hash)) == null) {
//            if (casTabAt(tab, i, null,
//                    new Node<K,V>(hash, key, value, null))) 如果该插入Key路由到一个“空桶”上，利用CAS直接插入，不用锁
//                break;                   // no lock when adding to empty bin
//        }
//        else if ((fh = f.hash) == MOVED)
//            tab = helpTransfer(tab, f);
//        else {
//            V oldVal = null;
//            synchronized (f) { 细粒度的加锁操作，针对“桶”级操作
//                if (tabAt(tab, i) == f) {
//                    if (fh >= 0) {
//                        binCount = 1;
//                        for (Node<K,V> e = f;; ++binCount) {
//                            K ek;
//                            if (e.hash == hash &&
//                                    ((ek = e.key) == key ||
//                                            (ek != null && key.equals(ek)))) {
//                                oldVal = e.val;
//                                if (!onlyIfAbsent)
//                                    e.val = value;
//                                break;
//                            }
//                            Node<K,V> pred = e;
//                            if ((e = e.next) == null) {
//                                pred.next = new Node<K,V>(hash, key,
//                                        value, null);
//                                break;
//                            }
//                        }
//                    }
//                    else if (f instanceof TreeBin) {
//                        Node<K,V> p;
//                        binCount = 2;
//                        if ((p = ((TreeBin<K,V>)f).putTreeVal(hash, key,
//                                value)) != null) {
//                            oldVal = p.val;
//                            if (!onlyIfAbsent)
//                                p.val = value;
//                        }
//                    }
//                }
//            }
//            if (binCount != 0) {
//                if (binCount >= TREEIFY_THRESHOLD) 当“桶”的长度超过了阀值，变进行树化
//                    treeifyBin(tab, i);
//                if (oldVal != null)
//                    return oldVal;
//                break;
//            }
//        }
//    }
//    addCount(1L, binCount); 加入统计size
//    return null;
//}