package com.exampleDemo.NioTest.practice;

import com.exampleDemo.NioTest.BufferTest;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;

public class ChannelClient {
    public static void main(String[] args) {
        try {
            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.connect(new InetSocketAddress(8888));

            ByteBuffer writeByteBuffer = ByteBuffer.wrap("Hey! Are you Ok?".getBytes("UTF-8"));
//            ByteBuffer writeByteBuffer = ByteBuffer.wrap("".getBytes("UTF-8"));
//            ByteBuffer writeByteBuffer = ByteBuffer.wrap(BufferTest.getStr().getBytes("UTF-8"));
            socketChannel.write(writeByteBuffer);

            TimeUnit.SECONDS.sleep(2);
            ByteBuffer readByteBuffer = ByteBuffer.allocate(1024);
            int read = socketChannel.read(readByteBuffer);
            while (read > 0) {
                readByteBuffer.flip();
                Charset charset = Charset.forName("UTF-8");
                System.out.println(charset.newDecoder().decode(readByteBuffer).toString());

                readByteBuffer.clear();
                read = socketChannel.read(readByteBuffer);
            }
            socketChannel.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
