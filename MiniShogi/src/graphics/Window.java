package graphics;

import java.awt.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Window extends JFrame {

    private final JPanel mainPanel;
    private final JPanel gridPanel;

    public Window(int w, int h) {
        super();
        mainPanel = new JPanel();
        gridPanel = new JPanel(new GridLayout(h, w)); 
        for (int j=h; j>=1; --j) {
            for (int i=1; i<=w; ++i) {
                gridPanel.add(new JButton(i+""+j));
            }
        }
        mainPanel.add(gridPanel);
        mainPanel.add(new JLabel("status"));
        this.setContentPane(gridPanel);
    }
    
    public void start() {
        setSize(600, 600);
        setTitle("Game of General");
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
