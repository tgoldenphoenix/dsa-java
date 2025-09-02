package com.anhao.syntax;

public class ProtectedCl {
  protected String protectedVar = "a trong ProtectedCl";
  String defaultVar = "default var in ProtectedCl";
  String a = "a";

  protected void protectedMethod() {
    System.out.println("Value of String a: " + protectedVar);
  }
}