package com.example.demo.NioTest;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by ChenMP on 2018/3/2.
 */
public class Client {
    private static Selector selector;

    private static void init() {
        try {
            SocketChannel channel = SocketChannel.open();
            // 设置为非阻塞模式，这个方法必须在实际连接之前调用(所以open的时候不能提供服务器地址，否则会自动连接)
            channel.configureBlocking(false);
            selector = Selector.open();

            if (channel.connect(new InetSocketAddress("localhost",8080))) {
                channel.register(selector, SelectionKey.OP_READ);//注册读取事件
                request(channel);
            }else {
                channel.register(selector, SelectionKey.OP_CONNECT);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void listenning() {
        try {
            while (true) {
                int select = selector.select();
                if (0 == select) continue;

                Set<SelectionKey> keys = selector.selectedKeys();
                Iterator<SelectionKey> it = keys.iterator();
                while (it.hasNext()) {
                    SelectionKey key = it.next();
                    it.remove();
                    operation(key);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void operation(SelectionKey key) throws IOException {
        if (key.isConnectable()) {
            SocketChannel channel = (SocketChannel) key.channel();
            if (channel.finishConnect()) {
                channel.register(selector,SelectionKey.OP_READ);
                request(channel);
            } else {
                //链接失败，进程退出
                System.exit(1);
            }
        }
        if (key.isReadable()) {
            SocketChannel channel = (SocketChannel) key.channel();
            ByteBuffer buffer = ByteBuffer.allocate(1024);

            StringBuilder sb = new StringBuilder();
            if (channel.read(buffer) > 0) {
                buffer.flip();
                byte[] bytes = new byte[buffer.remaining()];
                buffer.get(bytes);
                sb.append(new String(bytes));
                buffer.clear();
            }
            System.out.println(sb.toString());
            key.interestOps(SelectionKey.OP_READ);

        }
    }

    private static void request(SocketChannel channel) {
        byte[] req = "你好,Server....".getBytes();
        ByteBuffer buffer = ByteBuffer.allocate(req.length);
        buffer.put(req);

        buffer.flip();
        try {
            channel.write(buffer);
            if (!buffer.hasRemaining()) {
                System.out.println("Send 2 Server Success...");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        init();
        listenning();
    }

}
