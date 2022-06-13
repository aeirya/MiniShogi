package gui;

import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;

import controller.GuiController;
import controller.IGuiController;
import controller.IPieceButton;
import controller.PieceButtonMosueAdapter;
import controller.Updatable;
import model.GameState;


public class PieceButton extends JButton implements Updatable, IPieceButton {
    
    private final int x;
    private final int y;
    private char piece;

    public PieceButton(int x, int y, IGuiController controller) {
        this.x = x;
        this.y = y;

        addMouseListener(new PieceButtonMosueAdapter(x, y, this, controller));
    }

    @Override
    public void update(GameState state) {
        char letter = state.pieces[x-1][y-1];
        this.piece = letter;

        if (state.pieces[x-1][y-1] != 0)
            setText(Character.toString(letter));
        else
            setText("");
    }
    
    public char getPiece() {
        return piece; 
    }
}
