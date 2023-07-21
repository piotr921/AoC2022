package learn.psekula.aoc22.solution;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FourthDayTest {

    private FourthDay fourthDay;

    @BeforeEach
    void setup() {
        fourthDay = new FourthDay(new RangeInterpreter());
    }

    @Test
    void whenRangesWithDifferentNumber_thenReturnFalse() {
        final var result = fourthDay.containsFullyOtherRange("6-6,2-2");
        assertFalse(result);
    }

    @Test
    void whenRangesWithTheNumber_thenReturnTrue() {
        final var result = fourthDay.containsFullyOtherRange("6-6,6-6");
        assertTrue(result);
    }

    @Test
    void whenRangesFirstRangeContainsSecond_thenReturnTrue() {
        final var result = fourthDay.containsFullyOtherRange("6-10,7-8");
        assertTrue(result);
    }

    @Test
    void whenRangesSecondRangeContainsFirst_thenReturnTrue() {
        final var result = fourthDay.containsFullyOtherRange("2-3,1-10");
        assertTrue(result);
    }

    @Test
    void givenTwoContainingRanges_shouldReturnTwo() {
        final var result = fourthDay.calculate(List.of("2-4,6-8", "2-3,4-5", "5-7,7-9", "2-8,3-7", "6-6,4-6", "2-6,4-8"));
        Assertions.assertEquals(2, result);
    }

    @Test
    void givenFourOverlappingRanges_shouldReturnFour() {
        final var result = fourthDay.calculate2(List.of("2-4,6-8", "2-3,4-5", "5-7,7-9", "2-8,3-7", "6-6,4-6", "2-6,4-8"));
        Assertions.assertEquals(4, result);
    }

    @Test
    void givenFourOverlappingRangesInReverseOrder_shouldReturnFour() {
        final var result = fourthDay.calculate2(List.of("6-8,2-4", "4-5,2-3", "7-9,5-7", "3-7,2-8", "4-6,6-6", "4-8,2-6"));
        Assertions.assertEquals(4, result);
    }
}