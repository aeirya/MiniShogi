package board;

import java.util.stream.Stream;

public class Grid {
    public final int x;
    public final int y;

    public Grid(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return x + ":" + y;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Grid) {
            Grid g = (Grid) obj;
            return x == g.x && y == g.y;
        }
        return super.equals(obj);
    }

    public boolean equals(int x, int y) {
        return this.x == x && this.y == y;
    }

    public Grid next(int dx, int dy) {
        return new Grid(x+dx, y+dy);
    }

    private int sign(int from, int to) {
        if (to > from) return 1;
        else if (to < from) return -1;
        return 0;
    }

    /** generates all the grids in the path from this to 'to' */
    public Stream<Grid> to(Grid to) {
        int dx = sign(x, to.x);
        int dy = sign(y, to.y);
        return Stream.iterate(next(dx, dy), g -> !g.equals(to), g -> g.next(dx, dy));
    }

    @Override
    public int hashCode() {
        return super.hashCode() + x * 100 + y;
    }

    // public static void main(String[] args) {
    //     Grid g = new Grid(1, 1);
    //     g.to(new Grid(5, 5)).forEach(gg -> System.out.println(gg.toString()));
    // }
}
