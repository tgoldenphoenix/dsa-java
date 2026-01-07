package com.anhao.thread;

public class SynchronizedExample implements Runnable {
  public static int a, b;

  public static void main(String[] args) {
    a = 100;
    b = 100;

    // Check the total amount shared between a and b before the transfers
    System.out.println("Total before: " + (a + b));

    // Run threads which will transfer amounts between a and b
    Thread thread1 = new Thread(new SynchronizedExample());
    Thread thread2 = new Thread(new SynchronizedExample());
    thread1.start();
    thread2.start();

    // Wait for the threads to finish running
    try {
      thread1.join();
      thread2.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    // Check the total amount shared between a and b after the transfers
    // It should be the same amount as before
    System.out.println("Total after: " + (a + b));
  }

  public void run() {
    // repeat transfer qua lại a (big) number of times
    for (int i = 0; i < 10000000; i++) {
      transfer();
    }
  }

  public static synchronized void transfer() {
    // Choose a random amount to transfer
    int amount = (int) (5.0 * Math.random());

    // Transfer between a and b
    if (a > b) {
      a -= amount;
      b += amount;
    } else {
      a += amount;
      b -= amount;
    }
  }
}
