package controller;

import action.MoveCommand;
import board.Grid;
import model.GameState;

public interface IBoard {
    boolean play(MoveCommand command, boolean isBlack);
    boolean drop(char piece, Grid g, boolean isBlack);

    GameState getState();
}
