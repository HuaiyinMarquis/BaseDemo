package com.sortDemo;

/**
 * 插入排序
 * Created by ChenMP on 2018/4/12.
 */
public class InsertionSort {
    public static int[] solution(int[] array) {
        for (int i=1; i<array.length; i++) {
            int compare = array[i];
            for (int n=i-1; n>=0; n--) {
                if (compare < array[n]) //如果比较元素小于当前元素，当前元素后移
                    array[n+1] = array[n];
                else {//如果比较元素大于或等于当前元素，比较元素放在当前元素后一位，然后中断后续比较
                    array[n+1] = compare;
                    break;
                }
                if (compare < array[n] && n == 0) { //如果比较元素比下标为0的当前元素小，比较元素替换当前元素
                    array[n] = compare;
                }
            }
        }
        return array;
    }

    public static void main(String[] args) {
        for (int i : solution(new int[]{2,3,5,7,1,3,5,7,4})) {
            System.out.print(i + " ");
        }
    }
}
