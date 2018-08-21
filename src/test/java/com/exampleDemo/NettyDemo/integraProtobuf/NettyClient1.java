package com.exampleDemo.NettyDemo.integraProtobuf;

import com.exampleDemo.NettyDemo.integraProtobuf.protocoBuf.RequestMsgProtobuf;
import com.exampleDemo.NettyDemo.integraProtobuf.protocoBuf.UserProtobuf;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;
import io.netty.util.AttributeKey;

public class NettyClient1 {
    public static String ATTRIBUTE_KEY = "attribute_key";
    static EventLoopGroup workGroup;
    static Bootstrap b;
    static String ip = "127.0.0.1";
    static int port = 8080;

    static {
        workGroup = new NioEventLoopGroup();

        b = new Bootstrap();
        b.group(workGroup)
                .option(ChannelOption.SO_KEEPALIVE,true)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new ProtobufVarint32FrameDecoder());
                        ch.pipeline().addLast(new ProtobufDecoder(UserProtobuf.User.getDefaultInstance()));//TODO
                        ch.pipeline().addLast(new ProtobufVarint32LengthFieldPrepender());
                        ch.pipeline().addLast(new ProtobufEncoder());
                        ch.pipeline().addLast(new MyClientHandler());
                    }
                });
    }

    public static Object start(RequestMsgProtobuf.RequestMsg.Builder obj) throws Exception {
        ChannelFuture f = b.connect(ip, port).sync();
        f.channel().writeAndFlush(obj);
        f.channel().closeFuture().sync();
        return f.channel().attr(AttributeKey.valueOf(NettyClient1.ATTRIBUTE_KEY)).get();
    }

}
