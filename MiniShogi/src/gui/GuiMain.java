package gui;

import board.Board;
import controller.GuiController;

public class GuiMain {
    public static void main(String[] args) {
        GuiController controller = new GuiController();
        Window window = new Window(controller);
        
        Board board = new Board();
        controller.setCore(board);
        window.update(board.getState());
    }
}
