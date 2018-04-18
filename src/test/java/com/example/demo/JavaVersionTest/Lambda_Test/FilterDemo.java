package com.example.demo.JavaVersionTest.Lambda_Test;

import org.json.JSONObject;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Created by ChenMP on 2017/11/3.
 */
public class FilterDemo {
     List<Person> list = Arrays.asList(
           new Person("张三",10,20),
           new Person("李四",15,30),
            new Person("王五",20,40)

    );

    public  List<Person> checkPerson(CheckFileterInterface checkFileter) {
        List<Person> result = new ArrayList<>();
        for (Person person : list) {
            if (checkFileter.check(person)) {
                result.add(person);
            }
        }
        return result;
    }

    @Test
    public void test() {
        CheckFileterInterface<Person> checkFileter = person -> {
            if (person.getWeight() > 14) {
                return true;
            }
            return false;
        };
        List<Person> result = checkPerson(checkFileter);
        System.out.println(result);
    }

    @Test
    public void test1() { //Stream API
        list.stream().filter((person) -> person.getWeight()>14).forEach(System.out::println);
    }

    @Test
    public void test2() {//方法引用
        Consumer<String> consumer1 = System.out::println; //方法参数和返回值一致
        consumer1.accept("方法引用");

        Person person = new Person("王五", 20, 40);
        Supplier<Integer> supplier = person::getAge;
        System.out.println(supplier.get());

        Comparator<Integer> comparator = Integer::compare;
    }
}
