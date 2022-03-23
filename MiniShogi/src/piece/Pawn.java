package piece;

import java.util.List;

public class Pawn extends Piece {

    public Pawn(boolean isBlack) {
        super(
            new PieceFactory()
                .color(isBlack)
                .upgrade(new Gold(isBlack))
                .orRule(MoveSet.VERTICAL)
                .andRule(MoveSet.ONLY_FORWARD)
                .andRule(MoveSet.SHORT_RANGED)
                .build()
        );
    }

    
}
