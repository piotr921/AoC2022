package learn.psekula.aoc22;

import learn.psekula.aoc22.solution.FirstDay;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FirstDayTest {

    private FirstDay firstDay;

    @BeforeEach
    public void setup() {
        firstDay = new FirstDay();
    }

    @Test
    void whenEmptyList_thenReturn0() {
        final var calories = firstDay.findBiggestSum(List.of());

        assertEquals(0, calories);
    }

    @Test
    void whenOneElementInList_thenReturnElement() {
        final var calories = firstDay.findBiggestSum(List.of("123"));

        assertEquals(123, calories);
    }

    @Test
    void whenTwoElementsInList_thenReturnSum() {
        final var calories = firstDay.findBiggestSum(List.of("1", "3"));

        assertEquals(4, calories);
    }

    @Test
    void whenSpaceInList_thenReturnHigherValue() {
        final var calories = firstDay.findBiggestSum(List.of("1", "3", "", "2", "4"));

        assertEquals(6, calories);
    }

    @Test
    void whenMultipleSpacesInList_thenReturnHigherValue() {
        final var calories = firstDay.findBiggestSum(List.of("18", "", "1", "3", "", "2", "4"));

        assertEquals(18, calories);
    }
}