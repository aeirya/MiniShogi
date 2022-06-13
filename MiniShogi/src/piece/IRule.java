package piece;

import board.Grid;

@FunctionalInterface
public interface IRule {
    boolean canGo(Grid from, Grid to, boolean isBlack);

    /* doesn't negate the color */
    static IRule negate(IRule rule) {
        return (from, to, isBlack) -> !rule.canGo(from, to, isBlack);
    }
}