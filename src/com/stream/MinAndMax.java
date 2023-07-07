package com.stream;

import java.util.Comparator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MinAndMax {

    public static void main(String[] args) {
        Integer highest = Stream.of(1, 2, 3, 77, 6, 5)
                .max(Comparator.comparing(Integer::intValue))
                .get();

    }
}
