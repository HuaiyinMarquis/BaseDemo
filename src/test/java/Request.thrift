namespace java com.exampleDemo.NettyDemo.intergraThrift.thrift

// thrift --gen java Test.thrift
enum RequestType {
   QUERY,   //查询
   UPDATE,  //更新
}

struct ThriftRequest {
	1: required RequestType type;  // 请求的类型，必选
	2: optional binary requestParam;
}

struct ThriftResponse {
	1: optional binary body;
}

service SearchService{
    ThriftResponse execute(1:required ThriftRequest request);
}