package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class Main {
    public static void main(String[] args) {

        Map<Integer, String> myMap = new HashMap<>();

        BiFunction<Integer, String, Map<Integer, String>> ex =
                (number, word) -> myMap;

        System.out.println("ex = " + ex);

    }
}