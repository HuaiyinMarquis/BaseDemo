package com.sortDemo;

/**
 * 冒泡排序
 * Created by ChenMP on 2018/4/12.
 */
public class DubbleSort {
    public static int[] solution(int[] array) {
        for (int i=0; i<array.length; i++) {
            for (int n=0; n<array.length-1-i; n++) {
                if (array[n] > array[n+1]) {
                    int temp = array[n+1];
                    array[n+1] = array[n];
                    array[n] = temp;
                }
            }
        }
        return array;
    }

    public static void main(String[] args) {
        for (int i : solution(new int[]{3,5,7,2,3,5,7,4})) {
            System.out.print(i + " ");
        }
    }
}
