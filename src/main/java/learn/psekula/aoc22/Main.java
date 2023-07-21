package learn.psekula.aoc22;

import learn.psekula.aoc22.io.InputFileReader;
import learn.psekula.aoc22.solution.*;

public class Main {

    private final static String DAY_1 = "src/main/resources/day-1.txt";
    private final static String DAY_2 = "src/main/resources/day-2.txt";
    private final static String DAY_3 = "src/main/resources/day-3.txt";
    private final static String DAY_4 = "src/main/resources/day-4.txt";

    public static void main(String[] args) {
        System.out.println("Hello AoC 22");

        final var fileContent = new InputFileReader().loadFileContent(DAY_4);

        FirstDay firstDay = new FirstDay();
        SecondDay secondDay = new SecondDay();
        ThirdDay thirdDay = new ThirdDay();
        FourthDay fourthDay = new FourthDay(new RangeInterpreter());


        // final var result = fourthDay.calculate(fileContent);
        final var result2 = fourthDay.calculate2(fileContent);

        // System.out.println("Result = " + result);
        // 973 too high
        System.out.println("Result 2 = " + result2);
    }
}