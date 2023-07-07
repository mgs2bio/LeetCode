package com.stream;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OccurenceOfEachChar {

    public static void main(String[] args) {
        String text = "sgfdgegerggweg";

        countOccurrence(text);
        findAllDuplicateElement(text);
        findFirstNonRepeatableElement(text);
        findSecondHighestNumber(new int[]{3, 1, 2, 3, 5, 1});
        findLongestStrFromArr(new String[]{"asdad", "sdfs", "sfsfsgsdgs"});
        findAllElementStartWithOne(new int[]{11, 0, 1, 21, 3});


        Map<String, Integer> map2 = new HashMap<>();
        map2.put("anil", 1000);
        map2.put("ankit", 1200);
        map2.put("bhavna", 1200);
        map2.put("james", 1200);
        map2.put("micael", 1000);
        map2.put("tom", 1300);
        map2.put("daniel", 1300);
        Map.Entry<Integer, List<String>> result = getNthHighestSalary(2, map2);
        System.out.println("second highest:" + result);
    }

    //count occurrence of each character in a string
    private static void countOccurrence(String text) {
        Map<String, Long> map = Arrays.asList(text.split(""))
                .stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(map);
    }

    private static void findAllDuplicateElement(String text) {
        Set<String> set = Arrays.asList(text.split(""))
                .stream()
                .filter(OccurenceOfEachChar.checkDuplicate())
                .collect(Collectors.toSet());
        System.out.println(set);
    }

    private static Predicate<String> checkDuplicate() {
        Set<String> set = new HashSet<>();
        return s -> !set.add(s);
    }

    // or use Linked Hashmap and return the first key with value = 1
    private static void findFirstNonRepeatableElement(String text) {
        Arrays.asList(text.split(""))
                .stream()
                .filter(Predicate.not(OccurenceOfEachChar.checkDuplicate()))
                .findFirst()
                .ifPresentOrElse(
                        (t) -> System.out.println(t),
                        () -> System.out.println("No result"));

    }

    private static void findSecondHighestNumber(int[] arr) {
        int secondHigh = IntStream.of(arr).boxed()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .get();

        System.out.println("Second Highest Num:" + secondHigh);

    }

    private static void findLongestStrFromArr(String[] arr) {
        String secondHigh = Arrays.asList(arr).stream()
                .sorted((str1, str2) -> str1.length() - str2.length())
                .skip(1)
                .findFirst()
                .get();

        Arrays.asList(arr).stream()
                .reduce((str1, str2) -> str1.length() >= str2.length() ? str1 : str2)
                .get();

        System.out.println("Second Highest Num:" + secondHigh);
    }

    private static void findAllElementStartWithOne(int[] arr) {
        List<String> ls = IntStream.of(arr).boxed()
                .map(String::valueOf)
                .filter(s -> s.startsWith("1"))
                .collect(Collectors.toList());

        System.out.println(ls);
    }

    public static Map.Entry<Integer, List<String>> getNthHighestSalary(int num, Map<String, Integer> map) {
        return map.entrySet().stream()
                .collect(Collectors.groupingBy(Map.Entry::getValue, Collectors.mapping(Map.Entry::getKey, Collectors.toList())))
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByKey()))
                .collect(Collectors.toList())
                .get(num - 1);
    }


}
