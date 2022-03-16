package piece;

public class Rook extends Piece {

    public Rook(boolean isBlack) {
        super(isBlack, 
            MoveSet.VERTICAL, MoveSet.SIDEWAYS
        );
    }
    
}
