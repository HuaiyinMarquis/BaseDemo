package com.example.demo.NioTest;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by ChenMP on 2018/3/2.
 */
public class Server {
    private static Selector selector;

    private static void init() {
        try {
            ServerSocketChannel serverSocket = ServerSocketChannel.open();
            serverSocket.bind(new InetSocketAddress("localhost",8080));
            serverSocket.configureBlocking(false);//设置为非阻塞模式

            selector = Selector.open();
            serverSocket.register(selector, SelectionKey.OP_ACCEPT);

            System.out.println("The Server is Running...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void listenning() {
        while (true) {
            try {
                int select = selector.select(1000);
                if (0 == select) continue;

                Set<SelectionKey> keys = selector.selectedKeys();
                Iterator<SelectionKey> it = keys.iterator();
                while (it.hasNext()) {
                    SelectionKey key = it.next();
                    it.remove();

                    operation(key);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void operation(SelectionKey key) {
        if (key.isAcceptable()) {
            try {
                ServerSocketChannel ssc  = (ServerSocketChannel) key.channel();
                // 得到与客户端的套接字通道
                SocketChannel channel = ssc.accept();
                channel.configureBlocking(false);
                channel.register(selector,SelectionKey.OP_READ);
                //将key对应Channel设置为准备接受其他请求
                key.interestOps(SelectionKey.OP_ACCEPT);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (key.isReadable()) {
            try {
                SocketChannel channel = (SocketChannel) key.channel();
                ByteBuffer buffer = ByteBuffer.allocate(1024);

                StringBuilder sb = new StringBuilder();
                int read = channel.read(buffer);
                if (read > 0) {
                    buffer.flip();
                    byte[] bytes = new byte[buffer.remaining()];
                    buffer.get(bytes);
                    sb.append(new String(bytes));
                }
                System.out.println("Client :"+sb.toString());

                response(channel);
                // 写完就把状态关注去掉，否则会一直触发写事件(改变自身关注事件)
                key.interestOps(SelectionKey.OP_READ);
            } catch (IOException e) {
                //如果捕获到该SelectionKey对应的Channel时出现了异常,即表明该Channel对于的Client出现了问题
                //所以从Selector中取消该SelectionKey的注册
                key.cancel();
                if (key.channel() != null) {
                    try {
                        key.channel().close();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        }
    }

    private static void response(SocketChannel channel) {
        try {
            byte[] resp = "服务器已接收...".getBytes();
            ByteBuffer buffer = ByteBuffer.allocate(resp.length);
            buffer.put(resp);
            buffer.flip();
            channel.write(buffer);
            if (!buffer.hasRemaining()) {
                System.out.println("Send 2 Client Success");
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