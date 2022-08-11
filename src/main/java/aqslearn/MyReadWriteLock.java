package aqslearn;

import com.sun.org.apache.bcel.internal.generic.RETURN;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.*;

/**
 * author: weijli
 * date: 2021/9/20 21:24
 * description:
 */

public class MyReadWriteLock {


    int SHIFT = 16;
    int MASK = 1<<SHIFT-1;
    public int getWriteCount(int n){
        //写锁占据高十六位
        return n>>SHIFT;
    }
    public int getReadCount(int n){
        return n & MASK;
    }
    ReadLock readLock;
    WriteLock writeLock;
    MyReadWriteLock(){
        readLock=new ReadLock();
        writeLock= new WriteLock();
    }


    class ReadLock implements Lock{
        Sync sync;
        ReadLock(){
            sync = new FairSync();
        }

        @Override
        public void lock() {

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
    class WriteLock implements Lock{
        Sync sync;
        WriteLock(){
            sync = new FairSync();
        }

        @Override
        public void lock() {

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

    class Sync extends AbstractQueuedSynchronizer {
        protected Sync() {
        }

        @Override
        protected boolean tryAcquire(int arg) {
            // 这里是拿写锁
            int w = getWriteCount(getState());
            int c= getState();
            // 条件
            // 1. 无锁被获得

            if(c==0){
                if(compareAndSetState(0,getState()+arg<<SHIFT )){
                    setExclusiveOwnerThread(Thread.currentThread());
                    return true;
                }
            }

            return false;

        }


        @Override
        protected boolean tryRelease(int arg) {
            if(Thread.currentThread()!= getExclusiveOwnerThread()){
                throw new IllegalMonitorStateException();
            }
            // 释放写锁
            int c= getState()- arg<<SHIFT;
            setState(c);
            return true;

        }

        @Override
        protected int tryAcquireShared(int arg) {
            // 这里是拿写锁
            int w = getWriteCount(getState());
            int c= getState();
            // 条件
            // 1. 无锁
            // 读锁
            //
            if(c!=0){
                if(w==0 && compareAndSetState(getState(),getState()+arg)){
                    setExclusiveOwnerThread(Thread.currentThread());
                }
            }else {
                compareAndSetState(0,getState()+arg);
            }
            return 1;



        }
        //多线程的，要考虑
        @Override
        protected boolean tryReleaseShared(int arg) {
            int c =getState();
            int r =getReadCount(c);
            int t =r-arg;
            if(t==0) {
                setExclusiveOwnerThread(null);
            }
            if(t<0){}//

            setState(t);
            //todo
            return false;
        }

        @Override
        protected boolean isHeldExclusively() {
            return super.isHeldExclusively();
        }
    }
    class FairSync extends Sync{

    }

}
