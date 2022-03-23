package piece;

public class Bishop extends Piece {

    public Bishop(boolean isBlack) {
        super(
            new PieceFactory()
                .color(isBlack)
                .orRule(MoveSet.DIAGONAL)
                .andRule(MoveSet.ONLY_FORWARD)
                .upgrade(new BishopUpgrade(isBlack))
                .build()
        );
    }
}
