package com.exampleDemo.NettyDemo;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * Discards any incoming data.
 *(1)、EventLoopGroup是一个循环多线程处理I/O操作的处理器，Netty提供了各种各样的NioEventLoopGroup实现来处理各种各样的传输。
 *      在服务端应用当中，需要创建两个NioEventLoopGroup来使用。
 *      第一个我们称之为“boss”。用于接收传入的连接。
 *      第二个我们称之为“worker”。一旦boss线程接收了连接并且将已接收的连接注册到worker，worker就会来处理。
 *      有多少线程被使用，以及它们如何映射到创建的Channel取决于EventLoopGroup实现，甚至可以通过构造函数进行配置。
 *(2)、ServerBootstrap是配置服务器的助手类
 *(3)、这里我们指定用NioServerSocketChannel用来实例化一个新的Channel来接收传入的连接
 *(4)、handler指定这里始终由一个新接收的Channel进行评估（？）。ChannelInitializer是一个特殊的handler用来帮助用户配置一个新的
 *      Channel。
 *      你很有可能希望为新的Channel配置ChannelPipeline增加一些处理器比如说DiscardServerHandler 来实现你的网络应用。
 *      当一个应用变得复杂时，你很有可能为pipeline增加更多的处理器，最终将这个匿名类提取到顶级类中。
 *(5)、您还可以设置特定于通道实现的参数。
 *      请参考ChannelOption的文档说明和特定的ChannelConfig实现获得关于受支持的ChannelOptions的概述。
 *(6)、
 *
 */
public class DiscardServer {
    private int port;

    public DiscardServer(int port) {
        this.port = port;
    }

    public void run() throws Exception {
        EventLoopGroup bossGroup = new NioEventLoopGroup(); // (1)
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap(); // (2)
            b.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class) // (3)
                    .childHandler(new ChannelInitializer<SocketChannel>() { // (4)配置
                        @Override
                        public void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new DiscardServerHandler());
                        }
                    })
                    .option(ChannelOption.SO_BACKLOG, 128)          // (5)
                    .childOption(ChannelOption.SO_KEEPALIVE, true); // (6)

            // Bind and start to accept incoming connections.
            ChannelFuture f = b.bind(port).sync(); // (7)

            // Wait until the server socket is closed.
            // In this example, this does not happen, but you can do that to gracefully
            // shut down your server.
            f.channel().closeFuture().sync();
        } finally {
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws Exception {
        int port;
        if (args.length > 0) {
            port = Integer.parseInt(args[0]);
        } else {
            port = 8080;
        }
        new DiscardServer(port).run();
    }
}
