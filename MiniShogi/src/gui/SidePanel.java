package gui;

import javax.swing.JPanel;

import controller.IGuiController;
import controller.Updatable;
import model.GameState;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import java.awt.Dimension;

public class SidePanel extends JPanel implements Updatable {
    
    private final List<Updatable> sidePieceButtons;

    public SidePanel(IGuiController controller, boolean isBlack) {
        setLayout(new GridLayout(5, 1));
        
        sidePieceButtons = new ArrayList<>();
        for (int i=0; i<5; ++i) {
            SidePieceButton button = new SidePieceButton(controller, isBlack, i);
            sidePieceButtons.add(button);
            this.add(button);
        }

        setPreferredSize(new Dimension(200, 1));
    }

    @Override
    public void update(GameState state) {
        sidePieceButtons.forEach(item -> item.update(state));
    }
}
