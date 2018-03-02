package com.example.demo.JavaVersionTest.Lambda_Test;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ChenMP on 2017/11/3.
 */
public class FilterDemo {
    static List<Person> list = Arrays.asList(
           new Person("张三",10),
           new Person("李四",15),
            new Person("王五",20)

    );

    public static void main(String[] args) {
        checkPerson(new CheckFileterInterface<Person>() {
            @Override
            public boolean check(Person person) {
                if (person.getWeight() > 14)
                    return true;
                return false;
            }
        });
        System.out.println(list);
    }

    public static void checkPerson(CheckFileterInterface checkFileter) {
        for (Person person : list) {
            if (!checkFileter.check(person)) {

            }
        }

    }
}
