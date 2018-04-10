package com.lintCodeTest;

/**
 * 6. 合并排序数组 II
 *  给出A=[1,2,3,4]，B=[2,4,5,6]，返回 [1,2,2,3,4,4,5,6]
 * Created by ChenMP on 2018/4/10.
 */
public class MergeSortedArray {
    public static int[] solution(int[] A, int[] B) {
        int[] temp = new int[A.length+B.length];
        int sign = 0;
        int position = 0;
        boolean aFlag = false; //A数组copy完了
        boolean bFlag = false; //B数组copy完了
        for (int i=0; i<A.length; i++) {
            for (int n=sign; n<B.length; n++) {
                if (A[i] >= B[n] || aFlag) {
                    temp[position] = B[n];
                    position++;
                    if (B.length-n <= 1 && !aFlag) { //说明B数组已经copy完毕
                        bFlag = true;
                        n++;
                        sign = n;
                        break;
                    }
                } else {
                    temp[position] = A[i];
                    position++;
                    sign = n;
                    if (A.length-i == 1) { //说明A数组已经copy完毕,执行B
                        temp[position] = B[n];
                        position++;
                        aFlag = true;
                        continue;
                    }
                    break;
                }
            }
            if (bFlag) {
                temp[position] = A[i];
                position++;
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        for(int i : solution(new int[]{1,5},new int[]{2,3})) {
            System.out.print(i + ",");
        }
    }
}
