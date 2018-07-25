package com.exampleDemo.RPCFrame.loadbalance;

import java.util.List;

public abstract class AbstractLoadBalance implements LoadBalance {
    @Override
    public String selectHost(List<String> repos) {
        if (repos.isEmpty() || repos.size() == 0)
            return null;
        if (repos.size() == 1)
            return repos.get(0);
        return doSelect(repos);
    }

    abstract String doSelect(List<String> repos);
}
