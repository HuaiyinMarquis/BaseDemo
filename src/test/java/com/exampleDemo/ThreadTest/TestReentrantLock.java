package com.exampleDemo.ThreadTest;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class TestReentrantLock {
    private static ReentrantLock reentrantLock = new ReentrantLock(); //new NonfairSync(); 默认是非公平锁
    private static Condition condition = reentrantLock.newCondition();

    public static void main(String[] args) throws InterruptedException {

        reentrantLock.lock();//①
        condition.await();//③
        condition.signal();//④
        reentrantLock.unlock();//②
    }
}
/**
 * 源码分析：
 *  ① = lock()步骤
 *      执行compareAndSetState(0, 1)操作，利用unsafe.compareAndSwapInt(this, stateOffset, expect, update)这个方式设置state这个同步状态，
 *      判断是否设置成功
 *      ----true：执行exclusiveOwnerThread = thread;这段代码的意思是将当前获取锁的线程保存起来，代表此线程占有锁。
 *      ----false：代表没有获取到锁，执行acquire(1)方法，内部代码逻辑如下
 *          if (!tryAcquire(arg) && acquireQueued(addWaiter(Node.EXCLUSIVE), arg))
 *             selfInterrupt();
 *          1、tryAcquire(arg)是一个获取锁的方法，其中的逻辑是：
 *              获取state判断是否为0，如果为0则利用CAS算法将state设置为1，然后将当前线程保存设置为拥有锁的线程。
 *              else 判断当前线程是否等于拥有锁的线程，如果是，则state++，表示重入锁。
 *          2、addWaiter(Node.EXCLUSIVE)分析：将当前线程封装成Node对象，判断Waiter链表是否为空。
 *              如果不为空，利用CAS算法添加到尾部。
 *              如果为空，执行enq(node)方法。里面通过一个死循环确认Waiter链表为空，然后利用CAS算法初始化Waiter链表，将head和tail指向
 *                  Node对象。如果确认Waiter链表不为空，则利用CAS算法将Node对象添加到尾部。return Node对象。如果只有一个Node对象进入这一方法，
 *                  在执行完初始化链表之后，还会再循环将自己再次插入到链表尾部。
 *          3、acquireQueued(Node, arg) 获取Node的前一个节点p（如果Waiter中只有自己的话它获得的也是自己）进行判断。
 *              如果p是首节点，且通过tryAcquire(arg)（tryAcquire(arg)方法已经在上面有解读过了）方法获得到了锁则执行以下操作：
 *                  去掉将Node节点设置为Head，将Node节点的prev和thread都设置为null。这都是当前线程获取到锁的处理
 *              判断执行shouldParkAfterFailedAcquire(p, node) && parkAndCheckInterrupt()。
 *                  shouldParkAfterFailedAcquire(p, node)的处理是设置和确认waitStatus。确认park前不能获取锁
 *                  parkAndCheckInterrupt()的处理是调用LockSupport.park(this);对当前线程进行阻塞。其内部实现是利用UNSAFE里面的方法进行处理。然后执行interrupted()。将interrupted状态改变。
 *              如果当前线程没有获取锁，则还需执行cancelAcquire(node)方法处理。
 *          4、selfInterrupt();执行Thread.currentThread().interrupt();
 *  ② = unlock()步骤
 */
