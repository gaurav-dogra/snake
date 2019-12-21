import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Panel class is the sole class printing to the screen using its Paint() method.
 * KeyListener is used to listen to arrow keys, which are in turn used to change the direction of the movement of snake
 * Animation is achieved by using a Swing.Timer(). ActionListener is fired after a specific interval repeatedly.
 *
 * @author gaurav-dogra
 */

public class Panel extends JPanel implements ActionListener, KeyListener {

    private Snake snake;
    private Timer timer;
    // Below variable defines the speed of the snake
    private int delay = 90;
    private int score = 0;
    // below variable is used as a mechanism to paint() Snake and applePiece at different time period interval
    private long snakeMoveCounter = 0;
    private int displayApplePieceCounter = 0;
    private Piece applePiece;
    private boolean snakeAlive = true;

    public Panel() {
        snake = new Snake();
        timer = new Timer(delay, this);
        addKeyListener(this);
        // applePiece is initialized with dummy location i.e. outside of canvas
        applePiece = new Piece(100,100);
        timer.start();
    }

    public void addNotify() {
        super.addNotify();
        requestFocus();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        snakeAlive = snake.move();
        snakeMoveCounter++;
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        if(keyEvent.getKeyCode() == KeyEvent.VK_LEFT) {
            snake.setDirection(Direction.WEST);
        } else if(keyEvent.getKeyCode() == KeyEvent.VK_RIGHT) {
            snake.setDirection(Direction.EAST);
        } else if(keyEvent.getKeyCode() == KeyEvent.VK_UP) {
            snake.setDirection(Direction.NORTH);
        } else if(keyEvent.getKeyCode() == KeyEvent.VK_DOWN) {
            snake.setDirection(Direction.SOUTH);
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }

    public void paint(Graphics g) {

        // setting background color
        g.setColor(Color.black);
        g.fillRect(0, 0, 516, 502);


        //drawing snake
        if (snakeAlive) {

            // drawing snake
            g.setColor(Color.yellow);
            for (Piece p : snake.getSnake()) {
                //System.out.println(p);
                g.fillOval(p.getColumn() * 10, p.getRow() * 10, 10, 10);
            }

            //draw score
            g.setColor(Color.gray);
            g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
            g.drawString("Score: " + score, 400, 40);

        } else { // else display the final message
            g.setColor(Color.WHITE);
            g.setFont(new Font("TimesRoman", Font.BOLD, 40));
            g.drawString("Game is Over!", 100, 200);
            g.setFont(new Font("TimesRoman", Font.PLAIN, 28));
            g.drawString("Your Score: " + score, 100, 250);
            timer.stop();
        }

        // apple appears at random place after every 50 moves by snake and stays for the next 50 moves
        if(snakeMoveCounter % 50 == 0) {
            snakeMoveCounter = 0;
            displayApplePieceCounter = 50;
            do {
                //this loop will run until apple is on non snake location
                int randomRow = (int) (Math.random() * 50);
                int randomColumn = (int) (Math.random() * 50);
                applePiece = new Piece(randomRow, randomColumn);
            } while(snake.getSnake().contains(applePiece)); // applePiece can't be put where the body of snake is moving

        }

        // and displayApplePieceCounter ensures the time the applePiece stays at the canvas
        if(displayApplePieceCounter > 0 && !snake.getSnake().contains(applePiece)) {
            displayApplePieceCounter--;
            g.setColor(Color.red);
            g.fillOval(applePiece.getColumn() * 10, applePiece.getRow() * 10, 10, 10);
        }

        // if snake has eaten the apple in last move then increase the score
        if(snake.getSnake().contains(applePiece)) {
            score += 5;
            // once apple is eaten and score is updated. the applePiece is moved out of screen
            applePiece = new Piece(100,100);
            // snake size increase by one piece
            snake.setAddPieceToSnake(true);
        }
    }
}
