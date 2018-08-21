package com.exampleDemo.NettyDemo.integraProtobuf;

import com.exampleDemo.NettyDemo.integraProtobuf.protocoBuf.UserProtobuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.AttributeKey;

public class MyClientHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        UserProtobuf.User user = (UserProtobuf.User) msg;
        ctx.channel().attr(AttributeKey.valueOf(NettyClient1.ATTRIBUTE_KEY)).set(user);
        ctx.channel().close();
    }
}
