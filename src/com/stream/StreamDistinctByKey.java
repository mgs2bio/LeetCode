package com.stream;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamDistinctByKey {

    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        List<Person> personListFiltered = personList.stream()
                .filter(distinctByKey(Person::getName))
                .collect(Collectors.toList());
    }

    private static <T> Predicate<T> distinctByKey(Function<? super T, ?> func) {
        Map<Object, Boolean> seen = new HashMap<>();
        return t -> seen.putIfAbsent(func.apply(t), true) == null;
    }

    public class Person {
        private int age;

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        private String name;
        private String email;
        // standard getters and setters
    }
}
