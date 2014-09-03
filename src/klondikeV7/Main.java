package klondikeV7;

import java.awt.*;
import javax.swing.JFrame;

/**
 * This is a primitive version of Klondike Solitaire in which you must press
 * on the tableau piles and release them where you want them to be moved. This
 * version the cards do drag, and the logic of the game is working correctly
 * if the stock pile is clicked the waste gets the top card and is flipped. It
 * can move throughout the stockpile until it is empty and then the stock is
 * reset. If the foundation piles can take a card it will, as does all the
 * tableau piles. If the piles cannot take the card or pile the card or pile is
 * returned to the original position.
 *
 * later versions will include menu that will have new game as well as other features.
 *
 *
 * @author Jared Reeves
 * @version Klondike7
 *
 */
public class Main {
private static final int FRAME_WIDTH = 875;
private static final int FRAME_HEIGHT = 600;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       GamePanel panel = new GamePanel();
       JFrame game = new JFrame();
       game.setSize(FRAME_WIDTH, FRAME_HEIGHT);
       game.setVisible(true);
       panel.setBackground(new Color(0,120,0));
       panel.setSize(FRAME_WIDTH, FRAME_HEIGHT);
       game.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
       game.add(panel);

    }

}
