package com.exampleDemo.NioTest;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

public class ReadFileTest {
    public static void main(String[] args) {
        String fileAddr = "a";
        try {
            RandomAccessFile file = new RandomAccessFile(fileAddr,"rw");
            FileChannel channel = file.getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(3);
            int read = channel.read(byteBuffer);

            while (read > 0) {
                byteBuffer.flip();
                Charset charset = Charset.forName("UTF-8");
                System.out.print(charset.newDecoder().decode(byteBuffer).toString());

                byteBuffer.clear();
                read = channel.read(byteBuffer);
            }

            channel.close();
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
