package controller;

public interface IGuiController {
    void onPieceButtonClicked(GuiClickEvent event);
    
    void setGui(Updatable gui);
    void setCore(IBoard board);
}
