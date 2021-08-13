package com.pluralsight.lambda.e2;

@FunctionalInterface
public interface Predicate<T> {
    boolean test(T t);

    default Predicate<T> and(Predicate<T> other){
        return t -> test(t) && other.test(t);
    }

    default Predicate<T> or(Predicate<T> p2) {
        return t -> test(t) || p2.test(t);
    }
}
