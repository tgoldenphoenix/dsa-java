package com.anhao.basic_syntax;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * src: https://www.youtube.com/watch?v=2StXP1XaU04
 */

public class StreamAPI {

  record Car(String type, String make, String model, Integer engineCapacity) {};

  public static void main(String[] args) {
    // stream creation
//    String[] arr = new String[]{"a", "b", "c"};
//    Stream<String> stream = Arrays.stream(arr);
//    stream = Stream.of("a", "b", "c");

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

    List<String> list = new ArrayList<>();
    list.add("Goku");
    list.add("Krilin");
    list.add("Bulma");
    /* Iterating */
    for (String string : list) {
      if (string.contains("a")) {
        // return true;
        return;
      }
    }
    // using stream API
    boolean isExist = list.stream().anyMatch(element -> element.contains("a"));

    /* Filtering */
    ArrayList<String> list2 = new ArrayList<>();
    list2.add("One");
    list2.add("OneAndOnly");
    list2.add("Derek");
    list2.add("Change");
    list2.add("factory");
    list2.add("justBefore");
    list2.add("Italy");
    list2.add("Italy");
    list2.add("Thursday");
    list2.add("");
    list2.add("");
    // The following code creates a Stream<String> of the List<String>,
    // finds all elements of this stream which contain char “d”,
    // and creates a new stream containing only the filtered elements
    Stream<String> stream = list2.stream().filter(element -> element.contains("d"));

    /* Mapping */
  }
}
