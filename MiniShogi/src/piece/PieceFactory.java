package piece;

import java.util.ArrayList;
import java.util.List;

public class PieceFactory {
    private boolean isBlack;
    private Piece upgrade;
    private final List<IRule> orRules;
    private final List<IRule> andRules;

    public PieceFactory() {
        upgrade = null;
        orRules = new ArrayList<>();
        andRules = new ArrayList<>();
    }

    public PieceFactory color(boolean isBlack) {
        this.isBlack = isBlack;
        return this;
    }

    public PieceFactory black() {
        isBlack = true;
        return this;
    }

    public PieceFactory white() {
        isBlack = false;
        return this;
    }

    public PieceFactory upgrade(Piece piece) {
        this.upgrade = piece;
        return this;
    }

    public PieceFactory orRule(IRule rule) {
        this.orRules.add(rule);
        return this;
    }

    public PieceFactory andRule(IRule rule) {
        this.andRules.add(rule);
        return this;
    }

    public Piece build() {
        return new Piece(isBlack, upgrade, orRules, andRules);
    }
}
