package com.anhao.basic_syntax;

@FunctionalInterface// can only have one abstract method
interface Printable {
  void print(String suffix);
//  void write();
}

public class Lambda {
  public static void main(String[] args) {
    // save lambda like an object that implement Printable
    Printable lambdaPrintable = (s) -> System.out.println("Con meo keu meo meo. " + s);
    printThing(lambdaPrintable);
  }

  // `thing` parameter can be any object that implements Printable interface
  static void printThing(Printable thing) {
    thing.print("!!!");
  }
}
