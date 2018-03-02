package com.example.demo.JavaVersionTest.Lambda_Test;

/**
 * Created by ChenMP on 2017/11/3.
 */
@FunctionalInterface
public interface CheckFileterInterface<T> {

    boolean check(T t);
}
