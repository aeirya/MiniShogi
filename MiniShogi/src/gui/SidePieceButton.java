package gui;

import javax.swing.JButton;
import javax.xml.stream.events.StartElement;

import controller.IGuiController;
import controller.IPieceButton;
import controller.PieceButtonMosueAdapter;
import controller.Updatable;
import model.GameState;

public class SidePieceButton extends JButton implements Updatable, IPieceButton {

    private char piece;
    private final boolean isBlack;
    private final int i;

    public SidePieceButton(IGuiController controller, boolean isBlack, int i) {
        this.isBlack = isBlack;
        this.i = i;

        addMouseListener(new PieceButtonMosueAdapter(0, 0, this, controller));
    }

    @Override
    public char getPiece() {
        return piece;
    }

    @Override
    public void update(GameState state) {
        var hand = isBlack ? state.blackHand : state.whiteHand;

        if (i < hand.size()) {
            piece = hand.get(i);
            setText(Character.toString(piece));
        }
        else {
            setText("");
        }
    }
}
