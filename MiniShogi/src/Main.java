import java.io.FileNotFoundException;

import action.MoveCommand;

import board.Board;
import console.Input;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Board board = new Board();
        boolean isBlack = true;

        Input in = args.length > 0 ? new Input(args[0]) : new Input();

        while (true) {
            MoveCommand cmd = in.read();
            if (cmd == null) {
                break;
            }
            if (cmd.play(board, isBlack)) {
                isBlack = !isBlack;
            }

            System.out.println(board.toString());         
            // board.beautifulPrint(System.out);       
            
            if (board.isFinished()) {
                System.out.println(board.getWinner() + " wins!");
                break;
            }
        }
    }
}
