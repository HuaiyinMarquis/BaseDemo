package com.sortDemo;

/**
 * 希尔排序
 * Created by ChenMP on 2018/4/13.
 */
public class ShellSort {
    public static int[] solution(int[] array) {
        int len = array.length;
        int temp, gap = len / 2;
        while (gap > 0) {
            for (int i = gap; i < len; i++) {
                temp = array[i];
                int preIndex = i - gap;
                while (preIndex >= 0 && array[preIndex] > temp) {
                    array[preIndex + gap] = array[preIndex];
                    preIndex -= gap;
                }
                array[preIndex + gap] = temp;
            }
            gap /= 2;
        }
        return array;
    }

    public static void main(String[] args) {
        for (int i : solution(new int[]{3,5,7,2,3,5,7,4})) {
            System.out.print(i + " ");
        }
    }
}
