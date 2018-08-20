package com.exampleDemo.NioTest.practice;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;

public class SelectorChannelServer {
    public static void main(String[] args) {
        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress(8888));
            serverSocketChannel.configureBlocking(false);

            Selector selector = Selector.open();
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

            while (true) {
                if (selector.select() > 0) {
                    for (SelectionKey key : selector.selectedKeys()) {
                        if (key.isAcceptable()) {
                            ServerSocketChannel channel = (ServerSocketChannel) key.channel();
                            SocketChannel socketChannel = channel.accept();
                            ByteBuffer readByteBuffer = ByteBuffer.allocate(1024);
                            int read = socketChannel.read(readByteBuffer);

                            while (read > 0) {
                                readByteBuffer.flip();
                                Charset charset = Charset.forName("UTF-8");
                                System.out.println(charset.newDecoder().decode(readByteBuffer).toString());

                                read = socketChannel.read(readByteBuffer);
                            }
                            readByteBuffer.clear();

                            ByteBuffer writeByteBuffer = ByteBuffer.wrap("I am fine! Thank You!".getBytes("UTF-8"));
                            socketChannel.write(writeByteBuffer);

                            writeByteBuffer.clear();
                            socketChannel.close();
                        }

                        selector.selectedKeys().remove(key);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
