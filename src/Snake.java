
import java.util.ArrayList;
import java.util.List;

/**
 * Snake is made of 3 or more pieces, and it has a direction.
 * If the head of snake hits it body while moving around the game is over.
 * first piece of snake is called head
 * @author gaurav-dogra
 */

public class Snake {

    private Direction direction;
    private List<Piece> snake;

    /**
     *
     * public constructor initialize the snake
     */
    public Snake() {
        this.direction = Direction.EAST;
        snake = new ArrayList<>();
        snake.add(new Piece(48, 50)); // head piece
        snake.add(new Piece(47, 49)); // second piece
        snake.add(new Piece(46, 48)); // third piece

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

    public void move() {
        //x is for rows
        //y is for columns
        // head is first piece of snake
        Piece head = snake.get(0);
        Piece newHead;

        if(this.direction == Direction.SOUTH) {
            if(head.getX() == Border.SOUTH) {
                newHead = new Piece(Border.NORTH, head.getY());
            } else {
                newHead = new Piece(head.getX()+1, head.getY());
            }

        } else if(this.direction == Direction.NORTH) {
            if(head.getX() == Border.NORTH) {
                newHead = new Piece(Border.SOUTH, head.getY());
            } else {
                newHead = new Piece(head.getX()-1, head.getY());
            }

        } else if(this.direction == Direction.WEST) {
            if(head.getY() == Border.WEST) {
                newHead = new Piece(head.getX(), Border.EAST);
            } else {
                newHead = new Piece(head.getX(), head.getY()-1);
            }
        } else if(this.direction == Direction.EAST) {
            if(head.getY() == Border.EAST) {
                newHead = new Piece(head.getX(), Border.WEST);
            } else {
                newHead = new Piece(head.getX(), head.getY()+1);
            }
        } else { // I don't expect the program control to enter this else ever
            newHead = new Piece(head.getX(), head.getY());
        }


        snake.add(0, newHead); //adding the new piece as head of snake
        snake.remove(snake.size()-1); // removing last piece
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
