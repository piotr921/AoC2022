package learn.psekula.aoc22.solution;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ThirdDay {

    public int calculate(List<String> data) {
        var result = 0;
        for (String s : data) {
            result += findDuplicatedCharValue(s);
        }
        return result;
    }

    public int calculate2(List<String> data) {
        var result = 0;
        for (int i = 2; i < data.size(); i = i + 3) {
            var teamValues = List.of(data.get(i), data.get(i - 1), data.get(i - 2));
            final var commonChar = findCharOccurringInEachLine(teamValues).toCharArray()[0];
            result = result + (commonChar - selectSubtractor(commonChar));
        }
        return result;
    }

    public String findCharOccurringInEachLine(List<String> lines) {
        return Utils.convertToStreamOfChars(lines)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(map -> map.getValue() > 2)
                .filter(map -> occursInEveryString(map.getKey(), lines))
                .findFirst()
                .map(Map.Entry::getKey)
                .orElseThrow(() -> new RuntimeException("Common char not found"));
    }

    private boolean occursInEveryString(String key, List<String> elfLines) {
        return elfLines.get(0).contains(key) && elfLines.get(1).contains(key) && elfLines.get(2).contains(key);
    }

    public int findDuplicatedCharValue(String input) {
        var halfIndex = input.length() / 2;
        final var first = input.substring(0, halfIndex).chars().toArray();
        final var second = input.substring(halfIndex).chars().toArray();


        // test Arrays.binarySearch
        var value = 0;
        var found = false;

        for (int i = 0; i < halfIndex; i++) {
            var charInFirst = first[i];
            for (int j = 0; j < halfIndex; j++) {
                var charInSecond = second[j];
                if (charInFirst == charInSecond) {
                    found = true;
                    value = charInFirst - selectSubtractor(charInFirst);
                    break;
                }
            }
            if (found) {
                break;
            }
        }

        return value;
    }

    private static int selectSubtractor(int charValue) {
        return Character.isUpperCase(charValue) ? 38 : 96;
    }
}
