package com.anhao.accessModifiers;

import com.anhao.accessModifiers02.B;

public class A extends B {
  public void xyz() {
    B b = new B(); // Class A nhin thấy class B
    b.public_string = "Anhao"; // Class A nhin thay properties của class B

    // dù A da ke thua B nhung van khong access protected property of B
//    b.protected_a = "Anhao";
    super.protected_string = "Anhao";

    // lay property of A not B, similar to this.a
    protected_string = "An Hao";
//    this.protected_string = "Anhao2";
  }
}
