package piece;

import java.util.List;

import board.Grid;

public class Silver extends Piece {

    public Silver(boolean isBlack) {
        super(
            isBlack,
            null,
            List.of(MoveSet.ANY_DIR),
            List.of(MoveSet.ONLY_FORWARD, MoveSet.SHORT_RANGED)
        );
    }

    @Override
    public boolean canGo(Grid from, Grid to, boolean isBlack) {
        return super.canGo(from, to, isBlack) || to.equals(from.next(-1, -1)) || to.equals(from.next(1, -1));
    }
    
}
