package com.exampleDemo.NettyDemo;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

/**
 * Handles a server-side channel.
 * (1)、
 *      DiscardServerHandler继承了ChannelInboundHandlerAdapter
 *      ChannelInboundHandlerAdapter实现了ChannelInboundHandler接口，而ChannelInboundHandler接口里面提供了各种处理方法供你实现
 * (2)、我们重写channelRead方法，当从客户端接收到新的数据时，接收到的消息会调用这个方法。这个例子中接收到的消息是ByteBuf类型
 * (3)、为了实现 DISCARD协议，handler必须忽略掉接收到的消息。
 *      ByteBuf 是一个reference-counted object 必须通过调用release()方法显式释放。请记住，释放所有传递到handler的reference-counted
 *      对象是handler的责任。
 * (4)、exceptionCaught() 时间处理方法是在出现netty由于出现I/O错误或者在处理实现中的异常时被调用。大部分情况下，被捕获的异常应该被
 *      记录，其相关的通道也应该在这里关闭。
 *
 */
public class DiscardServerHandler extends ChannelInboundHandlerAdapter { // (1)

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) { // (2)
        // Discard the received data silently.
//        ((ByteBuf) msg).release(); // (3) 在这个例子中适用

        try {
            // Do something with msg
        } finally {
            ReferenceCountUtil.release(msg);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) { // (4)
        // Close the connection when an exception is raised.
        cause.printStackTrace();
        ctx.close();
    }
}