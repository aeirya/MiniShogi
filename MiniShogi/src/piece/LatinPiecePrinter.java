package piece;

public class LatinPiecePrinter {
    private LatinPiecePrinter() { }

    public static String toString(Piece piece) {
        String letter = getLetter(piece);
        if (letter ==  null) return letter;

        if (piece.isBlack()) return letter;
        else return letter.toUpperCase();
    }
    
    private static String getLetter(Piece piece) {
        if (piece instanceof King) return "k";
        if (piece instanceof Gold) return "g";
        if (piece instanceof Pawn) return "p";
        if (piece instanceof Lance) return "l";
        if (piece instanceof Rook) return "r";
        if (piece instanceof Silver) return "s";
        if (piece instanceof Bishop) return "b";
        if (piece instanceof Ranger) return "n";
        else return null;
    }

    public static String getLetterKing(boolean isBlack) {
        return new King(isBlack).toString();
    }

    public static boolean isBlack(char piece) {
        return piece >= 'a' && piece <= 'z';
    }
}
