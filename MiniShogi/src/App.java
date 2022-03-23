import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import board.Board;
import console.Input;

public class App {

    private static final String TEST_DIR = "tests/";
    public static void main(String[] args) throws FileNotFoundException {
        
        if (!new File(TEST_DIR).exists()) {
            new File(TEST_DIR).mkdir();
            new File(TEST_DIR + "in/").mkdir();
            new File(TEST_DIR + "out/").mkdir();
        }
        
        int testID = 0;

        while (
            new File(getAddress(testID, true)).exists()
        ) {
            ++testID;
        }
        System.out.println("making test: " + testID);

        PrintWriter inputWriter = new PrintWriter(new File(getAddress(testID, false)));
        PrintWriter outputWriter = new PrintWriter(new File(getAddress(testID, true)));
        
        Board board = new Board();
        board.beautifulPrint(System.out);
        
        Input in = new Input();
        boolean isBlack = true;
        while (true) {
            var cmd = in.read();
            if (cmd == null) {
                inputWriter.println("0");
                break;
            }
            if (cmd.play(board, isBlack)) {
                isBlack = !isBlack;
                board.beautifulPrint(System.out);

                inputWriter.println(cmd.toString());
                outputWriter.println(board.toString());
            }
        }

        inputWriter.close();
        outputWriter.close();
    }

    private static String getAddress(int id, boolean isOut) {
        return TEST_DIR +(isOut?"out/output":"in/input") + id + ".txt";
    }
}