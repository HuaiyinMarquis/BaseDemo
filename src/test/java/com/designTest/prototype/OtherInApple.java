package com.designTest.prototype;

import java.io.Serializable;

/**
 * Created by ChenMP on 2018/3/23.
 */
public class OtherInApple implements Serializable {
    private String str;

    public OtherInApple(String str) {
        this.str = str;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    @Override
    public String toString() {
        return "OtherInApple{" +
                "str='" + str + '\'' +
                '}';
    }
}
