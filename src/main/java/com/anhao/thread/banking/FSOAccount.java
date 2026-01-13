package com.anhao.thread.banking;

/**
 * FOA = fully synchronized objects
 * A class from the backend of a banking system. It models an account.
 *
 * This situation provides deposits, withdrawals, and balance queries-
 * a classic conflict between read and write operations-
 * so synchronization is used to prevent inconsistency.
 */

public class FSOAccount {
  // No public fields
  private double balance;

  // All fields are initialized in the constructor.
  public FSOAccount(double openingBalance) {
    // Check to see openingBalance > 0, throw if not
    balance = openingBalance;
  }

  // All methods are synchronized.
  public synchronized boolean withdraw(int amount) {
    // Check to see amount > 0, throw if not
    if (balance >= amount) {
      balance = balance - amount;
      return true;
    }

    return false;
  }

  public synchronized void deposit(int amount) {
    // Check to see amount > 0, throw if not
    balance = balance + amount;
  }

  public synchronized double getBalance() {
    return balance;
  }

  // this method can cause a deadlock between two threads
  public synchronized boolean transferTo(FSOAccount other, int amount) {
    // Check to see amount > 0, throw if not

    // Sleep to simulate some other checks that need to occur
    // The sleep is for demonstration purposes,
    // not because it is something you’d actually do when writing code for a bank transfer.
    // It’s there to simulate code that would actually be there in practice—a delay caused by
    // a call to a database or an authorization check.
    try {
      // But this also allow the thread scheduler to run both threads
      // and lead to the possibility of deadlock.
      Thread.sleep(10);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }
    if (balance >= amount) {
      balance = balance - amount;
      other.deposit(amount);
      return true;
    }

    return false;
  }
}