package com.java11to17;

public class TextBlock {

    public static void main(String[] args) {
        oldStyle();
        newStyle();
    }

    private static void oldStyle() {
        String text = "{\n" +
                "  \"name\": \"John Doe\",\n" +
                "  \"age\": 45,\n" +
                "  \"address\": \"Doe Street, 23, Java Town\"\n" +
                "}";
        System.out.println(text);
    }

    //since java 15, Inside the text blocks, we can freely use newlines and quotes without the need for escaping line breaks.
    private static void newStyle() {
        String text = """
                {
                  "name": "John Doe",
                  "age": 45,
                  "address": "Doe Street, 23, Java Town"
                }
                """;
        System.out.println(text);
    }
}
