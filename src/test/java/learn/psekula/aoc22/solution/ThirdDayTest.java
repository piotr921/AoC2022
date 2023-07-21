package learn.psekula.aoc22.solution;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class ThirdDayTest {

    private ThirdDay thirdDay;

    @BeforeEach
    public void setup() {
        thirdDay = new ThirdDay();
    }

    @Test
    void givenOneCharString_returnsZero() {
        var result = thirdDay.findDuplicatedCharValue("p");
        Assertions.assertEquals(0, result);
    }

    @Test
    void givenTwoTheSameCharString_returnValue() {
        var result = thirdDay.findDuplicatedCharValue("pp");
        Assertions.assertEquals(16, result);
    }

    @Test
    void givenTwoTheSameUpperCaseCharString_returnValue() {
        var result = thirdDay.findDuplicatedCharValue("LL");
        Assertions.assertEquals(38, result);
    }

    @Test
    void givenFourCharString_returnValue() {
        var result = thirdDay.findDuplicatedCharValue("appb");
        Assertions.assertEquals(16, result);
    }

    @Test
    void givenComplexStringWithCapitalLetterDulicated_returnValue() {
        var result = thirdDay.findDuplicatedCharValue("PmmdzqPrVvPwwTWBwg");
        Assertions.assertEquals(42, result);
    }

    @Test
    void givenComplexStringWithSmallLetterDuplicated_returnValue() {
        var result = thirdDay.findDuplicatedCharValue("wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn");
        Assertions.assertEquals(22, result);
    }

    @Test
    void shouldFindCharOccurringInEachLine() {
        var result = thirdDay.findCharOccurringInEachLine(List.of("qa", "ab", "ca"));
        Assertions.assertEquals("a", result);
    }

    @Test
    void shouldFindCharOccurringInEachComplexLine() {
        var result = thirdDay.findCharOccurringInEachLine(List.of(
                "vJrwpWtwJgWrhcsFMMfFFhFp",
                "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL",
                "PmmdzqPrVvPwwTWBwg"));
        Assertions.assertEquals("r", result);
    }

    @Test
    void shouldCalculateCommonCharValue() {
        var result = thirdDay.calculate2(List.of(
                "vJrwpWtwJgWrhcsFMMfFFhFp",
                "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL",
                "PmmdzqPrVvPwwTWBwg",
                "wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn",
                "ttgJtRGJQctTZtZT",
                "CrZsJsPPZsGzwwsLwLmpwMDw"));
        Assertions.assertEquals(70, result);
    }
}