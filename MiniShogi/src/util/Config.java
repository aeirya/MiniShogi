package util;

import java.util.Map;

import board.Grid;
import piece.Bishop;
import piece.Gold;
import piece.King;
import piece.Lance;
import piece.Pawn;
import piece.Piece;
import piece.Ranger;
import piece.Silver;

public class Config {
    private Config() {}

    public static final int WIDTH = 6;
    public static final int HEIGHT = 4;

    public static final Map<Grid, Piece> genMap(boolean isBlack, int endRow) {
        return Map.of(
            new Grid(0, isBlack?endRow:0), new King(isBlack),
            new Grid(1, isBlack?endRow:0), new Gold(isBlack),
            new Grid(2, isBlack?endRow:0), new Silver(isBlack),
            new Grid(3, isBlack?endRow:0), new Bishop(isBlack),
            new Grid(4, isBlack?endRow:0), new Ranger(isBlack),
            new Grid(5, isBlack?endRow:0), new Lance(isBlack),
            new Grid(0, isBlack?endRow-1:1), new Pawn(isBlack)
        );

    }

    public static final Map<Grid, Piece> WHITE_START = genMap(false, HEIGHT-1);
    public static final Map<Grid, Piece> BLACK_START = genMap(true, HEIGHT-1);

    
}
