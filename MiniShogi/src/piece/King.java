package piece;

public class King extends Piece {

    public King(boolean isBlack) {
        super(
            new PieceFactory()
                .color(isBlack)
                .orRule(MoveSet.ANY_DIR)
                .andRule(MoveSet.SHORT_RANGED)
                .build()
        );
    }
}
