package com.exampleDemo.NettyDemo;

import com.exampleDemo.NettyDemo.pojo.UnixTime;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.Date;

/**
 *(1)、在TCP/IP协议中，Netty从相同层级发送封装的ByteBuf获取数据
 *(2)、一个 ChannelHandler有两个生命周期监听方法：handlerAdded() 和 handlerRemoved()
 *      在这里你可以执行任何的初始化任务只要不阻塞太长时间。
 *(3)、将所有接收到的数据放入buf
 *(4)、处理程序必须检查buf 是否有足够的数据，然后执行业务处理
 *
 *
 */
public class TimeClientHandler extends ChannelInboundHandlerAdapter {
/*----------------------------The First Solution----------------------------------*/
//    private ByteBuf buf;
//
//    @Override
//    public void handlerAdded(ChannelHandlerContext ctx) {
//        buf = ctx.alloc().buffer(4); // (2)
//    }
//
//    @Override
//    public void handlerRemoved(ChannelHandlerContext ctx) {
//        buf.release(); // (2)
//        buf = null;
//    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
/*----------------------------Writing a Time Client----------------------------------*/
//        ByteBuf m = (ByteBuf) msg; // (1)
//        try {
//            long currentTimeMillis = (m.readUnsignedInt() - 2208988800L) * 1000L;
//            System.out.println(new Date(currentTimeMillis));
//            ctx.close();
//        } finally {
//            m.release();
//        }
/*----------------------------The First Solution----------------------------------*/
//        ByteBuf m = (ByteBuf) msg;
//        buf.writeBytes(m); // (3)
//        m.release();
//
//        if (buf.readableBytes() >= 4) { // (4)
//            long currentTimeMillis = (buf.readUnsignedInt() - 2208988800L) * 1000L;
//            System.out.println(new Date(currentTimeMillis));
//            ctx.close();
//        }
/*----------------------------Speaking in POJO instead of ByteBuf----------------------------------*/
        UnixTime m = (UnixTime) msg;
        System.out.println(m);
        ctx.close();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}
