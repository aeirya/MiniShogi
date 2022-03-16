package piece;

public class Bishop extends Piece {

    public Bishop(boolean isBlack) {
        super(
            new PieceFactory()
                .color(isBlack)
                .orRule(MoveSet.DIAGONAL)
                .upgrade(new Ranger(isBlack))
                .build()
        );
    }

}
