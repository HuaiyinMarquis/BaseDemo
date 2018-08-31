package com.exampleDemo.NettyDemo.intergraThrift;

import com.exampleDemo.NettyDemo.intergraThrift.service.SearchServiceImpl;
import com.exampleDemo.NettyDemo.intergraThrift.thrift.SearchService;
import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;

public class BIOSearchServer {
    public static void main(String[] args) {
        try {
            //1. 创建Transport
            TServerSocket serverTransport = new TServerSocket(8080);
            TServer.Args tArgs = new TServer.Args(serverTransport);

            //2. 为Transport创建Protocol
            tArgs.protocolFactory(new TBinaryProtocol.Factory());

            //3. 为Protocol创建Processor
            TProcessor processor = new SearchService.Processor<SearchService.Iface>(new SearchServiceImpl());
            tArgs.processor(processor);

            //4. 创建Server并启动
            TServer server = new TSimpleServer(tArgs);

            System.out.println("SearchService TSimpleServer start ....");
            server.serve();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
