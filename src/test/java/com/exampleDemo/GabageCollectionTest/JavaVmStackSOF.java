package com.exampleDemo.GabageCollectionTest;

/**
 * Created by ChenMP on 2017/12/1.
 */
public class JavaVmStackSOF {
    private int stackLength = 1;

    public void stackLeak() {
        this.stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        JavaVmStackSOF javaVmStackSOF = new JavaVmStackSOF();
        try {
            javaVmStackSOF.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length:" + javaVmStackSOF.stackLength);
            throw e;
        }
    }
}
