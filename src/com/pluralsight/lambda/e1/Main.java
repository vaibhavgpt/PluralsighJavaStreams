package com.pluralsight.lambda.e1;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {

        Comparator<Person> cmpAge = (p1, p2) -> p1.getAge() - p2.getAge();
        Comparator<Person> cmpFirstName = (p1, p2) -> p1.getFirstName().compareTo(p2.getFirstName());

        Function<Person, Integer> f1 = Person::getAge;

        Comparator<Person> compareAge = Comparator.comparing(Person::getAge);
        Comparator<Person> compareFirstName = Comparator.comparing(Person::getFirstName);

        Comparator<Person> cmp = Comparator.comparing(Person::getAge)
                .thenComparing(Person::getFirstName)
                .thenComparing(Person::getLastName);

    }

}
