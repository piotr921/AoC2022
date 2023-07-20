package learn.psekula.aoc22.solution;

import java.util.Set;

public enum Shape {
    ROCK(Set.of("A", "X"), 1) {
        @Override
        public int scoreAgainst(Shape against) {
            switch (against) {
                case ROCK -> {
                    return 3;
                }
                case PAPER -> {
                    return 6;
                }
                case SCISSORS -> {
                    return 0;
                }
                default -> throw new RuntimeException("Unable to select score");
            }
        }
    },
    PAPER(Set.of("B", "Y"), 2) {
        @Override
        public int scoreAgainst(Shape against) {
            switch (against) {
                case ROCK -> {
                    return 0;
                }
                case PAPER -> {
                    return 3;
                }
                case SCISSORS -> {
                    return 6;
                }
                default -> throw new RuntimeException("Unable to select score");
            }
        }
    },
    SCISSORS(Set.of("C", "Z"), 3) {
        @Override
        public int scoreAgainst(Shape against) {
            switch (against) {
                case ROCK -> {
                    return 6;
                }
                case PAPER -> {
                    return 0;
                }
                case SCISSORS -> {
                    return 3;
                }
                default -> throw new RuntimeException("Unable to select score");
            }
        }
    };

    private final Set<String> codes;
    private final int points;

    Shape(Set<String> codes, int points) {
        this.codes = codes;
        this.points = points;
    }

    public Set<String> getCodes() {
        return codes;
    }

    public int getPoints() {
        return points;
    }

    public static Shape from(String symbol) {
        for (Shape shape : Shape.values()) {
            if (shape.getCodes().contains(symbol)) {
                return shape;
            }
        }
        throw new RuntimeException("Unknown symbol: " + symbol);
    }

    public abstract int scoreAgainst(Shape against);
}
