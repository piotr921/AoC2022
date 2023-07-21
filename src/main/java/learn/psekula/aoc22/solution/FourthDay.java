package learn.psekula.aoc22.solution;

import java.util.List;

public class FourthDay {

    private final RangeInterpreter rangeInterpreter;

    public FourthDay(RangeInterpreter rangeInterpreter) {
        this.rangeInterpreter = rangeInterpreter;
    }

    public int calculate(List<String> data) {
        int counter = 0;
        for (String s : data) {
            if (containsFullyOtherRange(s)) {
                counter += 1;
            }
        }
        return counter;
    }

    public int calculate2(List<String> data) {
        int counter = 0;
        for (String s : data) {
            if (containsAnyElementOfOtherRange(s)) {
                counter += 1;
            }
        }
        return counter;
    }

    public boolean containsFullyOtherRange(String line) {
        final var ranges = rangeInterpreter.formatLine(line);
        final var firstElfRange = rangeInterpreter.format(ranges.get(0));
        final var secondElfRange = rangeInterpreter.format(ranges.get(1));
        return firstElfRange.containsAll(secondElfRange) || secondElfRange.containsAll(firstElfRange);
    }

    public boolean containsAnyElementOfOtherRange(String line) {
        final var ranges = rangeInterpreter.formatLine(line);
        final var firstElfRange = rangeInterpreter.formatToList(ranges.get(0));
        final var secondElfRange = rangeInterpreter.formatToList(ranges.get(1));

        final boolean firstEndsAfterSecondStarts = firstElfRange.get(firstElfRange.size() - 1) >= secondElfRange.get(0);
        final boolean firstStartsBeforeSecondEnds = firstElfRange.get(0) <= secondElfRange.get(secondElfRange.size() - 1);
        return firstEndsAfterSecondStarts && firstStartsBeforeSecondEnds;
    }
}
