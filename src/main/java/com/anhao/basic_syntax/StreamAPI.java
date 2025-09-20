package com.anhao.basic_syntax;

import java.util.List;

/**
 * src: https://www.youtube.com/watch?v=2StXP1XaU04
 */

public class StreamAPI {

  record Car(String type, String make, String model, Integer engineCapacity) {};

  public static void main(String[] args) {
    List<Car> cars = List.of(
      new Car("sedan", "BMW", "530", 1998),
      new Car("sedan", "Audi", "A5", 1998),
      new Car("sedan", "Mercedes", "E-Class", 2500),
      new Car("hatchback", "Skoda", "Octavia", 1600)
    );

    List<Car> sedanCars = cars.stream().filter(
      car -> car.type.equals("sedan")
    ).toList();

    int a = 10;
    int b = 15;
    System.out.println(a==b);

    int c = 10;
    System.out.println(a==c);
//    assertTrue(a == c);

    int d = a;
    System.out.println(a==d);
//    assertTrue(a == d);
  }
}
