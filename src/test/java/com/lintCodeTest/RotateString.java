package com.lintCodeTest;

/**
 * 8. 旋转字符串
 *      给定一个字符串和一个偏移量，根据偏移量旋转字符串(从左向右旋转)
 * Created by ChenMP on 2018/4/11.
 */
public class RotateString {
    public static void solution(char[] str, int offset) {
        char[] temp = new char[str.length];
        for (int i=0; i<str.length; i++) {
            if (str.length > (i+offset)) { //下标没有溢出
                temp[i+offset] = str[i];
            } else { //从头排
                temp[(i+offset)%str.length] = str[i];
            }
        }
        for (int i=0; i<str.length; i++) {
            str[i] = temp[i];
        }
    }

    public static void main(String[] args) {
        solution(new char[]{'a','b'},24);
    }
}
