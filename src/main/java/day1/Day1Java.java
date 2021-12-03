package day1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.IntStream;

public class Day1Java {

    List<Integer> input;
    String path;

    public Day1Java(String filepath) {
        path = filepath;
        try {
            input = Files.readAllLines(Paths.get(filepath))
                    .stream()
                    .mapToInt(Integer::valueOf)
                    .boxed()
                    .toList();
        } catch (IOException e) {
            e.printStackTrace();
        }

        day1a();
        day1b();
    }

    private void day1a() {
        var numIncreased = (int) IntStream.range(1, input.size())
                .filter(i -> input.get(i) > input.get(i - 1))
                .count();
        System.out.println(numIncreased);
    }

    private void day1b() {
        var sumIncreased = (int) IntStream.range(1, input.size() - 2)
                .filter(i -> sum(i, input) > sum(i - 1, input))
                .count();
        System.out.println(sumIncreased);
    }

    private int sum(int i, List<Integer> input) {
        return input.get(i) + input.get(i + 1) + input.get(i + 2);
    }
}
