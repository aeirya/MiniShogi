package gui;

import javax.swing.JPanel;

import controller.IGuiController;
import controller.Updatable;
import model.GameState;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;


public class MainPane extends JPanel implements Updatable {
    private final MainPanel mainPanel;
    private final SidePanel blackSidePanel;
    private final SidePanel whiteSidePanel;

    public MainPane(IGuiController controller) {
        this.setBackground(new java.awt.Color(200, 100, 100));

        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.fill = GridBagConstraints.VERTICAL;

        c.weightx = 0.2;
        c.gridx = 0;
        c.gridy = 0;

        blackSidePanel = new SidePanel(controller, true);
        this.add(blackSidePanel, c);

        c.fill = GridBagConstraints.BOTH;
        c.weightx = 0.6;
        c.gridx = 1;
        c.gridy = 0;
        
        mainPanel = new MainPanel(controller);
        this.add(mainPanel, c);
        
        c.fill = GridBagConstraints.VERTICAL;
        c.weightx = 0.2;
        c.gridx = 2;
        c.gridy = 0;

        whiteSidePanel = new SidePanel(controller, false);
        this.add(whiteSidePanel, c);
    }

    @Override
    public void update(GameState state) {
        // update itself
        mainPanel.update(state);

        whiteSidePanel.update(state);
        blackSidePanel.update(state);
    }
}
