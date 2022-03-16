package graphics;

import javax.swing.JFrame;

public class App {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(100,100);
        frame.setVisible(true);
        Window win = new Window(4,6);
        win.start();
    }
}
