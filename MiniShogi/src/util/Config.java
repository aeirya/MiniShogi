package util;

import java.util.HashMap;
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

    public static final int WIDTH = 5;
    public static final int HEIGHT = 5;

    public static final Map<Grid, Piece> genMap(boolean isBlack, int endRow) {
        Map<Grid, Piece> map = new HashMap<>();
        map.put(new Grid(!isBlack?0:WIDTH-1-0, isBlack?endRow:0), new King(isBlack));
        map.put(new Grid(!isBlack?1:WIDTH-1-1, isBlack?endRow:0), new Gold(isBlack));
        map.put(new Grid(!isBlack?2:WIDTH-1-2, isBlack?endRow:0), new Silver(isBlack));
        map.put(new Grid(!isBlack?3:WIDTH-1-3, isBlack?endRow:0), new Bishop(isBlack));
        map.put(new Grid(!isBlack?4:WIDTH-1-4, isBlack?endRow:0), new Lance(isBlack));
        map.put(new Grid(!isBlack?0:WIDTH-1-0, isBlack?endRow-1:1), new Pawn(isBlack));
        return map;
    }

    public static final Map<Grid, Piece> WHITE_START = genMap(false, HEIGHT-1);
    public static final Map<Grid, Piece> BLACK_START = genMap(true, HEIGHT-1);
    
}
