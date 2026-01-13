package com.anhao.thread.banking2;

public class Account {
  private double balance;

  public Account(int openingBalance) {
    balance = openingBalance;
  }

  public boolean rawWithdraw(int amount) {
    // Check to see amount > 0, throw if not
    if (balance >= amount) {
      balance = balance - amount;
      return true;
    }
    return false;
  }

  public void rawDeposit(int amount) {
    // Check to see amount > 0, throw if not
    balance = balance + amount;
  }

  public double getRawBalance() {
    return balance;
  }

  public boolean safeWithdraw(final int amount) {
    // Check to see amount > 0, throw if not
    synchronized (this) {
      if (balance >= amount) {
        balance = balance - amount;
        return true;
      }
    }
    return false;
  }

  public void safeDeposit(final int amount) {
    // Check to see amount > 0, throw if not
    synchronized (this) {
      balance = balance + amount;
    }
  }

  public double getSafeBalance() {
    synchronized (this) {
      return balance;
    }
  }
}
