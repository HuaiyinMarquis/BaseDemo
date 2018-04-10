package com.lintCodeTest;


/**
 * 1. A + B 问题
 * Created by ChenMP on 2018/4/10.
 */
public class Aplusb {
    public static int solution(int a, int b) {
        //理论上来说两个相加的值就是他们的和
        int temp1 = a ^ b; //取出异或值
        int temp2 = (a & b) << 1; //取出位与值*2
        int temp3;
        int temp4;

        while((temp1 & temp2) != 0) {
            temp3 = temp1;
            temp4 = temp2;
            temp1 = temp3 ^ temp4;
            temp2 = (temp3 & temp4) << 1;
        }
        return temp1 ^ temp2;
    }

    public static void main(String[] args) {
        /**
         * 5 101
         * 2 10
         */
        System.out.println(solution(12,5));
    }
}
