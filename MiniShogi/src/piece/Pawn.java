package piece;

import java.util.List;

public class Pawn extends Piece {

    public Pawn(boolean isBlack) {
        super(isBlack,
            new Gold(isBlack),
            List.of(MoveSet.ONLY_FORWARD, MoveSet.VERTICAL, MoveSet.SHORT_RANGED)
        );
    }

    
}
