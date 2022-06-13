package gui;

import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.IGuiController;
import controller.Updatable;
import model.GameState;

import java.awt.GridLayout;

public class WindowPane extends JPanel implements Updatable {
    
    private final MainPane mainPane;
    private final JLabel winLabel;

    public WindowPane(IGuiController controller) {
        setLayout(new GridLayout(2,1));

        winLabel = new JLabel("this is a test");
        this.add(winLabel);
        
        mainPane = new MainPane(controller);
        this.add(mainPane);
    }

    @Override
    public void update(GameState state) {
        winLabel.setText(state.isBlackTurn?"black to play":"white to play");
        mainPane.update(state);   
    }

}
