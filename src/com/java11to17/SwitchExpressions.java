package com.java11to17;

public class SwitchExpressions {

    //When we don't use any keyword explicitly, Java will set a default access to a given class
    //called package-private, which means that all members are visible within the same package
    String testAccessiblity;


    //every case needs a break;
    private static void oldStyleWithBreak(Fruit fruit) {
        switch (fruit) {
            case APPLE, PEAR:
                System.out.println("Common fruit");
                break;
            case ORANGE, AVOCADO:
                System.out.println("Exotic fruit");
                break;
            default:
                System.out.println("Undefined fruit");
        }
    }

    //Replace the colon (:) with an arrow (->) and ensure that an expression is used in the case.
    // No break is needed
    // A Switch Expression can also return a value.
    private static void withSwitchExpression(Fruit fruit) {
        String text = switch (fruit) {
            case APPLE, PEAR -> "Common fruit";
            case ORANGE, AVOCADO -> "Exotic fruit";
            default -> "Undefined fruit";
        };
        System.out.println(text);
    }


    enum Fruit {
        APPLE("1"),
        PEAR("2"),
        ORANGE("3"),

        AVOCADO("4");

        String id;


        Fruit(String id) {
            this.id = id;
        }

    }
}
