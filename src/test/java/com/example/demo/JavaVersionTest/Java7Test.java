package com.example.demo.JavaVersionTest;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by ChenMP on 2017/10/31.
 */
public class Java7Test {
    /**
     * 1.switch可以接受string类型
     */

    /**
     * 2.异常catch可以一次处理完而不像以前一层层的surround
     */
//    try {
//
//        methodThatThrowsThreeExceptions();
//
//    } catch (ExceptionOne | ExceptionTwo | ExceptionThree e) {
//
//    }

    /**
     * 3.泛型类实例化也不用繁琐的将泛型声明再写一遍
     */
//    Map<String, List<Trade>> trades = new TreeMap <> ();

    /**
     * 4.文件读写 会自动关闭流而不像以前那样需要在finally中显式close
     */
//    try (FileOutputStream fos = new FileOutputStream("movies.txt");
//      DataOutputStream dos = new DataOutputStream(fos)) {
//      dos.writeUTF("Java 7 Block Buster");
//    } catch (IOException e) {
//
//    }

    /**
     * 5.数值可以使用下划线分隔；
     */
    @Test
    public void TestInt() {
        int i = 1_00_000;
        System.out.println(i);
    }

    /**
     * 6.文件读写功能增强，有更简单的api调用
     */
    @Test
    public void testPathInfo() {
        Path path = Paths.get("C:\\Users\\ChenMP\\Desktop\\a.txt");
        System.out.println("Number of Nodes:" + path.getNameCount());
        System.out.println("File Name:" + path.getFileName());
        System.out.println("File Root:" + path.getRoot());
        System.out.println("File Parent:" + path.getParent());

        try {
            Files.deleteIfExists(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 7.文件改变的事件通知功能
     */

    /**
     * 8.多核 并行计算的支持加强 fork join 框架
     */




}
