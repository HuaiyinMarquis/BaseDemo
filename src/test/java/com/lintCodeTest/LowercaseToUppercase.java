package com.lintCodeTest;

/**
 * 145. 大小写转换
 * Created by ChenMP on 2018/4/10.
 */
public class LowercaseToUppercase {
    public static char solution(char character) {
        String str = String.valueOf(character).toUpperCase();
        return str.charAt(0);
    }

    public static void main(String[] args) {
        System.out.println(solution('a'));
    }
}
