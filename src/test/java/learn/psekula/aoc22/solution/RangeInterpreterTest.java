package learn.psekula.aoc22.solution;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

class RangeInterpreterTest {

    private RangeInterpreter rangeInterpreter;

    @BeforeEach
    void setup() {
        rangeInterpreter = new RangeInterpreter();
    }

    @Test
    void shouldFormatOneNumberRangeToSetWithOneElement() {
        Set<Integer> result = rangeInterpreter.format("6-6");
        Assertions.assertEquals(Set.of(6), result);
    }

    @Test
    void shouldFormatManyNumberRangeToSet() {
        Set<Integer> result = rangeInterpreter.format("2-6");
        Assertions.assertEquals(Set.of(2, 3, 4, 5, 6), result);
    }

    @Test
    void shouldFormatInputLineIntoTwoRanges() {
        List<String> result = rangeInterpreter.formatLine("54-59,17-62");
        Assertions.assertEquals(List.of("54-59", "17-62"), result);
    }

}