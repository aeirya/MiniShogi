package piece;

public class Rook extends Piece {

    public Rook(boolean isBlack) {
        super(
            new PieceFactory()
                .color(isBlack)
                .orRule(MoveSet.VERTICAL)
                .orRule(MoveSet.SIDEWAYS)
                .build()
        );
    }
    
}
