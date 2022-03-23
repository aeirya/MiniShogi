package piece;

import java.util.ArrayList;
import java.util.List;

import board.Board;
import board.Grid;

public enum MoveSet implements IRule {
    ONLY_FORWARD, DIAGONAL, VERTICAL, SIDEWAYS, SHORT_RANGED, ANY_DIR, BEHIND_DIAG;

    public boolean canGo(Grid from, Grid to, boolean isBlack) {
        if (from.equals(to)) return false;
        
        switch (this) {
            case ONLY_FORWARD:
                if (isBlack)
                    return (to.y < from.y);
                else
                    return (to.y > from.y);

            case VERTICAL:
                return (to.x == from.x);

            case DIAGONAL:
                return (to.x - to.y == from.x - from.y) || (to.x + to.y == from.x + from.y);

            case SIDEWAYS:
                return (to.y == from.y);

            case SHORT_RANGED:
                return Math.abs(to.x - from.x) <= 1 && Math.abs(to.y - from.y) <= 1;

            case ANY_DIR:
                return MoveSet.DIAGONAL.canGo(from, to, isBlack)
                 || MoveSet.SIDEWAYS.canGo(from, to, isBlack)
                 || MoveSet.VERTICAL.canGo(from, to, isBlack);
             
            case BEHIND_DIAG:
                return DIAGONAL.canGo(from, to, isBlack) && !ONLY_FORWARD.canGo(from, to, isBlack);
                
            default:
                return false;
            }
        }

        public boolean canGo(Grid from, Grid to, boolean isBlack, Board board) {
            if (!canGo(from, to, isBlack)) return false;
            if (this == SHORT_RANGED) return true;
            return from.to(to).allMatch(board::isFree);
        }

        public IRule negate() {
            return (from, to, isBlack) -> ! this.canGo(from, to, isBlack);
        }

        // public IRule and(IRule move) {
        //     if (move instanceof RuleSet) {
        //         ((RuleSet) move).add(move);
        //         return move;
        //     } else {
        //         return new RuleSet(List.of(this, move));
        //     }
        // }
        
        private static boolean canGo(Grid from, Grid to, boolean isBlack, List<MoveSet> movesets) {
            return movesets.stream().anyMatch(s -> s.canGo(from, to, isBlack));
        }



}
