package learn.psekula.aoc22.solution;

import java.util.List;
import java.util.stream.Stream;

public class Utils {

    public static Stream<String> convertToStreamOfChars(List<String> data) {
        StringBuilder sb = new StringBuilder();
        for (String s : data) {
            sb.append(s);
        }
        return sb.toString().codePoints().mapToObj(c -> String.valueOf((char) c));
    }
}
