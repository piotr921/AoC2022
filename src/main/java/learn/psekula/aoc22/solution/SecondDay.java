package learn.psekula.aoc22.solution;

import java.util.List;

public class SecondDay {
    public int calculate(List<String> data) {
        int score = 0;
        for (String game : data) {
            final var shapes = translate(game);
            int gameScore = shapes.get(0).scoreAgainst(shapes.get(1));
            int pointForShape = shapes.get(1).getPoints();
            score = score + gameScore + pointForShape;
        }
        return score;
    }

    public int calculate2(List<String> data) {
        int score = 0;
        for (String game : data) {
            final var split = game.trim().split("\\s+");
            final var rivalShape = Shape.from(split[0]);
            final var expectedResult = ExpectedResult.from(split[1]);
            final var myShape = expectedResult.selectShapeToAchieve(rivalShape);

            int gameScore = rivalShape.scoreAgainst(myShape);
            int pointForShape = myShape.getPoints();
            score = score + gameScore + pointForShape;
        }
        return score;
    }

    public List<Shape> translate(String game) {
        final var split = game.trim().split("\\s+");
        return List.of(Shape.from(split[0]), Shape.from(split[1]));
    }
}
