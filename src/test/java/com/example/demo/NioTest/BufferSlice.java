package com.example.demo.NioTest;

import java.nio.ByteBuffer;

/**
 *缓冲区分片
 * 只读缓冲区
 * 直接缓冲区
 * Created by ChenMP on 2018/3/1.
 */
public class BufferSlice {

    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(10);

        //设置buffer值
        for (int i=0; i<buffer.capacity(); i++) {
            buffer.put((byte) i);
        }

        buffer.position(3);
        buffer.limit(6);

        ByteBuffer slice = buffer.slice();
        ByteBuffer readOnlyBuffer = buffer.asReadOnlyBuffer();

        while (slice.hasRemaining()) {
            System.out.println(slice.put((byte) 33));
        }

//        slice.put(8, (byte) 222); error

        buffer.flip();

        buffer.limit(buffer.capacity());

        System.out.println("limit:"+buffer.limit());

        while (buffer.hasRemaining()) {
            System.out.println(buffer.get());
        }
    }
}