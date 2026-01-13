package com.anhao.thread.banking;

public class FSOMain {
  private static final int MAX_TRANSFERS = 1_000;

  public static void main(String[] args) throws InterruptedException {
    FSOAccount a = new FSOAccount(10_000);
    FSOAccount b = new FSOAccount(10_000);

    Thread tA = new Thread(() -> {
      for (int i = 0; i < MAX_TRANSFERS; i = i + 1) {
        boolean ok = a.transferTo(b, 1);
        if (!ok) {
          System.out.println("Thread A failed at "+ i);
        }
      }
    }, "thread-A");
    Thread tB = new Thread(() -> {
      for (int i = 0; i < MAX_TRANSFERS; i = i + 1) {
        boolean ok = b.transferTo(a, 1);
        if (!ok) {
          System.out.println("Thread B failed at "+ i);
        }
      }
    }, "thread-B");

    tA.start();
    tB.start();
    // main wait for both A & B threads
    tA.join();
    tB.join();

    System.out.println("End: "+ a.getBalance() + " : "+ b.getBalance());
  }
}