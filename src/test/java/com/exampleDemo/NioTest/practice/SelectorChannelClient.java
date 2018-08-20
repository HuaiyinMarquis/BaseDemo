package com.exampleDemo.NioTest.practice;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

public class SelectorChannelClient {
    public static void main(String[] args) {
        SocketChannel socketChannel = null;
        try {
            socketChannel = SocketChannel.open();
            socketChannel.connect(new InetSocketAddress(8888));
            Selector selector = Selector.open();
            socketChannel.configureBlocking(false);
            socketChannel.register(selector,SelectionKey.OP_READ);

            ByteBuffer writeByteBuffer = ByteBuffer.wrap("Hey! Are You OK?".getBytes("UTF-8"));
            socketChannel.write(writeByteBuffer);

            if (selector.select() > 0) {
                for (SelectionKey key : selector.selectedKeys()) {
                    if (key.isReadable()) {
                        SocketChannel channel = (SocketChannel) key.channel();
                        ByteBuffer readByteBuffer = ByteBuffer.allocate(1024);
                        int read = channel.read(readByteBuffer);

                        while (read > 0) {
                            readByteBuffer.flip();
                            Charset charset = Charset.forName("UTF-8");
                            System.out.println(charset.newDecoder().decode(readByteBuffer).toString());

                            read = channel.read(readByteBuffer);
                        }
                        readByteBuffer.clear();
                    }
                    selector.selectedKeys().remove(key);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
