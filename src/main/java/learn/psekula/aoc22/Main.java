package learn.psekula.aoc22;

import learn.psekula.aoc22.io.InputFileReader;
import learn.psekula.aoc22.solution.FirstDay;
import learn.psekula.aoc22.solution.SecondDay;
import learn.psekula.aoc22.solution.ThirdDay;

public class Main {

    private final static String DAY_1 = "src/main/resources/day-1.txt";
    private final static String DAY_2 = "src/main/resources/day-2.txt";
    private final static String DAY_3 = "src/main/resources/day-3.txt";

    public static void main(String[] args) {
        System.out.println("Hello AoC 22");

        final var fileContent = new InputFileReader().loadFileContent(DAY_3);

        FirstDay firstDay = new FirstDay();
        SecondDay secondDay = new SecondDay();
        ThirdDay thirdDay = new ThirdDay();


        final var result = thirdDay.calculate(fileContent);
        final var result2 = thirdDay.calculate2(fileContent);

        // final var result = first.calculate(fileContent);
        // final var result2 = firstDay
        //         .findBiggestThree(fileContent)
        //         .stream()
        //         .reduce(Integer::sum)
        //         .orElse(-1);

        System.out.println("Result = " + result);
        System.out.println("Result 2 = " + result2);
    }
}