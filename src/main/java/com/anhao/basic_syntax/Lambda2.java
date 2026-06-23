package com.anhao.basic_syntax;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/*
  - https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html
 */

class Person {

    public enum Sex {
        MALE, FEMALE
    }

    String name;
    LocalDate birthday;
    Sex gender;
    String emailAddress;

    public Person(String name, LocalDate birthday, Sex gender, String emailAddress) {
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.emailAddress = emailAddress;
    }

    public int getAge() {
        if (this.birthday == null) {
            return 0; // Guard clause to prevent NullPointerException
        }

        LocalDate today = LocalDate.now();
        return Period.between(this.birthday, today).getYears();
    }

    public String getEmailAddress() {
        return this.emailAddress;
    }

    public Sex getGender() {
        return this.gender;
    }

    public void printPerson() {
        System.out.println("Name: " + name + ", Gender: " + gender + ", Email: " + emailAddress);
    }

    public static List<Person> createRoster() {
        List<Person> roster = new ArrayList<>();

        // Creating and adding the first person
        Person person1 = new Person(
                "Alice Smith",
                LocalDate.of(1995, 5, 12),
                Sex.FEMALE,
                "alice.smith@example.com"
        );
        roster.add(person1);
        // Creating and adding the second person
        Person person2 = new Person(
                "Bob Jones",
                LocalDate.of(1992, 10, 24),
                Sex.MALE,
                "bob.jones@example.com"
        );
        roster.add(person2);
        //
        Person person3 = new Person(
                "born_2020",
                LocalDate.of(2020, 10, 24),
                Sex.MALE,
                "bob.jones@example.com"
        );
        roster.add(person3);
        //
        Person person4 = new Person(
                "born_2010",
                LocalDate.of(2010, 10, 24),
                Sex.MALE,
                "bob.jones@example.com"
        );
        roster.add(person4);
        //
        Person person5 = new Person(
                "born_2002",
                LocalDate.of(2002, 10, 24),
                Sex.MALE,
                "bob.jones@example.com"
        );
        roster.add(person5);

        return roster;
    }
}

public class Lambda2 {

    // Approach 1: Create Methods that Search for Persons that Match One characteristic
    public static void printPersonsOlderThan(List<Person> roster, int age) {
        for (Person p : roster) {
            if (p.getAge() >= age) {
                p.printPerson();
            }
        }
    }

    // Approach 2: Create More Generalized Search Methods
    public static void printPersonsWithinAgeRange(List<Person> roster, int low, int high) {
        for (Person p : roster) {
            if (low <= p.getAge() && p.getAge() < high) {
                p.printPerson();
            }
        }
    }

    // Approach 3: Specify Search Criteria Code in a Local Class
    // Approach 4: Specify Search Criteria Code in an Anonymous Class
    // Approach 5: Specify Search Criteria Code with a Lambda Expression
    @FunctionalInterface
    interface CheckPerson {
        // A functional interface contains only one abstract method
        boolean test(Person p);

        // may contain one or more default methods or static methods...
        // ...
    }
    public static void printPersons(List<Person> roster, CheckPerson tester) {
        for (Person p : roster) {
            if (tester.test(p)) {
                p.printPerson();
            }
        }
    }

    // Approach 6: Use a Standard Functional Interfaces with Lambda Expressions
    public static void printPersonsWithPredicate(List<Person> roster, Predicate<Person> tester) {
        for (Person p : roster) {
            if (tester.test(p)) {
                p.printPerson();
            }
        }
    }

    // Approach 7: Use Lambda Expressions Throughout Your Application
    public static void processPersons(
            List<Person> roster,
            Predicate<Person> tester,
            Consumer<Person> block) {
        for (Person p : roster) {
            if (tester.test(p)) {
                block.accept(p);
            }
        }
    }
    // Approach 7, second example
    public static void processPersonsWithFunction(
            List<Person> roster,
            Predicate<Person> tester,
            Function<Person, String> mapper,
            Consumer<String> block) {
        for (Person p : roster) {
            if (tester.test(p)) {
                String data = mapper.apply(p);
                block.accept(data);
            }
        }
    }

    // Approach 8: Use Generics More Extensively
    public static <X, Y> void processElements(
            Iterable<X> source,
            Predicate<X> tester,
            Function<X, Y> mapper,
            Consumer<Y> block) {
        for (X p : source) {
            if (tester.test(p)) {
                Y data = mapper.apply(p);
                block.accept(data);
            }
        }
    }

