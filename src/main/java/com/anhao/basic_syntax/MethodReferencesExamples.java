package com.anhao.basic_syntax;

import java.util.function.BiFunction;

/*
  - https://docs.oracle.com/javase/tutorial/java/javaOO/methodreferences.html
  - All the System.out.println() statements print the same thing: Hello World!
  - BiFunction is one of many functional interfaces in the java.util.function package.
  - The BiFunction functional interface can represent a lambda expression or method reference that accepts two arguments and produces a result.
 */

public class MethodReferencesExamples {

    public static <T> T mergeThings(T a, T b, BiFunction<T, T, T> merger) {
        return merger.apply(a, b);
    }

    public static String appendStrings(String a, String b) {
        return a + b;
    }

    // not static
    public String appendStrings2(String a, String b) {
        return a + b;
    }

    public static void main(String[] args) {

        MethodReferencesExamples myApp = new MethodReferencesExamples();

        // Calling the method mergeThings with a lambda expression
        System.out.println(MethodReferencesExamples.
                mergeThings("Hello ", "World!", (a, b) -> a + b));

        // Reference to a static method
        System.out.println(MethodReferencesExamples.
                mergeThings("Hello ", "World!", MethodReferencesExamples::appendStrings));

        // Reference to an instance method of a particular object
        System.out.println(MethodReferencesExamples.
                mergeThings("Hello ", "World!", myApp::appendStrings2));

        // Reference to an instance method of an arbitrary object of a
        // particular type
        System.out.println(MethodReferencesExamples.
                mergeThings("Hello ", "World!", String::concat));
    }
}