package com.pluralsight.lambda.e1;

import java.util.function.Function;

@FunctionalInterface
public interface Comparator<T> {

    static <U> Comparator<U> comparing(Function<U, Comparable> func) {
        return (p1, p2) -> func.apply(p1).compareTo(func.apply(p2));
    }

    int compare(T t1, T t2);

    default Comparator<T> thenComparing(Comparator<T> cmp) {
        return (p1, p2) -> compare(p1, p2) == 0 ? cmp.compare(p1, p2) : compare(p1, p2) ;
    }

    default Comparator<T> thenComparing(Function<T, Comparable> func) {
        return thenComparing(comparing(func));
    }
}
