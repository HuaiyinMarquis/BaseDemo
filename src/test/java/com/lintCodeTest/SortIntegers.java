package com.lintCodeTest;

/**
 * 463. 整数排序
 * Created by ChenMP on 2018/4/10.
 */
public class SortIntegers {
    public static int[] solution(int[] A) {
        if (A.length == 0) return A;
        for (int i=0; i<A.length; i++) {
            for (int n=0; n<A.length-i-1; n++) {
                if (A[n] > A[n+1]) {
                    int temp = A[n+1];
                    A[n+1] = A[n];
                    A[n] = temp;
                }
            }
        }
        return A;
    }

    public static void main(String[] args) {
        int[] A = new int[]{4,2,5,5,6,7,2,1,3,0,9};
        A = solution(A);
        for (int i: A) {
            System.out.print(i + ",");
        }
    }
}
