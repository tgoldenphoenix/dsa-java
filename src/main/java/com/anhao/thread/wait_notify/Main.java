package com.anhao.thread.wait_notify;

/**
 * https://www.baeldung.com/java-wait-notify
 */

public class Main {
  public static void main(String[] args) {
    Data data = new Data();
    Thread sender = new Thread(new Sender(data));
    sender.setName("Thread-sender");
    Thread receiver = new Thread(new Receiver(data));
    receiver.setName("Thread-receiver");

    sender.start();
    receiver.start();
  }
}
