package learn.psekula.aoc22.solution;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RangeInterpreter {

    public List<String> formatLine(String line) {
        return Arrays.stream(line.split(",")).toList();
    }

    public Set<Integer> format(String range) {
        final var rangeBorders = range.split("-");
        return IntStream
                .rangeClosed(Integer.parseInt(rangeBorders[0]), Integer.parseInt(rangeBorders[1]))
                .boxed()
                .collect(Collectors.toSet());
    }

    public List<Integer> formatToList(String range) {
        final var rangeBorders = range.split("-");
        return IntStream
                .rangeClosed(Integer.parseInt(rangeBorders[0]), Integer.parseInt(rangeBorders[1]))
                .boxed()
                .collect(Collectors.toList());
    }
}
