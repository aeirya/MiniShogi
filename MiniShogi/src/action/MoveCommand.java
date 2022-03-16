package action;

import board.Board;
import board.Grid;

public class MoveCommand {
    public final char piece;
    public final Grid from;
    public final Grid to;

    public MoveCommand(char piece, Grid from, Grid to) {
        this.piece = piece;
        this.from = from;
        this.to = to;
    }

    public boolean play(Board board, boolean isBlack) {
        if (from.equals(-1, -1)) 
            return board.drop(piece, to, isBlack);
        return board.play(this, isBlack);
    }
}
