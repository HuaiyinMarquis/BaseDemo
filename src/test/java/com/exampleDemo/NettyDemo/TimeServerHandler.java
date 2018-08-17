package com.exampleDemo.NettyDemo;

import com.exampleDemo.NettyDemo.pojo.UnixTime;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 *(1)、入同之前解释的，channelActive()方法在一个连接建立好了且准备产生流量的时候被调用。
 *      我们写一个32位的整数表示在这个方法内当前的世界。
 *(2)、要发送一个新的消息，我们需要分配一个新的缓冲区用来包含消息。我们将要写一个32位的整数，因此我们需要一个ByteBuf用来包含至少四个字节
 *      调用ChannelHandlerContext.alloc()获取当前的ByteBufAllocator来分配一个新的buffer
 *(3)、通常，我们写要被构建的消息。但是请注意，我们这里没有flip()方法。我们应该在ByteBuffer切换读写的时候调用java.nio.ByteBuffer.flip()。
 *      ByteBuf 没有类似的这样一个方法，因为它有两个索引。一个用于读操作一个用于写操作。当你写入的时候写索引自增同时读索引不会变
 *      写索引和读索引分别代表了消息的开始和接收。
 *      除了flip 方法NIO没有提供一个便捷的方式解决确定消息开始和结束的地方。如果你忘记使用flip你会很麻烦因为不会给你任何错误的数据和提示。
 *      这样的错误不会发生在netty，因为针对不同的操作netty有不同的索引。你会用的很爽。
 *      另一点需要注意的是，ChannelHandlerContext.write()(和 writeAndFlush())方法返回一个ChannelFuture。一个ChannelFuture代表一个还没有
 *      发生的I/O操作。这意味着任何被请求的操作可能还没有执行因为在netty中所有的操作都是异步的。比如说下面的代码可能在消息发送之前就
 *      关闭了连接：
 *          Channel ch = ...;
 *          ch.writeAndFlush(message);
 *          ch.close();
 *      因此，你必须在 ChannelFuture完成之后调用close() 方法，ChannelFuture有write()方法返回，当写操作完成的时候它会通知它的监听器。
 *      请注意，close()同样可能不会立刻关闭连接，它也会返回一个ChannelFuture。
 *(4)、当一个写请求完成的时候，我们怎样获取通知呢？这就像在返回的ChannelFuture中添加一个ChannelFutureListener一样简单。这里我们创建
 *      了一个匿名的ChannelFutureListener，当操作完成的时候关闭Channel。
 *      或者，您可以使用预定义的监听器简化代码：
 *          f.addListener(ChannelFutureListener.CLOSE);
 *
 *
 */
public class TimeServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(final ChannelHandlerContext ctx) { // (1)
//        final ByteBuf time = ctx.alloc().buffer(4); // (2)
//        time.writeInt((int) (System.currentTimeMillis() / 1000L + 2208988800L));
//
//        final ChannelFuture f = ctx.writeAndFlush(time); // (3)
//        f.addListener(new ChannelFutureListener() {
//            @Override
//            public void operationComplete(ChannelFuture future) {
//                assert f == future;
//                ctx.close();
//            }
//        }); // (4)
/*----------------------------Speaking in POJO instead of ByteBuf----------------------------------*/
        ChannelFuture f = ctx.writeAndFlush(new UnixTime());
        f.addListener(ChannelFutureListener.CLOSE);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}
