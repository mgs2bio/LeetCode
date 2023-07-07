package com.training;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ThreeSums {

    public static void main(String[] args) {
        int[] arr =  {4, -2, 3, -3, 0, 2, 1, -4};
         Integer[] a =  IntStream.of(arr).boxed().sorted((i, j) ->  j -i).toArray(Integer[]::new);
        Arrays.sort(a, (i, j) -> j -i );
        System.out.println(Arrays.toString(a));
       var res = threeSum(arr);
        System.out.println(res);
        int i =0, j =0;
        System.out.println("12314".split(""));
        List<String> strLs = List.of("ada", "sds", "eg");
        System.out.println(strLs.stream().collect(Collectors.joining()));
        System.out.println(String.join("-", "yrd", "sdfs"));

        Stack<String> sk = new Stack<>() {
            {
                add("one");
                add("two");
                add("three");
            }
        };
        while (!sk.isEmpty()) {
            System.out.println(sk.pop());
        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        //Arrays.sort(nums);
        int i = 0, j = 0, n = nums.length, k = n - 1;
        if (k < 2 || nums[k] < 0) {
            return res;
        }
        while (i < n - 2) {
            if (nums[i] > 0) {
                break;
            }
            int remain = - nums[i];
            j = i + 1;
            while (j < k && nums[j] + nums[k] < remain) j++;
            while (j < k && nums[j] + nums [k] > remain) k--;
            if (nums[j] + nums[k] == remain) {
                res.add(List.of(i, j, k));
            }
            k = n-1;
            i ++;
        }
        return res;
    }

}
