package com.example.demo.JavaVersionTest;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by ChenMP on 2017/10/31.
 */
public class Java8Test {
    /**
     * 1.扩展方法。允许我们给接口添加一个非抽象的方法实现，只需要使用 default关键字即可
     */

    /**
     * 2.Lambda 表达式
     */
    @Test
    public void testLambda() {
//        Arrays.asList("a", "b", "c", "d").forEach(e -> System.out.print(e));
//        Arrays.asList("a", "b", "c", "d").forEach((String e) -> System.out.print(e));
//        Arrays.asList("a", "b", "c", "d" ).forEach( e -> {
//            System.out.print( e );
//            System.out.print( e );
//        } );
//        String separator = ","; //在里面使用默认为final类型，不予许修改
//        Arrays.asList("a", "b", "c", "d" ).forEach(
//                ( String e ) -> {
//                    System.out.print( e + separator );
//                } );
//        Arrays.asList( "a", "b", "c", "d" ).sort( ( e1, e2 ) -> {
//            int result = e1.compareTo( e2 );
//            return result;
//        } );
//
//        List<String> list = Arrays.asList("a", "b", "c", "d");

    }

}
