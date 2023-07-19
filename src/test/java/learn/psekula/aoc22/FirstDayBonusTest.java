package learn.psekula.aoc22;

import learn.psekula.aoc22.solution.FirstDay;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FirstDayBonusTest {

    private FirstDay firstDay;

    @BeforeEach
    public void setup() {
        firstDay = new FirstDay();
    }

    @Test
    void whenEmptyList_thenReturnListWith0() {
        final var calories = firstDay.findBiggestThree(List.of());

        assertEquals(List.of(0), calories);
    }

    @Test
    void whenListWithOneElement_thenReturnListWithOneElf() {
        final var calories = firstDay.findBiggestThree(List.of("12"));

        assertEquals(List.of(12), calories);
    }

    @Test
    void whenListWithOneElf_thenReturnListWithSumOfOneElfsElements() {
        final var calories = firstDay.findBiggestThree(List.of("12", "13"));

        assertEquals(List.of(25), calories);
    }

    @Test
    void whenListWithTwoElfes_thenReturnListSumsSorted() {
        final var calories = firstDay.findBiggestThree(List.of("12", "13", "", "14", "15"));

        assertEquals(List.of(29, 25), calories);
    }

    @Test
    void whenListWithFourElfes_thenReturnListSumOfBiggestThree() {
        final var calories = firstDay.findBiggestThree(List.of("11", "", "20", "10", "", "12", "13", "", "14", "15"));

        assertEquals(List.of(30, 29, 25), calories);
    }
}