package com.exampleDemo;

import java.util.ArrayList;
import java.util.Arrays;

public class SortDemo {
    /**
     * 冒泡排序
     * 演示地址：https://mmbiz.qpic.cn/mmbiz_gif/fEsWkVrSk54pze4cQdXwM6ibfGzypdpGhJDtkjEsfeP4U7O4zyrASg7YCxZibE4uiaA705VJnGtafy7ibv8xzZkhXQ/640
     * 最佳情况：T(n) = O(n)   最差情况：T(n) = O(n^2)   平均情况：T(n) = O(n^2)
     * 稳定、原地
     */
    public static int[] bubboSort(int[] array) {
        if (array.length == 0) return array;
        for (int i=array.length; i>=0; i--) {
            boolean flag = false;
            for (int n=0; n<i-1; n++) {
                if (array[n] > array[n+1]) {
                    int tmp = array[n];
                    array[n] = array[n+1];
                    array[n+1] = tmp;
                    flag = true;
                }
            }
            if (!flag) break; //没有数据交换，表示已经完全有序
        }

        return array;
    }

    /**
     * 选择排序
     * 演示地址：https://mmbiz.qpic.cn/mmbiz_gif/fEsWkVrSk54pze4cQdXwM6ibfGzypdpGhWVia3IR3gNaNYr7Opct15gUM3xmetFhMAYpgU1eTsic82dy684DwKElQ/640
     * 最佳情况：T(n) = O(n^2)  最差情况：T(n) = O(n^2)  平均情况：T(n) = O(n^2)
     * 不稳定、原地
     */
    public static int[] selectionSort(int[] array) {
        if (array.length == 0)  return array;
        for (int i=0; i<array.length; i++) {
            int mark = i;
            for (int n=i+1; n<array.length; n++) {
                if (array[mark] > array[n])
                    mark = n;
            }
            int tmp = array[mark];
            array[mark] = array[i];
            array[i] = tmp;
        }
        return array;
    }

    /**
     * 插入排序
     * 演示地址：https://mmbiz.qpic.cn/mmbiz_gif/fEsWkVrSk54pze4cQdXwM6ibfGzypdpGhDfd7N6pJRicTzficNVLHrTL2h67Q6h2B98Gic1fr96y6ntGibbDkj33kiaA/640
     * 最佳情况：T(n) = O(n)   最坏情况：T(n) = O(n^2)   平均情况：T(n) = O(n^2)
     * 稳定、原地
     */
    public static int[] insertionSort(int[] array) {
        if (array.length == 0) return array;
        for (int i=1; i<array.length; i++) {
            int mark = array[i];
            for (int n=i-1; n>=0; n--) {
                if (mark < array[n]) {
                    array[n+1] = array[n];
                    if (n == 0) {
                        array[n] = mark;
                    }
                } else if (mark >= array[n]) {
                    array[n+1] = mark;
                    break;
                }
            }
        }
        return array;
    }

