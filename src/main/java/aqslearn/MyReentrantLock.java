package aqslearn;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MyReentrantLock implements Serializable, Lock {
    //aba问题  -> 版本号
    //cas
    @Override
    public void lock() {
        ReentrantLock reentrantLock;
        ReentrantReadWriteLock reentrantReadWriteLock;
        
    }
    
    @Override
    public void lockInterruptibly() throws InterruptedException {


    }
    
    @Override
    public boolean tryLock() {
        return false;
    }
    
    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }
    
    @Override
    public void unlock() {
    
    }
    
    @Override
    public Condition newCondition() {
        return null;
    }
}