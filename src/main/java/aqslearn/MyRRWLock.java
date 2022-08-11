package aqslearn;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;

/**
 * author: weijli
 * date: 2021/12/20 15:03
 * description:
 */

public class MyRRWLock implements ReadWriteLock {
  
  
  @Override
  public Lock readLock() {
    return null;
  }
  
  @Override
  public Lock writeLock() {
    return null;
  }
}
