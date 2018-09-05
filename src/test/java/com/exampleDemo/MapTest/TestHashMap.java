package com.exampleDemo.MapTest;


import java.io.IOException;
import java.util.HashMap;

/**
 * Created by ChenMP on 2018/3/27.
 */
public class TestHashMap {
    public static void main(String[] args) throws IOException {
        /**
         * 分析HashMap源码（基于1.8）
         * 一、this.loadFactor = DEFAULT_LOAD_FACTOR = 0.75f; 设置默认加载因子
         * 二、 return putVal(hash(key), key, value, false, true);
         *      V putVal(int hash, K key, V value, boolean onlyIfAbsent,boolean evict)
         *      --n = (tab = resize()).length;
         *          --final Node<K,V>[] resize()
         *
         * 容量 capacity
         * 负载系数 load factor
         * 如果链表大小超过阀值（treeify_threshold）,链表就会被改造成树形结构
         * resize() 两个职责：初始化存储表格和在容量不满足需求的时候进行扩容
         *
         */
        HashMap map = new HashMap();
        System.out.println(map.get(null));
        for (int i=0; i<16; i++) {
            map.put(i,i);
        }

    }
}

/**************************HashMap源码********************************/

//final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
//               boolean evict) {
//    Node<K,V>[] tab; Node<K,V> p; int n, i;
//    if ((tab = table) == null || (n = tab.length) == 0)
//        n = (tab = resize()).length; 初始化table
//    if ((p = tab[i = (n - 1) & hash]) == null)
//        tab[i] = newNode(hash, key, value, null); 如果该节点为空，直接放进去
//    else {
//        Node<K,V> e; K k;
//        if (p.hash == hash &&
//                ((k = p.key) == key || (key != null && key.equals(k))))
//            e = p;
//        else if (p instanceof TreeNode) 如果是TreeNode,直接插入
//            e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
//        else {
//            for (int binCount = 0; ; ++binCount) {
//                if ((e = p.next) == null) {
//                    p.next = newNode(hash, key, value, null);
//                    if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
//                        treeifyBin(tab, hash); 如果该“桶”的长度达到或超过了TREEIFY_THRESHOLD，进行树化改造
//                    break;
//                }
//                if (e.hash == hash &&
//                        ((k = e.key) == key || (key != null && key.equals(k))))
//                    break;
//                p = e;
//            }
//        }
//        if (e != null) { // existing mapping for key
//            V oldValue = e.value;
//            if (!onlyIfAbsent || oldValue == null)
//                e.value = value;
//            afterNodeAccess(e);
//            return oldValue;
//        }
//    }
//    ++modCount;
//    if (++size > threshold)
//        resize();
//    afterNodeInsertion(evict);
//    return null;
//}
    /**
     * Initializes or doubles table size.  If null, allocates in
     * accord with initial capacity target held in field threshold.
     * Otherwise, because we are using power-of-two expansion, the
     * elements from each bin must either stay at same index, or move
     * with a power of two offset in the new table.
     *
     * @return the table
     */
//    final Node<K,V>[] resize() {
//        Node<K,V>[] oldTab = table;
//        int oldCap = (oldTab == null) ? 0 : oldTab.length;
//        int oldThr = threshold;
//        int newCap, newThr = 0;
//        if (oldCap > 0) { table不为空，执行扩容
//            if (oldCap >= MAXIMUM_CAPACITY) {
//                threshold = Integer.MAX_VALUE;
//                return oldTab;
//            }
//            else if ((newCap = oldCap << 1) < MAXIMUM_CAPACITY &&  容量和阀值翻一倍
//                    oldCap >= DEFAULT_INITIAL_CAPACITY)
//                newThr = oldThr << 1; // double threshold
//        }
            //初始化table
//        else if (oldThr > 0) // initial capacity was placed in threshold
//            newCap = oldThr; 利用阀值来当作初始化容量
//        else {               // zero initial threshold signifies using defaults
//            newCap = DEFAULT_INITIAL_CAPACITY; 如果阀值为空则利用默认阀值
//            newThr = (int)(DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY);  阀值=默认负载因子*默认初始化容量
//        }
//        if (newThr == 0) {
//            float ft = (float)newCap * loadFactor;
//            newThr = (newCap < MAXIMUM_CAPACITY && ft < (float)MAXIMUM_CAPACITY ?
//                    (int)ft : Integer.MAX_VALUE);
//        }
//        threshold = newThr;
//        @SuppressWarnings({"rawtypes","unchecked"})
//        Node<K,V>[] newTab = (Node<K,V>[])new Node[newCap]; 组件新的table
//        table = newTab;
//        if (oldTab != null) {
//            for (int j = 0; j < oldCap; ++j) { 遍历旧table数据放入新table
//                Node<K,V> e;
//                if ((e = oldTab[j]) != null) { 获取到旧节点数据
//                    oldTab[j] = null; 将就table相关位置置为空
//                    if (e.next == null) 如果该“桶”没有后续节点，则直接放入新节点
//                        newTab[e.hash & (newCap - 1)] = e;
//                    else if (e instanceof TreeNode) 如果该“桶”有后续节点，
//                        ((TreeNode<K,V>)e).split(this, newTab, j, oldCap);
//                    else { // preserve order
//                        Node<K,V> loHead = null, loTail = null;
//                        Node<K,V> hiHead = null, hiTail = null;
//                        Node<K,V> next;
//                        do {
//                            next = e.next;
//                            if ((e.hash & oldCap) == 0) {
//                                if (loTail == null)
//                                    loHead = e;
//                                else
//                                    loTail.next = e;
//                                loTail = e;
//                            }
//                            else {
//                                if (hiTail == null)
//                                    hiHead = e;
//                                else
//                                    hiTail.next = e;
//                                hiTail = e;
//                            }
//                        } while ((e = next) != null);
//                        if (loTail != null) {
//                            loTail.next = null;
//                            newTab[j] = loHead;
//                        }
//                        if (hiTail != null) {
//                            hiTail.next = null;
//                            newTab[j + oldCap] = hiHead;
//                        }
//                    }
//                }
//            }
//        }
//        return newTab;
//    }
