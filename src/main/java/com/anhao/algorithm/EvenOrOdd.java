package com.anhao.algorithm;
import java.util.Scanner;

public class EvenOrOdd {
  public static String even_or_odd(int number) {
    return (number % 2) != 0 ? "Odd" : "Even";
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter your number: ");
    int num = scanner.nextInt();
    System.out.println(even_or_odd(num));

    //
    System.out.print("Enter your name: ");
    String name = scanner.nextLine();
    scanner.close();
  }
}
