package com.anhao.basic_syntax;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Collection;
import java.util.function.Supplier;
import java.util.Set;
import java.util.HashSet;
import java.time.chrono.IsoChronology;

/*
  - https://docs.oracle.com/javase/tutorial/java/javaOO/methodreferences.html
  - The Person class is defined inside Lambda2.java in the same package
 */
public class MethodReferencesTest {

    // The method transferElements copies elements from one collection to another
    public static <T, SOURCE extends Collection<T>, DEST extends Collection<T>>
    DEST transferElements(
            SOURCE sourceCollection,
            Supplier<DEST> collectionFactory) {

        DEST result = collectionFactory.get();
        for (T t : sourceCollection) {
            result.add(t);
        }
        return result;
    }

    public static void main(String... args) {

        List<Person> roster = Person.createRoster();
        System.out.println("There are " + roster.size() + " persons in total:");
        for (Person p : roster) {
            p.printPerson();
        }
        System.out.println();

        Person[] rosterAsArray = roster.toArray(new Person[roster.size()]);

        class PersonAgeComparator implements Comparator<Person> {
            @Override
            public int compare(Person a, Person b) {
                return a.getBirthday().compareTo(b.getBirthday());
            }
        }

        // Without method reference
        // using a local class
        Arrays.sort(rosterAsArray, new PersonAgeComparator());

        // With lambda expression
        Arrays.sort(rosterAsArray, (Person a, Person b) -> {
                return a.getBirthday().compareTo(b.getBirthday());
            }
        );

        // This method already exists!
        Arrays.sort(rosterAsArray,
                (a, b) -> Person.compareByAge(a, b)
        );
        // Because this lambda expression invokes an existing method, you can use a method reference instead of a lambda expression
        Arrays.sort(rosterAsArray, Person::compareByAge); // Reference to a Static Method

        // Reference to an instance method of a particular object
        class ComparisonProvider {
            public int compareByName(Person a, Person b) {
                return a.getName().compareTo(b.getName());
            }

            public int compareByAge(Person a, Person b) {
                return a.getBirthday().compareTo(b.getBirthday());
            }
        }
        ComparisonProvider myComparisonProvider = new ComparisonProvider();
        Arrays.sort(rosterAsArray, myComparisonProvider::compareByName);

        // Reference to an instance method of an arbitrary object of a particular type
        String[] stringArray = { "Barbara", "James", "Mary", "John",
                "Patricia", "Robert", "Michael", "Linda" };
        Arrays.sort(stringArray, String::compareToIgnoreCase);

        // ====================================================
        Set<Person> rosterSetLambda =
                transferElements(roster, () -> { return new HashSet<>(); });
        // use a constructor reference in place of the lambda expression
        Set<Person> rosterSet = transferElements(roster, HashSet::new);
        // Alternatively, you can specify this as follows:
//        Set<Person> rosterSet = transferElements(roster, HashSet<Person>::new);
        System.out.println("Printing rosterSet:");
        rosterSet.stream().forEach(p -> p.printPerson());
    }
}