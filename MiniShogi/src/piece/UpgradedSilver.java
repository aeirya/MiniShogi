package piece;

import board.Grid;

public class UpgradedSilver extends Piece {

    protected UpgradedSilver(boolean isBlack) {
        super(
            new PieceFactory()
                .color(isBlack)
                .build()
        );
    }

    @Override
    public boolean canGo(Grid from, Grid to, boolean isBlack) {
        return from.distance(to) <= 2 || (Math.abs(from.x-to.x) == 2 && Math.abs(from.y - to.y) == 2);
    }   
}
