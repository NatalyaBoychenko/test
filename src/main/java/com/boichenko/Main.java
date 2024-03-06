package com.boichenko;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        File file = new File("src/10m.txt");

        List<Integer> integerList = readData(file);

        int max = integerList.stream()
                .mapToInt(v -> v)
                .max()
                .orElseThrow();

        System.out.println("max = " + max);

        int min = integerList.stream()
                .mapToInt(v -> v)
                .min()
                .orElseThrow();

        System.out.println("min = " + min);

        int size = integerList.size();
        if (size % 2 == 0){
            int leftNumber = size / 2 - 1;
            int rightNumber = size / 2 ;
            double mediana =  ((integerList.get(leftNumber) + integerList.get(rightNumber)) * 0.5);
            System.out.println("mediana = " + mediana);
        } else {
            int mediana = size / 2;
            System.out.println("mediana = " + integerList.get(mediana));
        }

        double average = integerList.stream()
                .mapToInt(v -> v)
                .summaryStatistics()
                .getAverage();

        System.out.println("average = " + average);

        List<Integer> longestSequence = longestIncreasedSequence(integerList);
        System.out.println("longestSequence = " + longestSequence);

        List<Integer> longestDecreased = longestDecreasedSequence(integerList);
        System.out.println("longestDecreased = " + longestDecreased);


    }

    public static List<Integer> readData(File file){
        List<Integer> data= new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line = bufferedReader.readLine();
            while (line != null){
                data.add(Integer.valueOf(line));
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return data;
    }

    public static List<Integer> longestIncreasedSequence(List<Integer> intList){

        List<Integer> longestSequence = new ArrayList<>();
        List<Integer> currentSequence = new ArrayList<>();

        for (int i = 0; i < intList.size(); i++) {
            int currentNumber = intList.get(i);
            int nextNumber = 0;

            if (i != intList.size() - 1){
                nextNumber = intList.get(i+1);
            }

            currentSequence.add(currentNumber);
            if (currentNumber >= nextNumber || i == (intList.size() - 1)){
                if (currentSequence.size() > longestSequence.size()){
                    longestSequence.clear();
                    longestSequence.addAll(currentSequence);
                }
                currentSequence.clear();
            }
        }

        return longestSequence;
    }

    public static List<Integer> longestDecreasedSequence(List<Integer> intList){

        List<Integer> longestSequence = new ArrayList<>();
        List<Integer> currentSequence = new ArrayList<>();

        for (int i = 0; i < intList.size(); i++) {

            int currentNumber = intList.get(i);
            int nextNumber= 0;

            if (i != intList.size() - 1){
                nextNumber = intList.get(i+1);
            }

            currentSequence.add(currentNumber);
            if(currentNumber <= nextNumber || i == (intList.size() -1)){
                if (currentSequence.size() >= longestSequence.size()){
                    longestSequence.clear();
                    longestSequence.addAll(currentSequence);
                }
                currentSequence.clear();
            }
        }

        return longestSequence;
    }
}