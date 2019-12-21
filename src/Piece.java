/**
 * Piece is an elementary part of Snake. Snake is made of 3 or more Piece. An apple is also a piece.
 *
 * @author gaurav-dogra
 */
public class Piece {
    private int row;
    private int column;

    public Piece(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public Piece() {
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setColumn(int column) {
        this.column = column;
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

        return this.getRow() == parameter.getRow() && this.getColumn() == parameter.getColumn();
    }

    @Override
    public int hashCode() {
        return row *31+ column;
    }

    @Override
    public String toString() {
        return "("+ row +", "+ column +")";
    }
}
