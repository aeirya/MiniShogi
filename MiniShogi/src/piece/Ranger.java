package piece;

public class Ranger extends Piece {

    public Ranger(boolean isBlack) {
        super(
            new PieceFactory()
                .color(isBlack)
                .orRule(MoveSet.ANY_DIR)
                .andRule(IRule.negate(MoveSet.SHORT_RANGED))
                .build()
        );
    }
}
