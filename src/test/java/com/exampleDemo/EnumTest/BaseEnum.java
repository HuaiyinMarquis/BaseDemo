package com.exampleDemo.EnumTest;

/**
 * Created by ChenMP on 2018/3/19.
 */
public enum BaseEnum {
    ONE(1),TWO(2),THREE(3);

    private Integer num;

    BaseEnum(Integer num) {
        this.num = num;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
