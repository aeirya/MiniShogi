package console;

import java.util.Scanner;

import action.MoveCommand;
import board.Grid;

public class Input {
    private final Scanner scanner;

    public Input() {
        scanner = new Scanner(System.in);
    }

    public MoveCommand read() {
        var c = readChar();
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
