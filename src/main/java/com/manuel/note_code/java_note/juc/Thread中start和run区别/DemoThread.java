package com.manuel.note_code.java_note.juc.Thread中start和run区别;

/**
 * @Author: manuel
 * @Date: Created in 2023/2/23 23:05
 * @Description:
 */
public class DemoThread {

  public static void main(String[] args) {
    MyThread myThread = new MyThread("myThread");

    System.out.println(Thread.currentThread().getName() + " call myThread.run()");
    myThread.run();

    System.out.println(Thread.currentThread().getName() + " call myThread.start()");
    myThread.start();
  }
}

class MyThread extends Thread{
  public MyThread(String name) {
    super(name);
  }

  @Override
  public void run() {
    System.out.println(Thread.currentThread().getName() + " is running.");
  }
}
