package com.anhao.accessModifiers02;

public class B {
  // private constructor will make class A not able to `new` class B object
//  private B() {}

  public String public_string = "a";
  String default_string = "a";
  protected String protected_string = "a";
}
