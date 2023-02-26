package com.manuel.note_code.java_note.juc.synchronized关键字;

/**
 * @Author: manuel
 * @Date: Created in 2023/2/26 22:29
 * @Description:
 * 当一个线程访问“某对象”的“synchronized方法”/“synchronized代码块”时，其他线程对“该对象”的该“synchronized方法”/“synchronized代码块”的访问被阻塞
 */
public class MyThread_NO_1_1 {

  public static void main(String[] args) {
    Runnable runnable = new MyRunnable();

    Thread t1 = new Thread(runnable, "t1");
    Thread t2 = new Thread(runnable, "t2");
    t1.start();
    t2.start();
  }
}

class MyRunnable implements Runnable {

  @Override
  public void run() {
    synchronized (this) {
      try {
        for (int i = 0; i < 5; i++) {
          Thread.sleep(100);
          System.out.println(Thread.currentThread().getName() + " loop " + i);
        }
      } catch (InterruptedException e) {
      }
    }
  }
}
