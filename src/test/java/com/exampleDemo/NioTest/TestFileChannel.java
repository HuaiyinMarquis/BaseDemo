package com.exampleDemo.NioTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

/**
 * Created by ChenMP on 2018/3/8.
 */
public class TestFileChannel {
    public static void main(String[] args) throws IOException {
        FileInputStream stream = new FileInputStream("C:\\Users\\ChenMP\\Desktop\\云商页面\\openShopinfoConfirm.jsp");
        FileChannel channel = stream.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(100);
        byte[] bytes = new byte[buffer.remaining()];

        while (channel.read(buffer) != 0) {
            buffer.flip();
            buffer.get(bytes);
            System.out.println(new String(bytes, Charset.forName("ISO-8859-1")));
            buffer.clear();
        }
    }
}
