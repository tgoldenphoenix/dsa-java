package com.anhao.syntax;

class Animal {}
class Dog extends Animal {}
class Cat extends Animal {}

class InstanceofExample {
    public static void main(String[] args) {
        Animal myAnimal = new Dog();

        if (myAnimal instanceof Dog) {
            System.out.println("myAnimal is a Dog.");
            Dog myDog = (Dog) myAnimal; // Safe cast
        } else if (myAnimal instanceof Cat) {
            System.out.println("myAnimal is a Cat.");
        } else {
            System.out.println("myAnimal is just an Animal.");
        }

        // Pattern Matching for instanceof (Java 16+)
        if (myAnimal instanceof Dog d) {
            System.out.println("Pattern matched: myAnimal is a Dog, and now 'd' refers to it.");
            // You can use 'd' directly here, no explicit cast needed.
        }
    }
}