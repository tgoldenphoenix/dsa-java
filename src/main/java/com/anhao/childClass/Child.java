package com.anhao.childClass;

import com.anhao.basic_syntax.ProtectedCl;

// different package
class SecondGenericClass extends ProtectedCl {
  // override bien protected
  String protectedVar = "a inside SecondGenericClass";

  public void xyz() {
    // new duoc doi tuong
    ProtectedCl b = new ProtectedCl();
    // nhung khong nhin thay protected property của class cha ProtectedCl
//    b.a = "anhao pham";

    // this is a function-scope, will override class variable
//     protectedVar = "a function-scope var";

    // ke thua bien protected tu ProtectedCl => cua chinh no nen no thấy duoc
    System.out.println(protectedVar);
    System.out.println(this.protectedVar);
    System.out.println(super.protectedVar);

    // khong the ke thua default variable khac package
//    System.out.println(defaultVar);
  }

  public static void main(String[] args) {
    SecondGenericClass b = new SecondGenericClass();
    b.xyz();
  }
}
