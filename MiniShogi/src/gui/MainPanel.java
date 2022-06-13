package gui;

import javax.swing.JButton;
import javax.swing.JPanel;

import controller.GuiController;
import controller.IGuiController;
import controller.Updatable;
import model.GameState;

import java.awt.GridLayout;

public class MainPanel extends JPanel implements Updatable {
    
    private final PieceButton[][] pieces;

    public MainPanel(IGuiController controller) {
        setLayout(new GridLayout(5,5));

        pieces = new PieceButton[5][5];

        for (int j=5; j>=1; --j) {
            for (int i=1; i<=5; ++i) {
                pieces[i-1][j-1] = new PieceButton(i, j, controller);
                this.add(
                    pieces[i-1][j-1]
                );
            }
        }
    }

    @Override
    public void update(GameState state) {
        for (int i=0; i<5; ++i) {
            for (int j=0; j<5; ++j) {
                pieces[i][j].update(state);
            }
        }
    }
}
