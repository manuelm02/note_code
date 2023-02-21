package com.manuel.note_code.java_note.juc.Thread和Runnable;

/**
 * @Author: manuel
 * @Date: Created in 2023/2/21 23:50
 * @Description: 实现Runnable接口实现多线程
 */
public class MyThread_r implements Runnable{

  private int ticket = 10;

  @Override
  public void run() {
    for (int i = 0; i < 20; i++) {
      if (this.ticket > 0) {
        System.out.println(Thread.currentThread().getName() + " 卖票：ticket" + this.ticket--);
      }
    }
  }

  public static void main(String[] args) {
    MyThread_r myThreadR = new MyThread_r();
    Thread t1 = new Thread(myThreadR);
    Thread t2 = new Thread(myThreadR);
    Thread t3 = new Thread(myThreadR);
    t1.start();
    t2.start();
    t3.start();
  }
}
