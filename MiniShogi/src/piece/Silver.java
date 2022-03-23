package piece;

import board.Grid;

public class Silver extends Piece {

    public Silver(boolean isBlack) {
        super(
            new PieceFactory()
                .color(isBlack)
                .upgrade(new UpgradedSilver(isBlack))
                .orRule(MoveSet.ANY_DIR)
                .andRule(MoveSet.ONLY_FORWARD)
                .andRule(MoveSet.SHORT_RANGED)
                .build()
        );
    }

    @Override
    public boolean canGo(Grid from, Grid to, boolean isBlack) {
        return super.canGo(from, to, isBlack) || to.equals(from.next(-1, -1)) || to.equals(from.next(1, -1));
    }
    
}
