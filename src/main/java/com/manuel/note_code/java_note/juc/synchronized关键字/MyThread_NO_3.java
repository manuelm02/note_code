package com.manuel.note_code.java_note.juc.synchronized关键字;

/**
 * @Author: manuel
 * @Date: Created in 2023/2/26 22:51
 * @Description:
 * 当一个线程访问“某对象”的“synchronized方法”/“synchronized代码块”时，其他线程对“该对象”的其他的“synchronized方法”/“synchronized代码块”的访问将被阻塞
 */
public class MyThread_NO_3 {

  public static void main(String[] args) {
    final CountNO3 count = new CountNO3();

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

class CountNO3 {

  public void syncMethod() {
    synchronized (this) {
      try {
        for (int i = 0; i < 5; i++) {
          // 休眠100ms
          Thread.sleep(100);
          System.out.println(Thread.currentThread().getName() + " syncMethod loop " + i);
        }
      } catch (InterruptedException ie) {
      }
    }
  }

  public void nonSyncMethod() {
    synchronized(this) {
      try {
        for (int i = 0; i < 5; i++) {
          Thread.sleep(100);
          System.out.println(Thread.currentThread().getName() + " nonSyncMethod loop " + i);
        }
      } catch (InterruptedException ie) {
      }
    }
  }
}
