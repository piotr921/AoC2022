package learn.psekula.aoc22.io;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class InputFileReaderTest {

    @Test
    void shouldReadAllLines() {
        InputFileReader fileReader = new InputFileReader();
        final var allLines = fileReader.loadFileContent("src/test/resources/test-input.txt");

        Assertions.assertLinesMatch(List.of("12", "", "1", "13"), allLines);
    }
}