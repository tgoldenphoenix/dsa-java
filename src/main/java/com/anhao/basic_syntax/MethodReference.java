package com.anhao.basic_syntax;

import java.util.Arrays;
import java.util.List;

/**
 * Method Reference `::`
 */

class Greeter {
  public void greet(String name) {
    System.out.println("Hello, " + name + "!");
  }
}

public class MethodReference {
  public static void main(String[] args) {
    // 1. Reference to a Static Method
    // Without method reference
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
    numbers.forEach(number -> System.out.println(number));

    // With method reference
    numbers.forEach(System.out::println);

    // 2. Reference to an Instance Method of a Particular Object
    // Without method reference
    Greeter greeter = new Greeter();
    List<String> family = List.of("Dan", "Jen", "Isabella","Juliana");
    family.forEach(name -> greeter.greet(name));

    // With method reference
    family.forEach(greeter::greet);
  }
}
