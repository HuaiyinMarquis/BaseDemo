package com.exampleDemo.NettyDemo.intergraThrift.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.exampleDemo.NettyDemo.intergraThrift.thrift.RequestType;
import com.exampleDemo.NettyDemo.intergraThrift.thrift.SearchService;
import com.exampleDemo.NettyDemo.intergraThrift.thrift.ThriftRequest;
import com.exampleDemo.NettyDemo.intergraThrift.thrift.ThriftResponse;
import io.netty.util.CharsetUtil;
import org.apache.thrift.TException;

public class SearchServiceImpl implements SearchService.Iface {
    @Override
    public ThriftResponse execute(ThriftRequest request) throws TException {
        ThriftResponse response = new ThriftResponse();
        if (RequestType.QUERY == request.getType()) {
            JSONObject jsonObject = JSON.parseObject(new String(request.getRequestParam(), CharsetUtil.UTF_8));
            Integer id = jsonObject.getInteger("id");
            System.out.println("接到查询请求，请求id为：" + id + "的数据");
            jsonObject.put("name","小明");
            jsonObject.put("age",32);
            jsonObject.put("weight",67.5);
            response.setBody(jsonObject.toJSONString().getBytes(CharsetUtil.UTF_8));
        } else {
            response.setBody("update".getBytes(CharsetUtil.UTF_8));
        }
        return response;
    }
}
