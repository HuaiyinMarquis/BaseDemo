package com.exampleDemo.NettyDemo;

import com.exampleDemo.NettyDemo.pojo.UnixTime;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 *(1)、ByteToMessageDecoder 是关于ChannelInboundHandler的实现，它让碎片化的问题变得容易处理
 *(2)、当接收新的数据的时候ByteToMessageDecoder会利用内部维护累积的buffer 调用decode()方法。
 *(3)、decode()方法可以决定在累积的buffer中没有足够数据的地方不添加任何东西。当接收到更多的数据时，ByteToMessageDecoder将再次调用decode()方法
 *(4)、如果decode()方法将一个Object添加到out，这意味着解码器成功解码了一条信息。ByteToMessageDecoder将丢弃读取的累积的buffer的一部分。
 *      请记住，你不需要解码多个消息。ByteToMessageDecoder将会保持调用decode()方法直到它不再添加任何东西到out
 *
 *      ReplayingDecoder 可以简化处理
 *      Netty提供了开箱即用的解码器，使您能够非常容易地实现大多数协议，并帮助您避免最终使用一个不可维护的处理程序实现：
 *          io.netty.example.factorial 二进制协议
 *          io.netty.example.telnet 文本基于行协议
 */
public class TimeDecoder extends ByteToMessageDecoder { // (1)
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) { // (2)
        if (in.readableBytes() < 4) {
            return; // (3)
        }

        out.add(in.readBytes(4)); // (4)
//        out.add(new UnixTime(in.readUnsignedInt()));
    }
}
