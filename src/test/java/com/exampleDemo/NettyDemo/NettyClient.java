package com.exampleDemo.NettyDemo;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 *(1)、Bootstrap跟ServerBootstrap很像，除了它是非服务器Channel例如客户端或者无连接Channel。
 *(2)、如果你只指定一个EventLoopGroup，它将同时起到了boos线程和worker线程的作用。boss线程将不再用作客户端。
 *(3)、代替NioServerSocketChannel，NioSocketChannel用来创建一个客户端的Channel。
 *(4)、请注意，这里我们不使用childOption（），这与我们对ServerBootstrap的做法不同，因为客户端SocketChannel没有父节点。
 *(5)、我们应该使用connect()方法来代替bind() 方法
 *
 */
public class NettyClient {
    private static String host;
    private static int port;
    public static void main(String[] args) throws Exception {
        if (args.length > 0) {
            host = args[0];
            port = Integer.parseInt(args[1]);
        } else {
            host = "127.0.0.1";
            port = 8080;
        }
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            Bootstrap b = new Bootstrap(); // (1)
            b.group(workerGroup); // (2)
            b.channel(NioSocketChannel.class); // (3)
            b.option(ChannelOption.SO_KEEPALIVE, true); // (4)
            b.handler(new ChannelInitializer<SocketChannel>() {
                @Override
                public void initChannel(SocketChannel ch) throws Exception {
                    ch.pipeline().addLast(new TimeDecoder(), new TimeClientHandler());
                }
            });

            // Start the client.
            ChannelFuture f = b.connect(host, port).sync(); // (5)

            // Wait until the connection is closed.
            f.channel().closeFuture().sync();
        } finally {
            workerGroup.shutdownGracefully();
        }
    }
}
