package com.exampleDemo;

/**
 * 二分查找法的递归和非递归实现 时间复杂度为O(n)
 * 二分查找依赖顺序表结构，针对的是有序数据，数据量太小或太大（数组要求内存空间连续）也不适合
 * 相比较于散列表和二叉树，二分查找法最省内存
 */
public class BSearchDemo {
    public static int recursion(int[] array, int start, int end, int value) { //递归
        if ((end - start) < 1) return array[start]==value?start:-1;
        int middle = (start + end)/2;
        if (array[middle] > value)
            return recursion(array,start,middle-1,value);
        else if (array[middle] < value)
            return recursion(array,middle+1,end,value);
        else if (array[middle] == value)
            return middle;
        return -1;
    }

    public static int nonRecursion(int[] array, int value) { //非递归
        int start = 0, end = array.length-1;
        int middle = (start+end)/2;
        while (array[middle] != value) {
            if (start == end) return -1;
            if (array[middle] > value)
                end = middle-1;
            else if (array[middle] < value)
                start = middle+1;
            middle = (start+end)/2;
        }
        return middle;
    }

    //二分查找算法变体一：查找第一个值等于给定值的元素
    public static int variationOne(int[] array, int value) {
        int start=0, end=array.length-1;
        int middle = (start+end)/2;
        while (start < end) {
            if (array[middle] >= value)
                end = middle;
            else if (array[middle] < value)
                start = middle+1;
            middle = (start+end)/2;
        }
        return array[start]==value?start:-1;
    }

    //二分查找算法变体二：查找最后一个值等于给定值的元素
    public static int variationTwo(int[] array, int value) {
        if (array.length ==1) return array[0]==value?0:-1;
        int start=0, end=array.length-1;
        int middle = (start+end)/2;

        return -1;
    }

    public static void main(String[] args) {
//        int[] array = {0,1,2,3,4,5,6,7,8,9,10};
        int[] array = {0,1,2,3,4,5,8,8,8,8,10};
//        int site = recursion(array, 0, array.length-1, 7);
//        int site = nonRecursion(array,8);
        int site = variationOne(array,10);
        System.out.println(site);
    }
}






