package piece;

public class Lance extends Piece {

    public Lance(boolean isBlack) {
        super(
            new PieceFactory()
                .color(isBlack)
                .orRule(MoveSet.VERTICAL)
                .andRule(MoveSet.ONLY_FORWARD)
                .upgrade(new Rook(isBlack))
                .build()
        );
    }
    
}
