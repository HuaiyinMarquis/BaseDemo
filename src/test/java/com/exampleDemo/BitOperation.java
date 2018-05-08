package com.exampleDemo;

/**
 * Created by ChenMP on 2018/4/10.
 */
public class BitOperation {
    public static void main(String[] args) {
        /**
         * 12   1100
         * 5    0101
         * 正数的原码和反码和补码都一致；负数的原码是正数的符号位取反；负数的反码是原码的非符号位取反；负数的补码是反码加1。
         * ㈤ 小技巧
         *　　⑴ 乘法除法：n * 2 等价于 n << 1； n * 5 等价于 n << 2 + 1； n / 2 等价于 n >> 1。
         *　　备注：JVM执行时会自动转化，大部分其它高级语言的编译器会做类似优化转换，所以除非有特殊的理由，否则别这么写。
         *　　⑵ 取低位：n & 0x0000FFFF；取高位：n & 0xFFFF0000。
         *　　⑶ 奇偶判断：n & 1，等于0为偶，等于1为奇。
         *　　⑷ 正负判断：(n >>> 31) & 1，等于0为正，等于1为负。
         *　　⑸ 取余：n % m ，如m为2的幂次方，可用(n & (m - 1))替代。
         *
         */
        System.out.println(12 & 5); //位与
        System.out.println(12 | 5); //位或
        System.out.println(12 ^ 5); //异或
        System.out.println(~5); //取反
        System.out.println(12 << 2); //左移
        System.out.println(12 >> 2); //右移
    }
}
