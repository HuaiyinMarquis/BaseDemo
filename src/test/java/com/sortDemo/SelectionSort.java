package com.sortDemo;

/**
 * 选择排序
 * Created by ChenMP on 2018/4/12.
 */
public class SelectionSort {
    public static int[] solution(int[] array) {
        for (int i=0; i<array.length; i++) {
            int minIndex  = i;
            for (int n=i; n<array.length; n++) {
                if (array[minIndex ] > array[n])
                    minIndex  = n;
            }
            int temp = array[minIndex ];
            array[minIndex ] = array[i];
            array[i] = temp;
        }
        return array;
    }

    public static void main(String[] args) {
        for (int i : solution(new int[]{3,5,7,2,3,5,7,4})) {
            System.out.print(i + " ");
        }
    }
}
