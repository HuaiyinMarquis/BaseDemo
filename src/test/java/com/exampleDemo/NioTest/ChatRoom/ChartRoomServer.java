package com.exampleDemo.NioTest.ChatRoom;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by ChenMP on 2018/3/2.
 */
public class ChartRoomServer {
    private Selector selector;

    private void init() {
        try {
            ServerSocketChannel channel = ServerSocketChannel.open();
            channel.bind(new InetSocketAddress("localhost",8080));
            channel.configureBlocking(false);

            selector = Selector.open();
            channel.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println("The Server is Running...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listenning() {
        while (true) {
            try {
                int select = selector.select(1000);
                if (0 == select) continue;

                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> it = selectionKeys.iterator();
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

    private void operation(SelectionKey key) throws IOException {
        if (key.isAcceptable()) {
            ServerSocketChannel channel = (ServerSocketChannel) key.channel();

            SocketChannel accept = channel.accept();
            accept.configureBlocking(false);
            //提示连接进聊天室了
            System.out.println(accept.getRemoteAddress() + "进入了聊天室");
            //TODO 返回客户端信息，提示已经进入聊天室
            feedback(accept,"恭喜您进入了聊天室！！");
            accept.register(selector, SelectionKey.OP_READ);
            key.interestOps(SelectionKey.OP_ACCEPT);
        }
        if (key.isReadable()) {
            SocketChannel channel = (SocketChannel) key.channel();
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            int read = channel.read(buffer);

            StringBuilder sb = new StringBuilder();
            if (read > 0) {
                byte[] bytes = new byte[buffer.remaining()];
                buffer.flip();
                buffer.get(bytes);
                sb.append(new String(bytes));
            }
            System.out.println("Client :"+sb.toString());
            feedback(channel,sb.toString());
            key.interestOps(SelectionKey.OP_READ);
        }
    }

    private void feedback(SocketChannel channel, String data) {
        ByteBuffer buffer = ByteBuffer.allocate(data.length());
//        byte[] bytes = data.getBytes();
//        buffer.put(bytes);
//        buffer.flip();
        ByteBuffer wrap = buffer.wrap(data.getBytes());

        try {
            if (wrap != null) channel.write(buffer);
            else channel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
