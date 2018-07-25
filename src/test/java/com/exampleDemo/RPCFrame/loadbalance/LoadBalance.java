package com.exampleDemo.RPCFrame.loadbalance;

import java.util.List;

public interface LoadBalance {
    String selectHost(List<String> repos);
}
