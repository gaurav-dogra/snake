/**
 * Piece is an elementary part of Snake. Snake is made of 3 or more Piece. An apple is also a piece.
 *
 * @author gaurav-dogra
 */
public class Piece {
    private int x;
    private int y;

    /**
     * @param x denotes the row
     * @param y denotes the column
     */
    public Piece(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) {
            return false;
        }
        if(this.getClass() != obj.getClass()) {
            return false;
        }
        Piece parameter = (Piece) obj;

        return this.getX() == parameter.getX() && this.getY() == parameter.getY();
    }

    @Override
    public int hashCode() {
        return x*31+y;
    }

    @Override
    public String toString() {
        return "("+x+", "+y+")";
    }
}
