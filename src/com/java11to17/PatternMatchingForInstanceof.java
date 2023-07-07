package com.java11to17;

public class PatternMatchingForInstanceof {

    private static void oldStyle() {
        Object o = new GrapeClass("BLUE", 2);
        if (o instanceof GrapeClass) {
            GrapeClass grape = (GrapeClass) o;
            System.out.println("This grape has " + grape.num() + " pits.");
        }
    }


    //no need for downcast
    private static void patternMatching() {
        Object o = new GrapeClass("BLUE", 2);
        if (o instanceof GrapeClass grape) {
            System.out.println("This grape has " + grape.num() + " pits.");
        }
    }


    record GrapeClass(String color, int num) {
    }


}
