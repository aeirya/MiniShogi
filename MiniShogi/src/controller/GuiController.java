package controller;

import action.MoveCommand;
import board.Board;
import board.Grid;
import model.GameState;
import piece.LatinPiecePrinter;

public class GuiController implements IGuiController, Updatable {

    private Updatable gui;
    private IBoard board;

    private char piece;
    
    private Grid first;
    private Grid second;

    private static final boolean DEBUG = true;

    /* main panel pieces */
    public void onPieceButtonClicked(GuiClickEvent event) {
        if (first == null) {
            first = new Grid(event.x, event.y);
            piece = event.piece;

            if (DEBUG)
                System.out.println(event.piece);
        }
        else {
            if (DEBUG)
                System.out.println(event.piece);

            second = new Grid(event.x, event.y);
            new MoveCommand(piece, first, second).play(board, LatinPiecePrinter.isBlack(piece));

            first = null;
            second = null;

            ((Board) board).beautifulPrint(System.out);

            this.update(board.getState());
        }
    }

    public void setGui(Updatable gui) {
        this.gui = gui;
    }

    @Override
    public void update(GameState state) {
        gui.update(state);
    }

    public void setCore(IBoard board) {
        this.board = board;
    }

}
