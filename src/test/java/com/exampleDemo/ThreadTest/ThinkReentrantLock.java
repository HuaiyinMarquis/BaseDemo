package com.exampleDemo.ThreadTest;

import java.util.concurrent.locks.ReentrantLock;

//解读ReentrantLock
public class ThinkReentrantLock {

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        /**
         * 解读lock()：
         *  if (compareAndSetState(0, 1))   利用CAS算法获取锁，获取到则将拥有锁的线程设置为当前线程，然后直接返回
         *      setExclusiveOwnerThread(Thread.currentThread());
         *  else    没有获取到锁，进行后续处理
         *      acquire(1);
         *---------------------------------------------------------------------------------------------------------
         * if (!tryAcquire(arg) 通过一个state反映锁的持有情况，为0直接通过CAS算法获取锁，有则判断是否是重入锁：
         *      执行int nextc = getState(); + acquires;setState(nextc);没有获取到锁则返回false，执行下面的代码
         * && acquireQueued(addWaiter(Node.EXCLUSIVE), arg))
         *      boolean failed = true;
         *         try {
         *             boolean interrupted = false;
         *             for (;;) {
         *                 final Node p = node.predecessor(); 获取前一个节点
         *                 if (p == head && tryAcquire(arg)) { 判断前一个节点是否是首节点，如果是则利用前一个节点去获取锁
         *                     setHead(node);
         *                     p.next = null; // help GC
         *                     failed = false;
         *                     return interrupted;
         *                 }
         *                 if (shouldParkAfterFailedAcquire(p, node) &&
         *                     parkAndCheckInterrupt()) 检查是否需要park  LockSupport.park(this);
         *                     interrupted = true;
         *             }
         *         } finally {
         *             if (failed)
         *                 cancelAcquire(node);
         *         }
         *      selfInterrupt();
         *
         */
        lock.unlock();
        /**
         * if (tryRelease(arg)) {
         *             Node h = head;
         *             if (h != null && h.waitStatus != 0)
         *                 unparkSuccessor(h); 执行unpark逻辑    UNSAFE.unpark(thread);
         *             return true;
         *         }
         *         return false;
         */
    }

}
