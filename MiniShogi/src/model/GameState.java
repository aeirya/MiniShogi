package model;

import java.util.List;

import piece.Piece;

public class GameState {
    public final char[][] pieces;
    public final List<Character> blackHand;
    public final List<Character> whiteHand;

    public final int w;
    public final int h;
    public final boolean isFinished;
    public final boolean isBlackTurn;

    public GameState(Piece[][] pieces, List<Character> blackHand, List<Character> whiteHand, int w, int h, boolean isFinished, boolean isBlackTurn) {
        this.w = w;
        this.h = h;
        this.isFinished = isFinished;
        this.isBlackTurn = isBlackTurn;

        this.blackHand = blackHand;
        this.whiteHand = whiteHand;

        this.pieces = new char[pieces.length][pieces[0].length];

        for (int i=0; i < pieces.length; ++i) {
            for (int j=0; j < pieces.length; ++j) {
                if (pieces[i][j] != null)
                    this.pieces[i][j] = pieces[i][j].toString().charAt(0);
                else 
                    this.pieces[i][j] = 0;
            }
        }
    }
}
