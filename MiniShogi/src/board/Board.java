package board;

import java.io.PrintStream;

import action.MoveCommand;
import piece.Piece;
import util.Config;

public class Board {
    private final BoardState state;   
    
    public Board() {
        this.state = new BoardState(Config.WIDTH, Config.HEIGHT);
        Config.BLACK_START.forEach((grid, piece) -> place(piece, grid));
        Config.WHITE_START.forEach((grid, piece) -> place(piece, grid));
    }

    public boolean isFree(Grid g) {
        return state.get(g) == null;
    }

    public void place(Piece piece, Grid grid) {
        state.set(grid, piece);
    }

    private boolean isValid(Grid g) {
        return g.x < state.getWidth() && g.y < state.getHeight();
    }

    public boolean drop(char piece, Grid g, boolean isBlack) {
        if (!isValid(g)) return false;
        if (!isFree(g)) return false;
        return state.drop(piece, g, isBlack);
    }

    public boolean play(MoveCommand command, boolean isBlack) {
        if (!isValid(command.from) || !isValid(command.to)) return false;
        return state.play(command, isBlack);
    }

    public void beautifulPrint(PrintStream out) {
        state.beautifulPrint(out);
    }

    // public static void main(String[] args) {
    //     Board board = new Board();
    //     board.drop(0, 0, new Lance(true));
    //     board.drop(0, 2, new King(true));
    //     board.drop(0, 3, new King(false));
        
    //     var b = board.play(new MoveCommand('l', new Grid(0, 0), new Grid(0, 3)), true);
    //     if (b == true)
    //         System.out.println("done");
    //     else System.out.println("not done");
        
    //     board.drop(0, 0, new King(true));
    // }
}
