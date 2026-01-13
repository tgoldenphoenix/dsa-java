package com.anhao.thread;

/**
 * This is pretty simple stuff: the main thread creates the worker, starts it,
 * then waits for at least 100 ms (to give the scheduler a chance to run)
 * before reaching the join() call, which causes it to pause until the worker thread exits.
 * In the meantime, the worker thread completes the sleep, wakes up again,
 * and prints out the message.
 */

public class ThreadMethods {
  public static void main(String[] args) throws InterruptedException {
    Runnable r = () -> {
      var start = System.currentTimeMillis();
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
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
    // The main thread pauses and waits for the worker to exit before continuing.
    t.join();
    System.out.println("Exiting");
  }
}
