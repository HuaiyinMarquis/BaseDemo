package com.exampleDemo.NettyDemo.intergraThrift;

import com.alibaba.fastjson.JSONObject;
import com.exampleDemo.NettyDemo.intergraThrift.thrift.RequestType;
import com.exampleDemo.NettyDemo.intergraThrift.thrift.SearchService;
import com.exampleDemo.NettyDemo.intergraThrift.thrift.ThriftRequest;
import com.exampleDemo.NettyDemo.intergraThrift.thrift.ThriftResponse;
import com.sun.org.apache.xpath.internal.operations.String;
import io.netty.util.CharsetUtil;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.junit.Test;

public class SearchClient {
    @Test
    public void testClient() {
        try {
            TTransport transport = new TSocket("127.0.0.1",8080);

            TProtocol protocol = new TBinaryProtocol(transport);

            SearchService.Client client = new SearchService.Client(protocol);
            transport.open();

            ThriftRequest request = new ThriftRequest();
            request.setType(RequestType.QUERY);
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id",001);
            request.setRequestParam(jsonObject.toJSONString().getBytes(CharsetUtil.UTF_8));
            ThriftResponse response = client.execute(request);
            System.out.println(new java.lang.String(response.getBody()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