    public static void main(String[] args) {

        List<Person> roster = Person.createRoster();
        System.out.println("There are " + roster.size() + " persons in total:");
        for (Person p : roster) {
            p.printPerson();
        }
        System.out.println();

        // Approach 1: Create Methods that Search for Persons that Match One characteristic
        System.out.println("Persons older than 20:");
        printPersonsOlderThan(roster, 20);
        System.out.println();

        // Approach 2: Create More Generalized Search Methods
        System.out.println("Persons between the ages of 14 and 30:");
        printPersonsWithinAgeRange(roster, 14, 30);
        System.out.println();

        // Approach 3: Specify Search Criteria Code in a Local Class
        System.out.println("Persons who are eligible for Selective Service " + "(local class):");
        class CheckPersonEligibleForSelectiveService implements CheckPerson { // a local class
            @Override
            public boolean test(Person p) {
                return p.getGender() == Person.Sex.MALE
                        && p.getAge() >= 18
                        && p.getAge() <= 25;
            }
        }
        printPersons(roster, new CheckPersonEligibleForSelectiveService());
        System.out.println();

        // Approach 4: Specify Search Criteria Code in an Anonymous Class
        System.out.println("Persons who are eligible for Selective Service " + "(anonymous class):");
        printPersons(roster, new CheckPerson() { // an anonymous class
                @Override
                public boolean test(Person p) {
                    return p.getGender() == Person.Sex.MALE
                            && p.getAge() >= 18
                            && p.getAge() <= 25;
                }
            }
        );
        System.out.println();
        /* Approach 4 is better.
          However, the syntax of anonymous classes is bulky considering that the CheckPerson interface contains only one method.
          In this case, you can use a lambda expression instead of an anonymous class.
         */

        // Approach 5: Specify Search Criteria Code with a Lambda Expression
        System.out.println("Persons who are eligible for Selective Service " + "(lambda expression):");
        printPersons(roster, (Person p) -> p.getGender() == Person.Sex.MALE
            && p.getAge() >= 18
            && p.getAge() <= 25
        );
        System.out.println();

        /* You can use a standard functional interface in place of the interface CheckPerson,
          which reduces even further the amount of code required.
         */
        // Approach 6: Use Standard Functional Interfaces with Lambda Expressions
        System.out.println("Persons who are eligible for Selective Service " + "(with Predicate parameter):");
        printPersonsWithPredicate(roster, p -> p.getGender() == Person.Sex.MALE
            && p.getAge() >= 18
            && p.getAge() <= 25
        );
        System.out.println();

        // Approach 7: Use Lamba Expressions Throughout Your Application
        System.out.println("Persons who are eligible for Selective Service " + "(with Predicate and Consumer parameters):");
        processPersons(roster, p -> p.getGender() == Person.Sex.MALE
            && p.getAge() >= 18
            && p.getAge() <= 25,
    p -> p.printPerson()
        );
        System.out.println();

        // Approach 7, second example
        System.out.println("Persons who are eligible for Selective Service " + "(with Predicate, Function, and Consumer parameters):");
        processPersonsWithFunction(
                roster,
                p -> p.getGender() == Person.Sex.MALE
                        && p.getAge() >= 18
                        && p.getAge() <= 25,
                p -> p.getEmailAddress(),
                email -> System.out.println(email)
        );
        System.out.println();

        // Approach 8: Use Generics More Extensively
        System.out.println("Persons who are eligible for Selective Service " + "(generic version):");
        processElements(
                roster,
                p -> p.getGender() == Person.Sex.MALE
                        && p.getAge() >= 18
                        && p.getAge() <= 25,
                p -> p.getEmailAddress(),
                email -> System.out.println(email)
        );
        System.out.println();

        // Approach 9: Use Bulk Data Operations That Accept Lambda Expressions as Parameters
        System.out.println("Persons who are eligible for Selective Service " + "(with bulk data operations):");
        roster
            .stream()
            .filter(
                    p -> p.getGender() == Person.Sex.MALE
                            && p.getAge() >= 18
                            && p.getAge() <= 25)
            .map(p -> p.getEmailAddress())
            .forEach(email -> System.out.println(email));

    }
}
