package aqslearn;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * author: weijli
 * date: 2021/9/17 19:40
 * description:
 */

public class AbstractQLearn {

    public static void main(String[] args) {
        AbstractQueuedSynchronizer aqs = new AbstractQueuedSynchronizer() {
        };
        //读写锁怎么实现
        ReentrantLock reentrantLock;
        //
        ReentrantReadWriteLock reentrantReadWriteLock;
        //
        Thread thread;
        AbstractQueuedSynchronizer myReentrantLock = new AbstractQueuedSynchronizer() {
            @Override
            protected boolean tryAcquire(int arg) {
                return super.tryAcquire(arg);
            }

            @Override
            protected boolean tryRelease(int arg) {
                return super.tryRelease(arg);
            }

            @Override
            protected int tryAcquireShared(int arg) {
                return super.tryAcquireShared(arg);
            }

            @Override
            protected boolean tryReleaseShared(int arg) {
                return super.tryReleaseShared(arg);
            }

            @Override
            protected boolean isHeldExclusively() {
                return super.isHeldExclusively();
            }

        };

    }

}
