package com.exampleDemo.ZookeeperTest;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

public class TestZookeeperConn {
    private static final String conStr = "192.168.6.128:2181,192.168.6.129:2181,192.168.6.130:2181";
    private static int sessionTimeOut = 5000;
    private static CountDownLatch countDownLatch = new CountDownLatch(1);
    public static void main(String[] args) {
        try {
            ZooKeeper zooKeeper = new ZooKeeper(conStr, sessionTimeOut, new Watcher() {
                @Override
                public void process(WatchedEvent watchedEvent) {
                    System.out.println("全局Watcher 监听到事件：" + watchedEvent.getState());
                    if (watchedEvent.getState() == Event.KeeperState.SyncConnected)
                        countDownLatch.countDown();
                    else if (watchedEvent.getState() == Event.KeeperState.AuthFailed)
                        System.out.println("连接失败.....");

                    if (watchedEvent.getType() == Event.EventType.NodeDataChanged) {
                        System.out.println("节点：" + watchedEvent.getPath() + "中的数据发生改变");
                    } else if (watchedEvent.getType() == Event.EventType.NodeChildrenChanged) {
                        System.out.println("节点：" + watchedEvent.getPath() + "中的子节点发生改变");
                    }
                }
            });

//            System.out.println(zooKeeper.getState());
//            Thread.sleep(2000);
//            System.out.println(zooKeeper.getState());
            countDownLatch.await();
//            zooKeeper.create("/test","test value".getBytes(),ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT);
            Stat stat = new Stat();
//            zooKeeper.getData("/test",true,stat);
//            zooKeeper.setData("/test","test value2".getBytes(),stat.getVersion());
            zooKeeper.getData("/test",true,stat);
            zooKeeper.create("/test/child","child value1".getBytes(),ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT);

            zooKeeper.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
