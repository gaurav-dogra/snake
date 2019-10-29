/**
 * The program is executed from Main.
 *
 * @author gaurav-dogra
 */
public class Main {

    public static void main(String[] args) {
	    Snake snake = new Snake();

        System.out.println(snake); // head at 50
        snake.move(); // head at 1
        snake.move(); // head at 2
        snake.move(); // head at 3
        snake.move(); // head at 4

        System.out.println(snake);
    }
}
