package controller;

public class GuiClickEvent {
    public final int x;
    public final int y;
    public final char piece;

    public GuiClickEvent(int x, int y, char piece) {
        this.x = x;
        this.y = y;
        this.piece = piece;
    }
}
