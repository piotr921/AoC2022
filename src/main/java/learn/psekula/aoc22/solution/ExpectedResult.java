package learn.psekula.aoc22.solution;

public enum ExpectedResult {
    LOSE("X") {
        @Override
        public Shape selectShapeToAchieve(Shape rivalShape) {
            switch (rivalShape) {
                case ROCK -> {
                    return Shape.SCISSORS;
                }
                case PAPER -> {
                    return Shape.ROCK;
                }
                case SCISSORS -> {
                    return Shape.PAPER;
                }
                default -> throw new RuntimeException("Unable to select shape");
            }
        }
    },
    DRAW("Y") {
        @Override
        public Shape selectShapeToAchieve(Shape rivalShape) {
            switch (rivalShape) {
                case ROCK -> {
                    return Shape.ROCK;
                }
                case PAPER -> {
                    return Shape.PAPER;
                }
                case SCISSORS -> {
                    return Shape.SCISSORS;
                }
                default -> throw new RuntimeException("Unable to select shape");
            }
        }
    },
    WIN("Z") {
        @Override
        public Shape selectShapeToAchieve(Shape rivalShape) {
            switch (rivalShape) {
                case ROCK -> {
                    return Shape.PAPER;
                }
                case PAPER -> {
                    return Shape.SCISSORS;
                }
                case SCISSORS -> {
                    return Shape.ROCK;
                }
                default -> throw new RuntimeException("Unable to select shape");
            }
        }
    };


    private final String code;

    ExpectedResult(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static ExpectedResult from(String symbol) {
        for (ExpectedResult er : ExpectedResult.values()) {
            if (er.getCode().contains(symbol)) {
                return er;
            }
        }
        throw new RuntimeException("Unknown symbol: " + symbol);
    }

    public abstract Shape selectShapeToAchieve(Shape rivalShape);
}
