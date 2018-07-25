package com.exampleDemo.RPCFrame.client;

import com.exampleDemo.RPCFrame.IServiceDiscover;
import com.exampleDemo.RPCFrame.ZKConfig;
import com.exampleDemo.RPCFrame.loadbalance.LoadBalance;
import com.exampleDemo.RPCFrame.loadbalance.RandomLoadBalance;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.PathChildrenCache;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheEvent;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheListener;
import org.apache.curator.retry.ExponentialBackoffRetry;

import java.util.List;

public class ZKServiceDiscover implements IServiceDiscover {
    private CuratorFramework curatorFramework;
    List<String> repos;

    {
        curatorFramework =
                CuratorFrameworkFactory.builder()
                        .connectString(ZKConfig.ZKADDRESS_STR)
                        .sessionTimeoutMs(5000)
                        .retryPolicy(new ExponentialBackoffRetry(1000,10))
                        .build();
        curatorFramework.start();
    }

    @Override
    public String discover(String serviceName) {
        String servicePath = ZKConfig.NAMESPACE + "/" + serviceName;
        try {
            repos = curatorFramework.getChildren().forPath(servicePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //动态发现服务节点的变化
        registerWatcher(servicePath);

        LoadBalance loadBalance = new RandomLoadBalance();
        return loadBalance.selectHost(repos);
    }

    private void registerWatcher(String servicePath){
        PathChildrenCache childrenCache = new PathChildrenCache(curatorFramework,servicePath,true);

        PathChildrenCacheListener childrenCacheListener = new PathChildrenCacheListener() {
            @Override
            public void childEvent(CuratorFramework curatorFramework, PathChildrenCacheEvent pathChildrenCacheEvent) throws Exception {
                repos = curatorFramework.getChildren().forPath(servicePath);
            }
        };
        childrenCache.getListenable().addListener(childrenCacheListener);
        try {
            childrenCache.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
