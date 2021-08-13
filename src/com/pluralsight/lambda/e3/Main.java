package com.pluralsight.lambda.e3;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Person p1 = new Person("Vivek", "Gupta", 27);
        Person p2 = new Person("Manohar", "Gupta", 23);
        Person p3 = new Person("Dooby", "Gupta", 26);
        Person p4 = new Person("Roohi", "Gupta", 34);
        Person p5 = new Person("Gogi", "Gupta", 40);
        Person p6 = new Person("Somitra", "Gupta", 65);

        City mumbai = new City("Mumbai");
        City delhi = new City("Delhi");
        City lucknow = new City("Lucknow");
        ;

        List<Person> personList = new ArrayList<>(Arrays.asList(p1, p2, p3, p4, p5, p6));

        personList.removeIf(person -> person.getAge() < 25);

        personList.replaceAll(person -> new Person(person.getFirstName().toUpperCase(), person.getLastName().toUpperCase(), person.getAge()));

        personList.sort(Comparator.comparing(Person::getAge).reversed());

        personList.forEach(System.out::println);

        Map<City, List<Person>> map1 = new HashMap<>();

        map1.putIfAbsent(mumbai, new ArrayList<>());
        map1.get(mumbai).add(p1);

        map1.computeIfAbsent(delhi, city -> new ArrayList<>()).add(p2);
        map1.computeIfAbsent(delhi, city -> new ArrayList<>()).add(p3);

        System.out.println("Map1: ");
        map1.forEach((city, people1) -> System.out.println("city: " + city.getName() + " personList: " + people1));

        Map<City, List<Person>> map2 = new HashMap<>();
        map2.computeIfAbsent(delhi, city -> new ArrayList<>()).add(p4);
        map2.computeIfAbsent(lucknow, city -> new ArrayList<>()).add(p5);
        map2.computeIfAbsent(lucknow, city -> new ArrayList<>()).add(p6);

        System.out.println("Map2: ");
        map2.forEach((city, people1) -> System.out.println("city: " + city.getName() + " personList: " + people1));

        map2.forEach(
                (city, people) ->
                        map1.merge(
                                city, people,
                                (people1, people2) -> {
                                    people1.addAll(people2);
                                    return people1;
                                }
                        )
        );

        System.out.println("Map3: ");
        map1.forEach((city, people1) -> System.out.println("city: " + city.getName() + " personList: " + people1));

    }
}
