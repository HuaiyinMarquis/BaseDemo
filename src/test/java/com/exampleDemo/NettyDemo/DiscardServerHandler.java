package com.exampleDemo.NettyDemo;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;
import io.netty.util.ReferenceCountUtil;

/**
 * Handles a server-side channel.
 *(1)、
 *      DiscardServerHandler继承了ChannelInboundHandlerAdapter
 *      ChannelInboundHandlerAdapter实现了ChannelInboundHandler接口，而ChannelInboundHandler接口里面提供了各种处理方法供你实现
 *(2)、我们重写channelRead方法，当从客户端接收到新的数据时，接收到的消息会调用这个方法。这个例子中接收到的消息是ByteBuf类型
 *(3)、为了实现 DISCARD协议，handler必须忽略掉接收到的消息。
 *      ByteBuf 是一个reference-counted object 必须通过调用release()方法显式释放。请记住，释放所有传递到handler的reference-counted
 *      对象是handler的责任。
 *(4)、exceptionCaught() 时间处理方法是在出现netty由于出现I/O错误或者在处理实现中的异常时被调用。大部分情况下，被捕获的异常应该被
 *      记录，其相关的通道也应该在这里关闭。
 *(5)、这是一个低效率的循环，我们可以简化为：
 *      System.out.println(in.toString(io.netty.util.CharsetUtil.UTF_8));
 *(6)、这里我们也可以在这里直接写in.release()
 *(7)、ChannelHandlerContext提供了各种各样的操作能够支持你触发各种各样的I/O事件和操作。在这里，我们逐字的写出接收到的消息。
 *      请注意，在这里我们没有release接收到的消息，这里跟之前DISCARD Server的例子不一样。这是因为Netty在给你写的时候会把它释放给你。
 *(8)、ctx.write(Object)不会将消息直接写出去。这是由于内部缓冲，需要调用ctx.flush()刷新出去。
 *      或者你可以简洁的使用ctx.writeAndFlush(msg) 来完成这一段操作。
 *
 *
 */
public class DiscardServerHandler extends ChannelInboundHandlerAdapter { // (1)

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) { // (2)
/*--------------------------Writing a Discard Server------------------------------------*/
        // Discard the received data silently.
//        ((ByteBuf) msg).release(); // (3) 在这个例子中适用
/*--------------------------Looking into the Received Data------------------------------------*/
//        ByteBuf in = (ByteBuf) msg;
//        try {
//            // Do something with msg
////            while (in.isReadable()) { // (5)
////                System.out.print((char) in.readByte());
////                System.out.flush();
////            }
//            System.out.println(in.toString(CharsetUtil.UTF_8));
//        } finally {
//            ReferenceCountUtil.release(msg);// (6)
//        }
/*----------------------------Writing an Echo Server----------------------------------*/
            ctx.write(msg); // (7)
            ctx.flush(); // (8)
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) { // (4)
        // Close the connection when an exception is raised.
        cause.printStackTrace();
        ctx.close();
    }
}