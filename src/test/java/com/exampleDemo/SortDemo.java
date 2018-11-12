package com.exampleDemo;

import java.util.Arrays;
import java.util.List;

public class SortDemo {
    /**
     * 冒泡排序
     * 演示地址：https://mmbiz.qpic.cn/mmbiz_gif/fEsWkVrSk54pze4cQdXwM6ibfGzypdpGhJDtkjEsfeP4U7O4zyrASg7YCxZibE4uiaA705VJnGtafy7ibv8xzZkhXQ/640
     * 最佳情况：T(n) = O(n)   最差情况：T(n) = O(n^2)   平均情况：T(n) = O(n^2)
     */
    public static int[] bubboSort(int[] array) {
        if (array.length == 0)
            return array;
        for (int i=array.length; i>=0; i--) {
            for (int n=0; n<i-1; n++) {
                if (array[n] > array[n+1]) {
                    int tmp = array[n];
                    array[n] = array[n+1];
                    array[n+1] = tmp;
                }
            }
        }

        return array;
    }

    /**
     * 选择排序
     * 演示地址：https://mmbiz.qpic.cn/mmbiz_gif/fEsWkVrSk54pze4cQdXwM6ibfGzypdpGhWVia3IR3gNaNYr7Opct15gUM3xmetFhMAYpgU1eTsic82dy684DwKElQ/640
     *
     */
    public static int[] selectionSort(int[] array) {

        return null;
    }

    public static void main(String[] args) {
        int[] array = {3,5,4,0,8,32,21,54,22,45,24,66,1,6};
        int[] data = bubboSort(array);
        Arrays.stream(data).forEach((e) -> System.out.print(e+", "));
    }
}
