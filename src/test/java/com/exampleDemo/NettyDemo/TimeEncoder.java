package com.exampleDemo.NettyDemo;

import com.exampleDemo.NettyDemo.pojo.UnixTime;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 *(1)、在这一行中有很多重要的东西。
 *      首先，我们按照原样来传递原始的ChannelPromise，当编码的数据被写出去的时候Netty把它标记为成功或失败。
 *      其次，我们没有调用ctx.flush()。这里有一个单独的处理方法void flush(ChannelHandlerContext ctx)，它是计划覆盖 flush()方法操作。
 */
//public class TimeEncoder extends ChannelOutboundHandlerAdapter {
//    @Override
//    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) {
//        UnixTime m = (UnixTime) msg;
//        ByteBuf encoded = ctx.alloc().buffer(4);
//        encoded.writeInt((int)m.value());
//        ctx.write(encoded, promise); // (1)
//    }
//}
/**
 * 进一步简化，你可以使用MessageToByteEncoder
 */
public class TimeEncoder extends MessageToByteEncoder<UnixTime> {
    @Override
    protected void encode(ChannelHandlerContext ctx, UnixTime msg, ByteBuf out) {
        out.writeInt((int)msg.value());
    }
}