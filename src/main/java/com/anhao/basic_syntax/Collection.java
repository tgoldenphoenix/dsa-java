package com.anhao.basic_syntax;

import java.util.ArrayList;
import java.util.HashMap;

public class Collection {
  public static void main(String[] args) {
    ArrayList<String> people = new ArrayList<>();
    people.add("anhao");
    people.remove("anhao");

    // Map
    HashMap<String, Integer> populationByCity = new HashMap<>();
    populationByCity.put("New York", 230000);
    populationByCity.put("Ben Tre", 20000);
  }
}
