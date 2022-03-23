package player;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import piece.King;
import piece.Piece;

public class Player {
    private final List<Piece> hand;
    public final boolean isBlack;

    public Player(boolean isBlack) {
        this.isBlack = isBlack;
        hand = new ArrayList<>(); 
    }

    public void addHand(Piece piece) {
        hand.add(piece);
    }

    public Piece drop(char piece) {
        Optional<Piece> found = hand.stream().filter(p -> p.isEqual(piece)).findFirst();
        if (found.isPresent()) {
            Piece p = found.get();
            hand.remove(p);
            return p;
        }
        return null;
    }

    public boolean isWon() {
        return hand.stream().anyMatch(King.class::isInstance);
    }

    public String printHand() {
        return hand.stream().map(Piece::toString).collect(Collectors.joining());
    }
}
