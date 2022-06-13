package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PieceButtonMosueAdapter extends MouseAdapter  {
    
    private final int x;
    private final int y;
    private IPieceButton button;

    private final IGuiController controller;

    public PieceButtonMosueAdapter(int x, int y, IPieceButton button, IGuiController controller) {
        this.x = x;
        this.y = y;
        this.controller = controller;
        this.button = button;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        controller.onPieceButtonClicked(
            new GuiClickEvent(x-1, y-1, button.getPiece())
        );
    }
}
