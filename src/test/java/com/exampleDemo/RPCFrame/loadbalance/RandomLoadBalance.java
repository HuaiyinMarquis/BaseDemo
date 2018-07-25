package com.exampleDemo.RPCFrame.loadbalance;

import java.util.List;
import java.util.Random;

public class RandomLoadBalance extends AbstractLoadBalance {
    @Override
    String doSelect(List<String> repos) {
        Random random = new Random();
        return repos.get(random.nextInt(repos.size()));
    }
}