    /**
     * 归并排序
     * 演示地址：https://mmbiz.qpic.cn/mmbiz_gif/fEsWkVrSk54pze4cQdXwM6ibfGzypdpGhxYKgvQDqXLlUSvfPlNBAmlibd9TORFdcHandRCdXYayiaJyibaJA2Wrmw/640
     * 最佳情况：T(n) = O(n)  最差情况：T(n) = O(nlogn)  平均情况：T(n) = O(nlogn)
     * 稳定、非原地排序（空间复杂度为O(n)）
     */
    public static int[] mergeSort(int[] array) {
        if (array.length < 2) return array;
        int middle = array.length/2;
        int[] left = Arrays.copyOfRange(array,0,middle);
        int[] right = Arrays.copyOfRange(array,middle,array.length);

        return merge(mergeSort(left),mergeSort(right));
    }
    //归并排序——将两段排序好的数组结合成一个排序数组
    public static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length+right.length];
        for (int index=0, l=0, r=0; index<result.length; index++) {
            if (l >= left.length) {
                result[index] = right[r++];
            } else if (r >= right.length) {
                result[index] = left[l++];
            } else if (left[l] <= right[r]) {
                result[index] = left[l++];
            } else if (left[l] > right[r]) {
                result[index] = right[r++];
            }
        }
        return result;
    }

    /**
     * 快速排序
     * 演示地址：https://mmbiz.qpic.cn/mmbiz_gif/fEsWkVrSk54pze4cQdXwM6ibfGzypdpGhp2snnFbGJHdBoQ2XLGrMQ9pVSjvOPMc9ibAH1ZhzUxTekcCBuShNuDw/640
     * 最佳情况：T(n) = O(nlogn)   最差情况：T(n) = O(n^2)   平均情况：T(n) = O(nlogn)　
     * 原地排序
     */
    public static int[] quickSort(int[] array, int start, int end) {
        if (array.length < 1 || start < 0 || end >= array.length || start > end) return null;
        int smallIndex = partition(array, start, end);//获取基准点所在位置
        if (smallIndex > start)
            quickSort(array, start, smallIndex - 1);
        if (smallIndex < end)
            quickSort(array, smallIndex + 1, end);
        return array;
    }
    //快速排序算法——partition分区函数
    public static int partition(int[] array, int start, int end) {
        int pivot = (int) (start + Math.random() * (end - start + 1)); //获取基准点
        int smallIndex = start - 1;
        swap(array, pivot, end);
        for (int i = start; i <= end; i++)
            if (array[i] <= array[end]) {
                smallIndex++;
                if (i > smallIndex)
                    swap(array, i, smallIndex);
            }
        return smallIndex;
    }
    //交换数组内两个元素
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * 计数排序
     * 演示地址：https://mmbiz.qpic.cn/mmbiz_gif/fEsWkVrSk54pze4cQdXwM6ibfGzypdpGhplvOJtrbtIBISsZrzsgJ9Gk5ic8hebrrXdFaicurS0ibp6PFr37gnypLw/640
     * 最佳情况：T(n) = O(n+k)  最差情况：T(n) = O(n+k)  平均情况：T(n) = O(n+k)
     * 非比较排序
     */
    public static int[] countingSort(int[] array) {
        if (array.length == 0) return array;
        int bias, min = array[0], max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max)
                max = array[i];
            if (array[i] < min)
                min = array[i];
        }
        bias = 0 - min;
        int[] bucket = new int[max - min + 1];
        Arrays.fill(bucket, 0);
        for (int i = 0; i < array.length; i++) {
            bucket[array[i] + bias]++;
        }
        int index = 0, i = 0;
        while (index < array.length) {
            if (bucket[i] != 0) {
                array[index] = i - bias;
                bucket[i]--;
                index++;
            } else
                i++;
        }
        return array;
    }

    /**
     * 基数排序
     * 演示地址：https://mmbiz.qpic.cn/mmbiz_gif/fEsWkVrSk54pze4cQdXwM6ibfGzypdpGhOhBNCPJibWnC02aicwO2xnIicYws6SS5Ob8AL5bvkFEkFQgFcCia0AIAlw/640
     * 最佳情况：T(n) = O(n * k)   最差情况：T(n) = O(n * k)   平均情况：T(n) = O(n * k)
     * 基数排序有两种方法：MSD 从高位开始进行排序  LSD 从低位开始进行排序
     */
    public static int[] radixSort(int[] array) {
        if (array == null || array.length < 2)
            return array;
        // 1.先算出最大数的位数；
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            max = Math.max(max, array[i]);
        }
        int maxDigit = 0;
        while (max != 0) {
            max /= 10;
            maxDigit++;
        }
        int mod = 10, div = 1;
        ArrayList<ArrayList<Integer>> bucketList = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < 10; i++)
            bucketList.add(new ArrayList<Integer>());
        for (int i = 0; i < maxDigit; i++, mod *= 10, div *= 10) {
            for (int j = 0; j < array.length; j++) {
                int num = (array[j] % mod) / div;
                bucketList.get(num).add(array[j]);
            }
            int index = 0;
            for (int j = 0; j < bucketList.size(); j++) {
                for (int k = 0; k < bucketList.get(j).size(); k++)
                    array[index++] = bucketList.get(j).get(k);
                bucketList.get(j).clear();
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = {3,5,4,0,8,32,21};
//        int[] data = bubboSort(array);
//        int[] data = selectionSort(array);
//        int[] data = insertionSort(array);
//        int[] data = mergeSort(array);
//        int[] data = quickSort(array,0,array.length-1);
        int[] data = countingSort(array);
        Arrays.stream(data).forEach((e) -> System.out.print(e+" "));
    }
}
