package com.exampleDemo.GabageCollectionTest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ChenMP on 2017/11/15.
 */
public class HeapOOM {
    static class OOMObject {}

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();

        while (true) {
            list.add(new OOMObject());
        }
    }
}
