package com.manuel.note_code.java_note.juc.Thread和Runnable;

/**
 * @Author: manuel
 * @Date: Created in 2023/2/21 23:41
 * @Description: 继承Thread类实现多线程
 */
public class MyThread_t extends Thread {

  private int ticket = 10;

  public void run() {
    for (int i = 0; i < 20; i++) {
      if (this.ticket > 0) {
        System.out.println(this.getName() + " 卖票：ticket" + this.ticket--);
      }
    }
  }

  public static void main(String[] args) {
    MyThread_t t1 = new MyThread_t();
    MyThread_t t2 = new MyThread_t();
    MyThread_t t3 = new MyThread_t();
    t1.start();
    t2.start();
    t3.start();
  }
}
