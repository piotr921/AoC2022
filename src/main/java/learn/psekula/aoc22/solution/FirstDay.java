package learn.psekula.aoc22.solution;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class FirstDay {

    private static final int MAX_SIZE = 3;

    public int findBiggestSum(List<String> data) {
        int maxCalories = 0;
        int tempCalories = 0;

        for (String s : data) {
            if (isEmptyString(s)) {
                if (tempCalories > maxCalories) {
                    maxCalories = tempCalories;
                }
                tempCalories = 0;
            } else {
                int currentValue = Integer.parseInt(s);
                tempCalories += currentValue;
            }
        }

        return Math.max(maxCalories, tempCalories);
    }

    public List<Integer> findBiggestThree(List<String> data) {
        int currentSum = 0;
        List<Integer> sortedCaloriesSum = new ArrayList<>();
        List<String> dataWithEmptyStringAtTheEnd = Stream.concat(data.stream(), Stream.of("")).toList();

        for (String s : dataWithEmptyStringAtTheEnd) {
            if (isEmptyString(s)) {
                sortedCaloriesSum.add(currentSum);
                sortedCaloriesSum.sort(Comparator.reverseOrder());
                currentSum = 0;
            } else {
                currentSum += Integer.parseInt(s);
            }
        }
        return sortedCaloriesSum.subList(0, Math.min(sortedCaloriesSum.size(), MAX_SIZE));
    }


    private boolean isEmptyString(String s) {
        return Objects.equals(s, "");
    }
}