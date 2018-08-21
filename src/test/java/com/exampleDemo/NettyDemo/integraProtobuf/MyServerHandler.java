package com.exampleDemo.NettyDemo.integraProtobuf;


import com.exampleDemo.NettyDemo.integraProtobuf.protocoBuf.RequestMsgProtobuf.RequestMsg;
import com.exampleDemo.NettyDemo.integraProtobuf.protocoBuf.UserProtobuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class MyServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        RequestMsg requestMsg = (RequestMsg) msg;
        System.out.println("cmd = " + requestMsg.getCmd());
        UserProtobuf.User user = UserProtobuf.User.parseFrom(requestMsg.getRequestParam());
        System.out.println(user.getName());

        ctx.channel().writeAndFlush(user);
    }
}
