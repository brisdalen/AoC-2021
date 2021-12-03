package day3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day3Java {

    List<String> input;

    public Day3Java(String filepath) {
        try {
            input = Files.readAllLines(Paths.get(filepath))
                    .stream()
                    .toList();
        } catch (IOException e) {
            e.printStackTrace();
        }

//        day3a();
        day3b();
    }

    private void day3a() {
        int[] sums = new int[input.get(0).length()];

        for (String s : input) {
            var array = s.toCharArray();
            for (int i = 0; i < array.length; i++) {
                if (array[i] == '1') {
                    sums[i] += 1;
                }
            }
        }

        var gamma = new StringBuilder();
        var epsilon = new StringBuilder();

        for (int sum : sums) {
            if (sum >= input.size() / 2) {
                gamma.append(1);
                epsilon.append(0);
            } else {
                gamma.append(0);
                epsilon.append(1);
            }
        }

        var gammaInt = Integer.parseInt(gamma.toString(), 2);
        var epsilonInt = Integer.parseInt(epsilon.toString(), 2);

        System.out.println(gammaInt);
        System.out.println(epsilonInt);
        System.out.println(gammaInt * epsilonInt);
    }

    private void day3b() {
        int currentSum = 0;
        for (String s : input) {
            char curr = s.charAt(0);
            if(curr == '1') {
                currentSum += 1;
            }
        }

        List<String> temp = new ArrayList<>();
        for(int i = 0; i < input.size(); i++) {
            if(currentSum >= input.size() / 2) {
                if(input.get(i).charAt(0) == '1') {
                    temp.add(input.get(i));
                }
            } else {
                if(input.get(i).charAt(0) == '0') {
                    temp.add(input.get(i));
                }
            }
        }

        currentSum = 0;
        for (String s : input) {
            char curr = s.charAt(1);
            if(curr == '1') {
                currentSum += 1;
            }
        }

        temp.clear();
        for(int i = 0; i < input.size(); i++) {
            if(currentSum >= input.size() / 2) {
                if(input.get(i).charAt(1) == '1') {
                    temp.add(input.get(i));
                }
            } else {
                if(input.get(i).charAt(1) == '0') {
                    temp.add(input.get(i));
                }
            }
        }

        temp.forEach(System.out::println);
    }
}
