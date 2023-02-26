package com.manuel.note_code.java_note.juc.synchronized关键字;

/**
 * @Author: manuel
 * @Date: Created in 2023/2/26 22:44
 * @Description: 当一个线程访问“某对象”的“synchronized方法”/“synchronized代码块”时，其他线程仍然可以访问“该对象”的非同步代码块
 */
public class MyThread_NO_2 {

  public static void main(String[] args) {
    final CountNO2 count = new CountNO2();
    Thread t1 = new Thread(
        new Runnable() {
          @Override
          public void run() {
            count.syncMethod();
          }
        }, "t1");
    Thread t2 = new Thread(
        new Runnable() {
          @Override
          public void run() {
            count.nonSyncMethod();
          }
        }, "t2");
    t1.start();
    t2.start();
  }
}

class CountNO2 {

  /**
   * synchronized 方法
   */
  public void syncMethod() {
    synchronized (this) {
      try {
        for (int i = 0; i < 5; i++) {
          // 休眠100ms
          Thread.sleep(100);
          System.out.println(Thread.currentThread().getName() + " synMethod loop " + i);
        }
      } catch (InterruptedException ie) {
      }
    }
  }

  /**
   * 非synchronized 方法
   */
  public void nonSyncMethod() {
    try {
      for (int i = 0; i < 5; i++) {
        // 休眠100ms
        Thread.sleep(100);
        System.out.println(Thread.currentThread().getName() + " nonSynMethod loop " + i);
      }
    } catch (InterruptedException ie) {
    }
  }
}
