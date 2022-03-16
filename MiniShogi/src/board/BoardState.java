package board;

import java.io.PrintStream;

import action.MoveCommand;
import piece.King;
import piece.Pawn;
import piece.Piece;
import player.Player;

public class BoardState {
    private final Piece[][] pieces;
    private final int w;
    private final int h;

    private final Player white;
    private final Player black;

    /**
     * @param w width
     * @param h height
     */
    public BoardState(int w, int h) {
        pieces= new Piece[w][h];
        this.w = w;
        this.h = h;

        white = new Player(false);
        black = new Player(true);
    }

    public void set(int x, int y, Piece piece) {
        if (x >= w || y >= h) 
            System.out.println("invalid coordinates");
        else
            pieces[x][y] = piece;
    }

    public void set(Grid grid, Piece piece) {
        set(grid.x, grid.y, piece);
    }

    public boolean play(MoveCommand command, boolean isBlack) {
        Piece toHit = get(command.to);
        if (toHit != null && toHit.isBlack() == isBlack) return false;
        Piece piece = get(command.from);
        if (piece == null || !piece.isEqual(command.piece)) return false;
        return play(command.from, command.to, piece,
            isBlack ? black : white
        );
    }

    private boolean isFree(Grid g) {
        return get(g) == null;
    }
    
    private boolean play(Grid from, Grid to, Piece piece, Player player) {
        if (!piece.canGo(from, to, player.isBlack)) return false;
        if (!from.to(to).allMatch(this::isFree)) return false;
        
        // check for capture
        var toHit = get(to);
        if (toHit != null) {
            toHit.capture();
            player.addHand(toHit);
        }

        set(to, piece);
        set(from, null);

        // check for upgrade
        if (
            (piece.isBlack() && to.y <= 1) ||
            (!piece.isBlack() && to.y >= getLastRow()-1)
        ) {
            piece.upgrade();
        }
        
        return true;
    }

    /* do not check grid */
    public boolean drop(char p, Grid grid, boolean isBlack) {
        var piece = isBlack ? black.drop(p) : white.drop(p);
        if (piece == null) return false;
        set(grid, piece);
        return true;
    }

    public Piece get(int x, int y) {
        return pieces[x][y]; 
    }

    public Piece get(Grid grid) {
        return pieces[grid.x][grid.y];
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(w*h);

        for (int i=0; i<w; ++i) {
            for (int j=0; j<h; ++j) {
                var piece = pieces[i][j];
                builder.append(piece == null ? '-' : piece.toString());
            }
        }

        return builder.toString();
    }

    public void beautifulPrint(PrintStream out) {
        for (int j=h-1; j>=0; --j) {
            for (int i=0; i<w; ++i) {
                var p = get(i, j);
                out.print(
                    p==null?"-":p.toString()
                );
            }
            out.println();
        }
        out.println();
    }

    public int getWidth() { return w; }

    public int getHeight() { return h; }

    private int getLastRow() { return getHeight() - 1; }

    public static void main(String[] args) {
        BoardState state = new BoardState(5,5);
        state.set(0, 0, new King(true));
        state.set(1, 1, new King(false));
        state.set(1, 2, new Pawn(true));
        state.set(3, 2, new Pawn(false));
        state.set(1, 4, new Pawn(true));
        state.set(4, 1, new Pawn(true));

        System.out.println(state.toString());
    }
}
