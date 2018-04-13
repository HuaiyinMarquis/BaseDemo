package com.lintCodeTest;

import java.util.ArrayList;
import java.util.List;

/**
 * 9. Fizz Buzz 问题
 *       从 1 到 n 按照下面的规则打印每个数：
 *          如果这个数被3整除，打印fizz.
 *          如果这个数被5整除，打印buzz.
 *          如果这个数能同时被3和5整除，打印fizz buzz.
 * Created by ChenMP on 2018/4/11.
 */
public class FizzBuzz {
    public static List<String> solution(int n) {
        List<String> list = new ArrayList<>();
        for (int i=1; i<=n; i++) {
            if (i%3==0 && i%5==0) {
                list.add("fizz buzz");
            } else if (i%3==0) {
                list.add("fizz");
            } else if (i%5==0) {
                list.add("buzz");
            } else
                list.add(String.valueOf(i));
        }
        return list;
    }
}
