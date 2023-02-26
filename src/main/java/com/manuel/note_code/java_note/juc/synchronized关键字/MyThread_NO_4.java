package com.manuel.note_code.java_note.juc.synchronized关键字;

/**
 * @Author: manuel
 * @Date: Created in 2023/2/26 23:00
 * @Description:
 */
public class MyThread_NO_4 {

  public synchronized void synMethod() {
    for(int i=0; i<1000000; i++) {}
  }

  public void syncBlock() {
    synchronized( this ) {
      for(int i=0; i<1000000; i++) {}
    }
  }

  public static void main(String[] args) {
    MyThread_NO_4 demo = new MyThread_NO_4();

    long start, diff;
    start = System.currentTimeMillis();
    demo.synMethod();
    diff = System.currentTimeMillis() - start;
    System.out.println("syncMethod() : " + diff);

    start = System.currentTimeMillis();
    demo.syncBlock();
    diff = System.currentTimeMillis() - start;
    System.out.println("syncBlock() : " + diff);
  }
}
