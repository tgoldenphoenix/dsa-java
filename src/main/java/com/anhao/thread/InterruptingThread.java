package com.anhao.thread;

/**
 * k
 */

public class InterruptingThread {
  public static void main(String[] args) throws InterruptedException {
    Runnable r = () -> {
      var start = System.currentTimeMillis();
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        // Our Runnable must handle the checked InterruptedException.
        // When we interrupt, it prints the stack,
        // and then execution continues from here.
        e.printStackTrace();
      }
      var thisThread = Thread.currentThread();
      System.out.println(thisThread.getName() +
              " slept for "+ (System.currentTimeMillis() - start));
    };

    // The thread’s metadata object is created.
    var t = new Thread(r);
    t.setName("Worker");
    // The operating system creates an actual thread.
    t.start();
    Thread.sleep(100);
    // The main thread interrupts the worker and wakes it up.
    t.interrupt();
    // The main thread pauses and waits for the worker to exit before continuing.
    t.join();
    System.out.println("Exiting");
  }
}
