package com.exampleDemo.NioTest.practice;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

public class ChannelServer {

    public static void main(String[] args) {
        ServerSocketChannel serverSocketChannel = null;
        try {
            serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress(8888));

            while (true) {
                SocketChannel socketChannel = serverSocketChannel.accept();
                if (socketChannel != null) {
                    ByteBuffer readbyteBuffer = ByteBuffer.allocate(1024);
                    int read = socketChannel.read(readbyteBuffer);

                    while (read > 0) {
                        readbyteBuffer.flip();
                        Charset charset = Charset.forName("UTF-8");
                        System.out.println(charset.newDecoder().decode(readbyteBuffer).toString());

//                        readbyteBuffer.clear();//1.TODO  程序卡死
                        read = socketChannel.read(readbyteBuffer);
                    }
                    readbyteBuffer.clear();//2.

                    ByteBuffer writeByteBuffer = ByteBuffer.wrap("I am fine! Thank You!".getBytes("UTF-8"));
                    int write = socketChannel.write(writeByteBuffer);

                    socketChannel.close();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                serverSocketChannel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
