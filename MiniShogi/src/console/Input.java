package console;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import action.MoveCommand;
import board.Grid;

public class Input {
    private final Scanner scanner;

    public Input() {
        scanner = new Scanner(System.in);
    }

    public Input(String filepath) throws FileNotFoundException {
        scanner = new Scanner(new File(filepath));
    }

    public MoveCommand read() {
        char c = readChar();
        if (c == '0') return null;
        
        if (c < 65 || c > 123)
            return null;
        
        return new MoveCommand(
            c, readGrid(), readGrid()
        );
    }

    private Grid readGrid() {
        int g = scanner.nextInt();
        return new Grid(g/10-1, g%10-1);
    }

    private char readChar() {
        return scanner.next().charAt(0);
    }
}
