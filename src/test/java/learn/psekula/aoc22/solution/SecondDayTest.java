package learn.psekula.aoc22.solution;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class SecondDayTest {

    private SecondDay secondDay;

    @BeforeEach
    public void setup() {
        secondDay = new SecondDay();
    }

    @Test
    void givenEmptyList_thenReturnsZero() {
        int score = secondDay.calculate(List.of());
        Assertions.assertEquals(0, score);
    }

    @Test
    void givenInputLine_thenReturnsCorrectEnum() {
        final var translated = secondDay.translate("A Y");
        Assertions.assertEquals(List.of(Shape.ROCK, Shape.PAPER), translated);
    }

    @Test
    void givenOneGame_thenReturnsScore() {
        int score = secondDay.calculate(List.of("A Y"));
        Assertions.assertEquals(8, score);
    }

    @Test
    void givenThreeGames_thenReturnsScore() {
        int score = secondDay.calculate(List.of("A Y", "B X", "C Z"));
        Assertions.assertEquals(15, score);
    }

    @Test
    void givenOneGameWithExpectedResult_thenReturnsScore() {
        int score = secondDay.calculate2(List.of("A Y"));
        Assertions.assertEquals(4, score);
    }

    @Test
    void givenThreeGamesWithExpectedResult_thenReturnsScore() {
        int score = secondDay.calculate2(List.of("A Y", "B X", "C Z"));
        Assertions.assertEquals(12, score);
    }
}