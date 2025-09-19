package com.anhao.basic_syntax;

// same package
public class GenericClass extends ProtectedCl {
  String a = "a in GenericClass";

  public void xyz() {
    System.out.println(a);
    System.out.println(this.a);
    System.out.println(super.a);
  }

  public static void main(String[] args) {

//    ProtectedCl protectedClassObj = new ProtectedCl();
//    // GenericClass nhin thay access bien protected
//    System.out.println(protectedClassObj.protectedVar);
//    protectedClassObj.protectedVar = "a trong GenericClass";
//    System.out.println(protectedClassObj.protectedVar);
//
//    // GenericClass also nhin thay default Var
//    System.out.println("default var in Cha: " + protectedClassObj.defaultVar);
////    protectedClassObj.protectedMethod();

    // ================= This & super ====================
    GenericClass obj = new GenericClass();
    obj.xyz();
  }
}
