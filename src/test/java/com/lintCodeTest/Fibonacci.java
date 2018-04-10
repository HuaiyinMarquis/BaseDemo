package com.lintCodeTest;

/**
 * 366. 斐波纳契数列
 * Created by ChenMP on 2018/4/10.
 */
public class Fibonacci {
    public static int solution(int n) {
        int before = 1; //-1
        int result = 0;
        int temp = 0;
        if (2 == n) result = 1;
        if (2 < n){
            for (int i=2; i<=n; i++) { // 3 2
                temp = result;  // 1
                result = before + result; // 1
                before = temp; // 1
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(solution(1));
        System.out.println(solution(2));
        System.out.println(solution(3));
        System.out.println(solution(4));
        System.out.println(solution(5));
        System.out.println(solution(6));
        System.out.println(solution(7));
    }
}
