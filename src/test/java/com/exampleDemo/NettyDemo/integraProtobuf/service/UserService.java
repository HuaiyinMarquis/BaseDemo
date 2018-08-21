package com.exampleDemo.NettyDemo.integraProtobuf.service;

import com.exampleDemo.NettyDemo.integraProtobuf.NettyClient1;
import com.exampleDemo.NettyDemo.integraProtobuf.protocoBuf.RequestMsgProtobuf.RequestMsg;
import com.exampleDemo.NettyDemo.integraProtobuf.protocoBuf.UserProtobuf.User;
import org.junit.Test;

public class UserService {

    //组装请求数据
    @Test
    public void save() throws Exception {
        User.Builder user = User.newBuilder();
        user.setId(110);
        user.setName("条子");
//        user.setIsAdult(true);

        RequestMsg.Builder requestMsg = RequestMsg.newBuilder();
        requestMsg.setCmd("seveUser");
        requestMsg.setRequestParam(user.build().toByteString());

        Object result = NettyClient1.start(requestMsg);
        System.out.println(result);
    }
}
