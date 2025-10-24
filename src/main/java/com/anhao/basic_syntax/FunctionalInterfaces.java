package com.anhao.basic_syntax;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FunctionalInterfaces {
  public static void main(String[] args) {

    /*
    * Predicate<T> Represents a boolean-valued function of one argument.
    */
    Predicate<String> isLongerThan5 = str -> str.length() > 5;
    System.out.println(isLongerThan5.test("hello")); // false
    System.out.println(isLongerThan5.test("hellooo")); // true

    /*
    * Function<T, R> Represents a function that accepts one argument and produces a result.
    */
    Function<String, Integer> stringLength = str -> str.length();
    System.out.println(stringLength.apply("hello")); // 5

    /* Consumer<T> Represents an operation that accepts a single input argument and returns no result. */
    Consumer<String> print = str -> System.out.println(str);
    print.accept("Hello, World!"); // Hello, World!

    /* Using Functional Interfaces with Collections */
    List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "Dave");
    names.forEach(name -> System.out.println(name)); // Consumer
    List<String> longNames = names.stream()
            .filter(name -> name.length() > 3) // Predicate
            .collect(Collectors.toList());
    longNames.forEach(System.out::println); // Method reference
  }

}

/* Creating Custom Functional Interfaces */
@FunctionalInterface
interface Calculator {
  int calculate(int a, int b);
}

class CustomFunctionalInterface {
  public static void main(String[] args) {
    Calculator addition = (a, b) -> a + b;
    Calculator subtraction = (a, b) -> a - b;
    System.out.println(addition.calculate(10, 5)); // 15
    System.out.println(subtraction.calculate(10, 5)); // 5
  }
}