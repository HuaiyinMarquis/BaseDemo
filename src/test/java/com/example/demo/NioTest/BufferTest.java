package com.example.demo.NioTest;

import java.nio.ByteBuffer;

/**
 * Created by ChenMP on 2018/3/2.
 */
public class BufferTest {
    public static void main(String[] args) {
        byte[] bytes = getStr().getBytes();
        ByteBuffer buffer = ByteBuffer.allocate(100);
        System.out.println(buffer.remaining());

        buffer.put(bytes,0,99);
        buffer.flip();

        StringBuilder sb = new StringBuilder();
        byte[] read = new byte[1024];
        System.out.println(String.valueOf(buffer.get(2)));
        System.out.println(new String(read));
    }

    private static String getStr() {
        return  "public class NioClient {\n" +
                "    // 创建一个套接字通道，注意这里必须使用无参形式\n" +
                "    private Selector selector = null;\n" +
                "    static  Charset charset = Charset.forName(\"UTF-8\");\n" +
                "    private volatile boolean stop = false;\n" +
                "    public  ArrayBlockingQueue<String> arrayQueue = new ArrayBlockingQueue<String>(8);\n" +
                "    public  void  init() throws IOException{\n" +
                "        selector = Selector.open();\n" +
                "        SocketChannel channel = SocketChannel.open();\n" +
                "        // 设置为非阻塞模式，这个方法必须在实际连接之前调用(所以open的时候不能提供服务器地址，否则会自动连接)\n" +
                "        channel.configureBlocking(false);\n" +
                "        if(channel.connect(new InetSocketAddress(\"127.0.0.1\",7777))){\n" +
                "            channel.register(selector, SelectionKey.OP_READ);\n" +
                "           //发送消息\n" +
                "          doWrite(channel, \"66666666\");\n" +
                "        }else {\n" +
                "            channel.register(selector, SelectionKey.OP_CONNECT);\n" +
                "        }\n" +
                "\n" +
                "\n" +
                "        //启动一个接受服务器反馈的线程\n" +
                "      //  new Thread(new ReceiverInfo()).start();\n" +
                "\n" +
                "        while (!stop){\n" +
                "            selector.select(1000);\n" +
                "            Set<SelectionKey> keys = selector.selectedKeys();\n" +
                "            Iterator<SelectionKey> it = keys.iterator();\n" +
                "            SelectionKey key = null;\n" +
                "            while (it.hasNext()){\n" +
                "                key = it.next();\n" +
                "                it.remove();\n" +
                "                SocketChannel sc = (SocketChannel) key.channel();\n" +
                "                // OP_CONNECT 两种情况，链接成功或失败这个方法都会返回true\n" +
                "                if (key.isConnectable()){\n" +
                "                    // 由于非阻塞模式，connect只管发起连接请求，finishConnect()方法会阻塞到链接结束并返回是否成功\n" +
                "                    // 另外还有一个isConnectionPending()返回的是是否处于正在连接状态(还在三次握手中)\n" +
                "                    if (channel.finishConnect()) {\n" +
                "                       /* System.out.println(\"准备发送数据\");\n" +
                "                        // 链接成功了可以做一些自己的处理\n" +
                "                        channel.write(charset.encode(\"I am Coming\"));\n" +
                "                        // 处理完后必须吧OP_CONNECT关注去掉，改为关注OP_READ\n" +
                "                        key.interestOps(SelectionKey.OP_READ);*/\n" +
                "                          sc.register(selector,SelectionKey.OP_READ);\n" +
                "                    //    new Thread(new DoWrite(channel)).start();\n" +
                "                      doWrite(channel, \"66666666\");\n" +
                "                    }else {\n" +
                "                        //链接失败，进程推出\n" +
                "                        System.exit(1);\n" +
                "                    }\n" +
                "                } if(key.isReadable()){\n" +
                "                //读取服务端的响应\n" +
                "                    ByteBuffer buffer = ByteBuffer.allocate(1024);\n" +
                "                     int readBytes = sc.read(buffer);\n" +
                "                    String content = \"\";\n" +
                "                    if (readBytes>0){\n" +
                "                        buffer.flip();\n" +
                "                        byte[] bytes = new byte[buffer.remaining()];\n" +
                "                        buffer.get(bytes);\n" +
                "                        content+=new String(bytes);\n" +
                "                        stop=true;\n" +
                "                    }else if(readBytes<0) {\n" +
                "                        //对端链路关闭\n" +
                "                        key.channel();\n" +
                "                        sc.close();\n" +
                "                    }\n" +
                "                    System.out.println(content);\n" +
                "                    key.interestOps(SelectionKey.OP_READ);\n" +
                "                }\n" +
                "            }\n" +
                "        }\n" +
                "    }\n" +
                "private  void doWrite(SocketChannel sc,String data) throws IOException{\n" +
                "        byte[] req =data.getBytes();\n" +
                "        ByteBuffer byteBuffer = ByteBuffer.allocate(req.length);\n" +
                "        byteBuffer.put(req);\n" +
                "        byteBuffer.flip();\n" +
                "        sc.write(byteBuffer);\n" +
                "        if(!byteBuffer.hasRemaining()){\n" +
                "            System.out.println(\"Send 2 client successed\");\n" +
                "        }\n" +
                "    }\n" +
                "}";
    }
}
