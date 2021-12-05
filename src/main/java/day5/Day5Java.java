package day5;

import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day5Java {
    public Day5Java(String filepath) {
        try {
            day5a(filepath);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    private void day5a(String filepath) throws IOException {
//        var testData = """
//                0,9 -> 5,9
//                8,0 -> 0,8
//                9,4 -> 3,4
//                2,2 -> 2,1
//                7,0 -> 7,4
//                6,4 -> 2,0
//                0,9 -> 2,9
//                3,4 -> 1,4
//                0,0 -> 8,8
//                5,5 -> 8,2
//                """;
        var input = Files.readAllLines(Path.of(filepath));
//        var input = testData.split("\n");
        List<Line> lines = new ArrayList<>();
        input.forEach(l -> {
            var split = l.split("->");
            var l1 = split[0].trim().split(",");
            var l2 = split[1].trim().split(",");
            var x1 = Integer.parseInt(l1[0]);
            var y1 = Integer.parseInt(l1[1]);
            var x2 = Integer.parseInt(l2[0]);
            var y2 = Integer.parseInt(l2[1]);
            if(x1 == x2 || y1 == y2) {
                lines.add(new Line(x1, y1, x2, y2));
            }
        });

//        Arrays.stream(input).forEach(l -> {
//            var split = l.split("->");
//            var l1 = split[0].trim().split(",");
//            var l2 = split[1].trim().split(",");
//            lines.add(new Line(Integer.parseInt(l1[0]), Integer.parseInt(l1[1]), Integer.parseInt(l2[0]), Integer.parseInt(l2[1])));
//        });

        var intersections = 0;
        for(int i = 0; i < lines.size(); i++) {
            for(int j = 0; j < lines.size(); j++) {
                if(i == j) {
                    continue;
                }
                if(lines.get(i).intersects(lines.get(j))) {
                    System.out.println("Intersection between " + lines.get(i) + " and " + lines.get(j));
                    intersections++;
                }
            }
        }
        System.out.println(intersections);
    }

    class Line {
        int x1, y1, x2, y2;
        public Line(int x1, int y1, int x2, int y2) {
            // Ensure x1 and y1 are is always the smallest values
            if(x1 > x2) {
                this.x1 = x2;
                this.x2 = x1;
            } else {
                this.x1 = x1;
                this.x2 = x2;
            }
            if(y1 > y2) {
                this.y1 = y2;
                this.y2 = y1;
            } else {
                this.y1 = y1;
                this.y2 = y2;
            }
        }

        public boolean intersects(Line other) {
//            return ((x1 <= other.x1 && x1 <= other.x2) && (x2 >= other.x1 && x2 >= other.x2) && (y1 >= other.y1 && y1 <= other.y2) && (y2 >= other.y1 && y2 <= other.y2))
//                    || (y1 == other.y1 && y2 == other.y2) || (x1 == other.x1 && x2 == other.x2);
            return ();
        }

        @Override
        public String toString() {
            return String.format("%s:%s", new Point(x1, y1), new Point(x2, y2));
        }
    }
}
