package com.pluralsight.lambda.e2;

public class Main {
    public static void main(String[] args) {
        Predicate<String> p1 = s -> s.length() < 20;
        Predicate<String> p2 = s -> s.length() > 5;

        boolean test = p1.test("Hello World");
        System.out.println("result: " + test);

        Predicate<String> p3 = p1.and(p2);
        Predicate<String> p4 = p1.or(p2);
    }
}
