package learn.psekula.aoc22.io;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class InputFileReaderTest {

    @Test
    void shouldReadAllLines() {
        InputFileReader fileReader = new InputFileReader();
        final var allLines = fileReader.loadFileContent("src/test/resources/test-input-1.txt");

        Assertions.assertLinesMatch(List.of("12", "", "1", "13"), allLines);
    }

    @Test
    void shouldReadAllLinesFromTwoColumns() {
        InputFileReader fileReader = new InputFileReader();
        final var allLines = fileReader.loadFileContent("src/test/resources/test-input-2.txt");

        Assertions.assertLinesMatch(List.of("A Y", "B X", "C Z"), allLines);
    }

    @Test
    void shouldReadAllLinesFromRange() {
        InputFileReader fileReader = new InputFileReader();
        final var allLines = fileReader.loadFileContent("src/test/resources/test-input-4.txt");

        Assertions.assertLinesMatch(List.of("54-59,17-62", "20-93,57-92"), allLines);
    }
}