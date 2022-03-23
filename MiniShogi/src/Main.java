import action.MoveCommand;

import board.Board;
import console.Input;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        boolean isBlack = true;
        Input in = new Input();

        while (true) {
            MoveCommand cmd = in.read();
            if (cmd == null) {
                break;
            }
            if (cmd.play(board, isBlack)) {
                isBlack = !isBlack;
                System.out.println(board.toString());         
            }

            if (board.isFinished()) {
                System.out.println(board.getWinner() + " wins!");
                break;
            }
            board.beautifulPrint(System.out);       
        }
    }
}
