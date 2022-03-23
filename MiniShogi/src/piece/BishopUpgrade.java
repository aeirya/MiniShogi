package piece;

import board.Grid;

public class BishopUpgrade extends Piece {

    public BishopUpgrade(boolean isBlack) {
        super(
            new PieceFactory()
                .color(isBlack)
                .orRule(MoveSet.DIAGONAL)
                .build()
        );
    }
    
    @Override
    public boolean canGo(Grid from, Grid to, boolean isBlack) {
        return super.canGo(from, to, isBlack) || (
            from.distance(to) <= 1
        );
    }
}
