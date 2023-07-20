package learn.psekula.aoc22;

import learn.psekula.aoc22.io.InputFileReader;
import learn.psekula.aoc22.solution.FirstDay;
import learn.psekula.aoc22.solution.SecondDay;

public class Main {

    private final static String DAY_1 = "src/main/resources/day-1.txt";
    private final static String DAY_2 = "src/main/resources/day-2.txt";

    public static void main(String[] args) {
        System.out.println("Hello AoC 22");

        final var fileContent = new InputFileReader().loadFileContent(DAY_2);

        FirstDay firstDay = new FirstDay();
        SecondDay secondDay = new SecondDay();


        final var result = secondDay.calculate(fileContent);
        final var result2 = secondDay.calculate2(fileContent);

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