package piece;

import board.Grid;

public class Gold extends Piece {

    public Gold(boolean isBlack) {
        super(
            new PieceFactory()
                .color(isBlack)
                .orRule(MoveSet.ANY_DIR)
                .andRule(MoveSet.SHORT_RANGED)
                .build()
        );
    }

    @Override
    public boolean canGo(Grid from, Grid to, boolean isBlack) {
        return super.canGo(from, to, isBlack)
            && ((!isBlack && !to.equals(from.next(-1, -1)) && !to.equals(from.next(1, -1)))
            || (isBlack && !to.equals(from.next(-1, 1)) && !to.equals(from.next(1, 1))));
            
    }
    
}
