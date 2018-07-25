package com.exampleDemo.RPCFrame.server;

import com.exampleDemo.RPCFrame.IRegisterCenter;
import com.exampleDemo.RPCFrame.ZKConfig;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.CreateBuilder;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;

public class ZKRegisterCenter implements IRegisterCenter {
    private CuratorFramework curatorFramework;

    {
        curatorFramework =
                CuratorFrameworkFactory.builder()
                        .connectString(ZKConfig.ZKADDRESS_STR)
                        .sessionTimeoutMs(5000)
                        .retryPolicy(new ExponentialBackoffRetry(1000,10))
                        .build();
        curatorFramework.start();
    }

    /**
     *
     * @param serviceName
     * @param serviceAddress = IP:PORT
     */
    @Override
    public void regiter(String serviceName, String serviceAddress) {
        String servicePath = ZKConfig.NAMESPACE+"/"+serviceName;

        try {
            if (curatorFramework.checkExists().forPath(servicePath) == null) {
                CreateBuilder createBuilder = curatorFramework.create();
                createBuilder.creatingParentsIfNeeded();
                createBuilder.withMode(CreateMode.PERSISTENT);
                createBuilder.forPath(servicePath,"0".getBytes());
            }

            String addressPath = servicePath+"/"+serviceAddress;
            String rcNode = curatorFramework.create().withMode(CreateMode.EPHEMERAL)
                    .forPath(addressPath, "0".getBytes());
            System.out.println("服务注册成功 -> " + rcNode);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
