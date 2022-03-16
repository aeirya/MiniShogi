import action.MoveCommand;
import console.Input;

public class App {
    public static void main(String[] args) {
        Input in = new Input();
        MoveCommand cmd;
        do {
            cmd = in.read();
            
        } while (cmd != null);
    }
}
