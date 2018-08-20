package com.exampleDemo.NettyDemo;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.util.AttributeKey;
import io.netty.util.CharsetUtil;

/**
 *(1)、Bootstrap跟ServerBootstrap很像，除了它是非服务器Channel例如客户端或者无连接Channel。
 *(2)、如果你只指定一个EventLoopGroup，它将同时起到了boos线程和worker线程的作用。boss线程将不再用作客户端。
 *(3)、代替NioServerSocketChannel，NioSocketChannel用来创建一个客户端的Channel。
 *(4)、请注意，这里我们不使用childOption（），这与我们对ServerBootstrap的做法不同，因为客户端SocketChannel没有父节点。
 *(5)、我们应该使用connect()方法来代替bind() 方法
 *
 */
public class NettyClient {
    static String host = "127.0.0.1";
    static int port = 8080;
    public static String ATTRIBUTE_KEY = "attribute_key";
    static EventLoopGroup workerGroup;
    static Bootstrap b;
    static PooledByteBufAllocator allocator = new PooledByteBufAllocator();

    static {
        workerGroup = new NioEventLoopGroup();


        b = new Bootstrap(); // (1)
        b.group(workerGroup); // (2)
        b.channel(NioSocketChannel.class); // (3)
        b.option(ChannelOption.SO_KEEPALIVE, true); // (4)
        b.handler(new ChannelInitializer<SocketChannel>() {
            @Override
            public void initChannel(SocketChannel ch) throws Exception {

                ch.pipeline().addLast(new TimeClientHandler());
//                    ch.pipeline().addLast(new TimeDecoder(), new TimeClientHandler());
            }
        });
    }

    public static Object connect(String request) {
        workerGroup = new NioEventLoopGroup();

        try {
            // Start the client.
            ChannelFuture f = b.connect(host, port).sync(); // (5)
//            f.channel().attr(AttributeKey.valueOf(NettyClient.ATTRIBUTE_KEY)).set(request);
            ByteBuf byteBuf = allocator.buffer().writeBytes(request.getBytes(CharsetUtil.UTF_8));
            f.channel().writeAndFlush(byteBuf);

            // Wait until the connection is closed.
            f.channel().closeFuture().sync();

            return f.channel().attr(AttributeKey.valueOf(NettyClient.ATTRIBUTE_KEY)).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            workerGroup.shutdownGracefully();
        }
        return null;
    }

    public static void main(String[] args) {

        Object result = NettyClient.connect("你好，服务器");
        System.out.println(result);
        workerGroup.shutdownGracefully();
//        for (int i=1; i<=100; i++) {
//            long start = System.currentTimeMillis();
//            Object result = NettyClient.connect("你好，服务器");
//            System.out.println(result);
//            long end = System.currentTimeMillis();
//            System.out.println("第"+i+"次发送请求耗时：" + (end-start) + "MS");
//        }
    }
}
