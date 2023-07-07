package com.training;

import java.util.ArrayList;
import java.util.List;

public class MinDIgitProd {

    public static void main(String[] args) {
        System.out.println(brokenDown(new ArrayList<>(), 12));
    }
     static private int brokenDown(List<Integer> existing, int p) {
        if (p < 10) {
            existing.add(p);
            int result = 0;
            for (int j = 0; j < existing.size(); j++) {
                result += existing.get(j) * Math.pow(10, j);
            }
            return result;
        }
        for (int i = 9; i > 2; i--) {
            if (p % i == 0) {
                existing.add( i);
                return brokenDown(existing, p/i);
            }
        }
        return -1;
    }

}
