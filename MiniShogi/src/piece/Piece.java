package piece;

import java.util.ArrayList;
import java.util.List;

import board.Grid;

public class Piece {
    private boolean isBlack;
    private boolean isUpgrade;
    
    protected Piece upgrade;
    protected final List<IRule> movesets;
    protected final List<IRule> andRules;

    protected Piece(Piece piece) {
        this.isBlack = piece.isBlack;
        this.isUpgrade = piece.isUpgrade;
        this.upgrade = piece.upgrade;
        this.movesets = piece.movesets;
        this.andRules = piece.andRules;
    }

    public Piece(boolean isBlack, Piece upgrade,  List<IRule> movesets, List<IRule> andRules) {
        this.isBlack = isBlack;
        isUpgrade = false;
        this.upgrade = upgrade;
        this.movesets = movesets;
        this.andRules = andRules;
    }

    protected Piece(boolean isBlack, Piece upgrade,  List<IRule> movesets) {
        this(isBlack, upgrade, movesets, new ArrayList<>());
    }

    protected Piece(boolean isBlack,  List<IRule> moveSets) {
        this(isBlack, null, moveSets);
    }

    public boolean isBlack() {
        return this.isBlack;
    }

    /** 
     * change colors upon being captures
     * and undo updgrade
     */
    public void capture() {
        this.isBlack = !isBlack;
        this.isUpgrade = false;
        if (this.upgrade != null) 
            upgrade.capture();
    }

    public void upgrade() {
        if (upgrade != null)
            isUpgrade = true;
    }

    public Piece tryGetUpgrade() {
        if (isUpgrade) return upgrade;
        return this;
    }

    public boolean canGo(Grid from, Grid to, boolean isBlack) {
        if (isUpgrade) 
            return this.upgrade.canGo(from, to, isBlack);
        return movesets.stream().anyMatch(m -> m.canGo(from, to, isBlack)) && andRules.stream().allMatch(m -> m.canGo(from, to, isBlack));
    }

    @Override
    public String toString() {
        return LatinPiecePrinter.toString(this);
    }

    public boolean isEqual(char c) {
        return LatinPiecePrinter.toString(this).charAt(0) == c;
    }
}
