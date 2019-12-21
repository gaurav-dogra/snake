import javax.swing.*;
import java.awt.*;

/**
 * The program is executed from Main.
 * Main also defines the frame window for the game
 *
 * @author gaurav-dogra
 */
public class Main {

    public static void main(String[] args) {

    	Panel panel = new Panel();

	    JFrame frame = new JFrame("Classic Snake");

	    // frame size is set so that actual size is 500x500 excluding borders and title bar
	    frame.setSize(516,539);
	    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	    frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(panel);
	    frame.setVisible(true);

//		Dimension actualSize = frame.getContentPane().getSize();
//		System.out.println("Actual Width "+actualSize.width);
//		System.out.println("Actual Height "+actualSize.height);
    }
}
