package com.lintCodeTest;

/**
 * 2. 尾部的零
 *  设计一个算法，计算出n阶乘中尾部零的个数
 * Created by ChenMP on 2018/4/10.
 */
public class TrailingZeros {
    public static long solution(long n) {
        /**
         * 最原始的做法
         */
//        java.math.BigDecimal result = new java.math.BigDecimal(1);
//        for(long i=1; i<=126; i++){
//            result = result.multiply(new java.math.BigDecimal(i));
//        }
//        System.out.println(result);
//        char[] chars = result.toString().toCharArray();
//        long size = 0;
//        for(int i=(chars.length-1); i>=0; i--) {
//            if(chars[i] == '0') {
//                size++;
//            } else
//                break;
//        }
        /**
         * 思路一：以一个5为单位。每个5是一个0
         *      效率不高，被淘汰
         */
        long count = 0;
//        for (long l=5; l<=n; l+=5) {
//            long temp = l;
//            while (temp%5 == 0) {
//                count++;
//                temp = temp/5;
//            }
//        }
        /**
         * 思路二：5的倍数+25的倍数+125的倍数
         */
        long temp = 5;
        while(n > temp) {
            count += n/temp;
            temp *= 5;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(solution(101));
    }
}
