package com.java11to17;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamToList {

    private static void oldStyle() {
        Stream<String> stringStream = Stream.of("a", "b", "c");
        List<String> stringList = stringStream.collect(Collectors.toList());
        for (String s : stringList) {
            System.out.println(s);
        }
    }

    //convert to list without Collectors.toList().
    private static void streamToList() {
        Stream<String> stringStream = Stream.of("a", "b", "c");
        List<String> stringList = stringStream.toList();
        for (String s : stringList) {
            System.out.println(s);
        }
    }
}
