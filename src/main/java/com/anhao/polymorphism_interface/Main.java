package com.anhao.polymorphism_interface;

// Define an interface for shapes
interface Shape {
  double calculateArea();
  void draw();
}

// Implement the Shape interface in a Circle class
class Circle implements Shape {
  private double radius;

  public Circle(double radius) {
    this.radius = radius;
  }

  @Override
  public double calculateArea() {
    return Math.PI * radius * radius;
  }

  @Override
  public void draw() {
    System.out.println("Drawing a Circle with radius: " + radius);
  }
}

// Implement the Shape interface in a Rectangle class
class Rectangle implements Shape {
  private double width;
  private double height;

  public Rectangle(double width, double height) {
    this.width = width;
    this.height = height;
  }

  @Override
  public double calculateArea() {
    return width * height;
  }

  @Override
  public void draw() {
    System.out.println("Drawing a Rectangle with width: " + width + " and height: " + height);
  }
}

public class Main {
  public static void main(String[] args) {
    // Create objects of different classes that implement the Shape interface
    Shape circle = new Circle(5.0);
    Shape rectangle = new Rectangle(4.0, 6.0);

    // Use polymorphism: a single interface reference 'Shape' can refer to
    // objects of different concrete classes (Circle and Rectangle)
    processShape(circle);
    processShape(rectangle);
  }

  // A method that accepts the interface type, demonstrating polymorphism
  public static void processShape(Shape shape) {
    System.out.println("Calculating area...");
    System.out.println("Area: " + shape.calculateArea());
    shape.draw(); // The correct 'draw' method is invoked based on the actual object type
    System.out.println("---");
  }
}
