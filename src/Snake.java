
import java.util.ArrayList;
import java.util.List;

/**
 * Snake is made of 3 or more pieces, and it has a direction.
 * If the head of snake hits its body while moving around the game is over.
 * first piece of snake is called head
 * @author gaurav-dogra
 */

public class Snake {

    private Direction direction;
    private List<Piece> snake;
    private boolean addPieceToSnake = false;

    /**
     *
     * constructor to initialize the snake
     */
    public Snake() {
        this.direction = Direction.SOUTH;
        snake = new ArrayList<>();
        snake.add(new Piece(0, 0)); // head piece
        snake.add(new Piece(0, 1)); // second piece
        snake.add(new Piece(0, 2)); // third piece
        snake.add(new Piece(0, 3));
        snake.add(new Piece(0, 4));
        snake.add(new Piece(0, 5));
        snake.add(new Piece(0, 6));
        snake.add(new Piece(0, 7));
        snake.add(new Piece(0, 8));
        snake.add(new Piece(0, 9));
        snake.add(new Piece(0, 10));
        snake.add(new Piece(0, 11));
        snake.add(new Piece(0, 12));
        snake.add(new Piece(0, 13));
        snake.add(new Piece(0, 14));
        snake.add(new Piece(0, 15));
        snake.add(new Piece(0, 16));
        snake.add(new Piece(0, 17));
        snake.add(new Piece(0, 18));

//        snake.add(new Piece(0, 47)); // head piece
//        snake.add(new Piece(0, 48)); // second piece
//        snake.add(new Piece(0, 49)); // third piece
//
//        snake.add(new Piece(49, 0)); // head piece
//        snake.add(new Piece(49, 1)); // second piece
//        snake.add(new Piece(49, 2)); // third piece
//
//        snake.add(new Piece(49, 47)); // head piece
//        snake.add(new Piece(49, 48)); // second piece
//        snake.add(new Piece(49, 49)); // third piece
//

    }

    public void setAddPieceToSnake(boolean value) {
        addPieceToSnake = value;
    }

    public Direction getDirection() {
        return this.direction;
    }

    /**
     * if the newDirection is valid considering the current direction then change to direction is made
     * else it does not affect the movement of snake
     * @param newDirection new direction as requested
     */
    public void setDirection(Direction newDirection) {

        if(this.direction == Direction.SOUTH && newDirection == Direction.NORTH ||
        this.direction == Direction.NORTH && newDirection == Direction.SOUTH ||
        this.direction == Direction.WEST && newDirection == Direction.EAST ||
        this.direction == Direction.EAST && newDirection == Direction.WEST ||
        this.direction == newDirection) {
            return; // No change in direction
        }
        this.direction = newDirection; // direction is changed
    }

    public int getLength() {
        return snake.size();
    }

    public List<Piece> getSnake() {
        return new ArrayList<>(snake);
    }

    public boolean move() {

        // head is first piece of snake
        Piece head = snake.get(0);
        Piece newHead;

        if(this.direction == Direction.SOUTH) {
            if(head.getRow() == Border.SOUTH) { //already going south and down button press
                newHead = new Piece(Border.NORTH, head.getColumn());
            } else {
                newHead = new Piece(head.getRow()+1, head.getColumn());
            }

        } else if(this.direction == Direction.NORTH) {
            if(head.getRow() == Border.NORTH) { // already going north and up button press
                newHead = new Piece(Border.SOUTH, head.getColumn());
            } else {
                newHead = new Piece(head.getRow()-1, head.getColumn());
            }

        } else if(this.direction == Direction.WEST) {
            if(head.getColumn() == Border.WEST) { // already going west and left button press
                newHead = new Piece(head.getRow(), Border.EAST);
            } else {
                newHead = new Piece(head.getRow(), head.getColumn()-1);
            }
        } else if(this.direction == Direction.EAST) {
            if(head.getColumn() == Border.EAST) { // already going east and right button press
                newHead = new Piece(head.getRow(), Border.WEST);
            } else {
                newHead = new Piece(head.getRow(), head.getColumn()+1);
            }
        } else {
            newHead = new Piece(0,0);
        }
        // snake head touches its body
        if(snake.contains(newHead)) {
            return false;
        } else {
            snake.add(0, newHead); //adding the new piece as head of snake
            // if addPieceToSnake is true the last Piece is not removed, resulting in increasing of the size of snake by one
            if(addPieceToSnake) {
                addPieceToSnake = false;
                System.out.println("snake size: "+snake.size());
            } else {
                snake.remove(snake.size() - 1); // removing last piece
            }
            return true;
        }
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for(Piece piece : snake) {
            str.append(piece).append("-");
        }
        return str.toString();
    }

}
