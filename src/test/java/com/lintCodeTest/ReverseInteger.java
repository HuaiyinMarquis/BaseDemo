package com.lintCodeTest;

/**
 * 37. 反转一个3位整数
 * Created by ChenMP on 2018/4/10.
 */
public class ReverseInteger {
    public static int solution(int number) {
        String str = String.valueOf(number);
        char one = str.charAt(0);
        char two = str.charAt(1);
        char three = str.charAt(2);
        return Integer.valueOf(String.valueOf(three)+String.valueOf(two)+String.valueOf(one));
    }

    public static void main(String[] args) {
        System.out.println(solution(123));
    }
}
