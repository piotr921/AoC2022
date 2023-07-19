package learn.psekula.aoc22.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class InputFileReader {

    public List<String> loadFileContent(String filePath) {
        final var path = Path.of(filePath);
        try {
            return Files.readAllLines(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
