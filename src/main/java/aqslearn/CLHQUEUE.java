//package aqslearn;
//
//import java.util.concurrent.atomic.AtomicReference;
//import java.util.concurrent.locks.ReentrantLock;
//
///**
// * author: weijli
// * date: 2021/9/19 19:46
// * description:
// */
//public class CLHQUEUE {
//    static int a = 0;
//
//    public static void main(String[] args) {
//        ClhSpinLock lock = new ClhSpinLock();
//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//
//                try {
//                    lock.lock();
//                    a++;
//                    try {
//                        Thread.sleep(1000L);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println(Thread.currentThread().getName() + "a:" + a);
//
//                } finally {
//                    lock.unlock();
//                }
//
//            }
//        };
//
//        for (int i = 0; i < 10; i++) {
//            new Thread(runnable).start();
//        }
//
//    }
//
//
//    static class ClhSpinLock {
//        private final ThreadLocal<Node> prev;
//        private final ThreadLocal<Node> node;
//        private final AtomicReference<Node> tail = new AtomicReference<Node>(new Node());
//
//        public ClhSpinLock() {
//            this.node = new ThreadLocal<Node>() {
//                protected Node initialValue() {
//                    return new Node();
//                }
//            };
//
//            this.prev = new ThreadLocal<Node>() {
//                protected Node initialValue() {
//                    return null;
//                }
//            };
//        }
//
//        public void lock() {
//            final Node node = this.node.get();
//            node.locked = true;
//            // 一个CAS操作即可将当前线程对应的节点加入到队列中，
//            // 并且同时获得了前继节点的引用，然后就是等待前继释放锁
//            Node pred = this.tail.getAndSet(node);
//            this.prev.set(pred);
//            while (pred.locked) {// 进入自旋
//            }
//        }
//
//        public void unlock() {
//            final Node node = this.node.get();
//            node.locked = false;
//            this.node.set(this.prev.get());
//        }
//
//        private static class Node {
//            private volatile boolean locked;
//        }
//    }
//}
