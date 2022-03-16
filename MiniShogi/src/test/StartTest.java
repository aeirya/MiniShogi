package test;

import board.Board;
import console.Input;

public class StartTest {
    public static void main(String[] args) {
        Board board = new Board();
        board.beautifulPrint(System.out);
        
        Input in = new Input();
        boolean isBlack = true;
        while (true) {
            var cmd = in.read();
            if (cmd == null) break;
            if (cmd.play(board, isBlack)) {
                isBlack = !isBlack;
                board.beautifulPrint(System.out);
            }
        }
    }
}
