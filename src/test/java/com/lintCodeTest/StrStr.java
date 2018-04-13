package com.lintCodeTest;

/**
 * 13. 字符串查找
 *      对于一个给定的 source 字符串和一个 target 字符串，你应该在 source 字符串中找出 target 字符串出现的第一个位置(从0开始)。如果不存在，则返回 -1。
 * Created by ChenMP on 2018/4/11.
 */
public class StrStr {
    public static int solution(String source, String target) {
        if (target==null) return -1;
        if (target.length()==0) return 0;
        if (source==null || source.length()==0) return -1;
        char[] sourceChars = source.toCharArray();
        char[] targetChars = target.toCharArray();
        for (int i=0; i<sourceChars.length; i++) {
            if (sourceChars[i] == targetChars[0]) {
                for (int offsize=0; offsize<targetChars.length; offsize++) {
                    if (i+offsize >= sourceChars.length) break;
                    if (sourceChars[i+offsize] != targetChars[offsize]) break;
                    if (targetChars.length-offsize == 1) return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        solution("source", "rced");
    }
}
