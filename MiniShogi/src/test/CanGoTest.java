package test;

import board.Grid;
import piece.King;
import piece.Gold;
import piece.Lance;
import piece.Pawn;
import piece.Piece;
import piece.Ranger;
import piece.Rook;
import piece.Silver;

public class CanGoTest {
    public static void testKing() {
        var king = new King(true);
        var loc = new Grid(2,2);
        for (int i=0; i<4; ++i) {
            for (int j=0; j<4; ++j) {
                System.out.println("king can go to " + new Grid(i, j).toString() + "=> " + king.canGo(loc, new Grid(i, j), false)); 
            }
        }
    }

    public static void testLance() {
        var lance = new Lance(true);
        var loc = new Grid(1,1);
        for (int i=0; i<4; ++i) {
            for (int j=0; j<4; ++j) {
                System.out.println("lance can go to " + new Grid(i, j).toString() + "=> " + lance.canGo(loc, new Grid(i, j), false)); 
            }
        }
    }

    public static void upgradePawnTest() {
        var pawn = new Pawn(true);
        pawn.upgrade();

        printMoves(pawn, new Grid(2, 2));
    }
    
    public static void upgradeCapturePawnTest() {
        var pawn = new Pawn(true);
        pawn.upgrade();
    
        printMoves(pawn, new Grid(2, 2));

        pawn.capture();
        System.out.println();

        printMoves(pawn, new Grid(2, 2));
    }
    
    public static void testGold() {
        var gold = new Gold(true);
        var loc = new Grid(2,2);
        for (int i=0; i<5; ++i) {
            for (int j=0; j<5; ++j) {
                System.out.println("lance can go to " + new Grid(i, j).toString() + "=> " + gold.canGo(loc, new Grid(i, j), false)); 
            }
        }
    }

    public static void printMoves(Piece piece, Grid loc) {
        for (int j=0; j<6; ++j) {
            for (int i=0; i<6; ++i) {
                var grid = new Grid(i, 4-j);
                if (grid.equals(loc)) System.out.print("!");
                else 
                    System.out.print(piece.canGo(loc, grid, false) ? "X":"O");
            }
            System.out.println();
        }
        System.out.println();
    }

    // public static void rangerTest() {
        
    // }


    public static void main(String[] args) {
        // testKing();
        // testLance();
        // testGold();
        System.out.println("gold");
        printMoves(new Gold(true), new Grid(2, 3));
        System.out.println("silver");
        printMoves(new Silver(true), new Grid(2, 3));
        System.out.println("king");
        printMoves(new King(true), new Grid(2, 3));
        // upgradePawnTest();
        // upgradeCapturePawnTest();
        System.out.println("rook");
        printMoves(new Rook(true), new Grid(1, 2));
        System.out.println("lance");
        printMoves(new Lance(true), new Grid(1, 2));
        System.out.println("ranger");
        printMoves(new Ranger(true), new Grid(1, 1));
    }
}
