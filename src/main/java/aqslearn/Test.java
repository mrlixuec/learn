//package aqslearn;
//
//import java.util.concurrent.locks.ReentrantLock;
//
///**
// * author: weijli
// * date: 2021/9/19 17:54
// * description:
// */
//
//public class Test {
//    static int a= 0;
//    public static void main(String[] args) {
//        ReentrantLock lock=new ReentrantLock();
//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//
//                try {
//                    lock.lock();
//                    a++;
//                    try {
//                        Thread.currentThread().interrupt();
//                        System.out.println("中断");
//                        Thread.sleep(1000L);
//                        System.out.println("清楚中断状态");
//                    } catch (InterruptedException e) {
////                        Thread.interrupted();
//                    }
//                    System.out.println(Thread.currentThread().getName()+"a:"+a);
//
//                }finally {
//                    lock.unlock();
//                }
//
//            }
//        };
//
//        for (int i=0;i<10;i++){
//            new Thread(runnable).start();
//        }
//
//
//
//    }
//}
