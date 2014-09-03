package card;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import javax.swing.*;

/**
 *
 * @author Jared T Reeves
 * @version
 */
public class CardIcon implements Card, Icon {

    private final ConcreteCard card;
    private final Icon icon;
    private static final Icon back = new ImageIcon("cards/b.gif");
    Rectangle2D cardRectangle;

    /**
     * Constructs a new Card icon.
     * @param rank the rank of this card icon
     * @param suit the suit of this card icon
     */
    public CardIcon(int rank, int suit) {
        String r = "";
        String s = "";
        card = new ConcreteCard(rank, suit);
        if (rank == 1) {
            r = "a";
        } else if (rank == 2) {
            r = "2";
        } else if (rank == 3) {
            r = "3";
        } else if (rank == 4) {
            r = "4";
        } else if (rank == 5) {
            r = "5";
        } else if (rank == 6) {
            r = "6";
        } else if (rank == 7) {
            r = "7";
        } else if (rank == 8) {
            r = "8";
        } else if (rank == 9) {
            r = "9";
        } else if (rank == 10) {
            r = "10";
        } else if (rank == 11) {
            r = "j";
        } else if (rank == 12) {
            r = "q";
        } else if (rank == 13) {
            r = "k";
        }

        if (suit == 0) {
            s = "s";
        } else if (suit == 1) {
            s = "c";
        } else if (suit == 2) {
            s = "h";
        } else if (suit == 3) {
            s = "d";
        }
        //faceUp = false;
        String fileName = r + s + ".gif";
        icon = new ImageIcon("cards/" + fileName);
        cardRectangle = new Rectangle(0,0,this.getIconHeight(), this.getIconWidth());
    }

    /**
     * Returns the rank of this card icon.
     * @return the rank of this card icon
     */
    public int getRank() {
        return card.getRank();
    }

    /**
     * Returns the suit of this card icon.
     * @return the suit of this card icon
     */
    public int getSuit() {
        return card.getSuit();
    }

    /**
     * Returns a rectangle that contains this card icon.
     * @return the rectangle that contains this card icon
     */
    public Rectangle2D rec(){
        return cardRectangle;
    }

    /**
     * Sets this x and y values of this cards rectangle.
     * @param x the new x value
     * @param y the new y value
     */
    public void recSet(double x, double y){
        cardRectangle.setRect(x, y, this.getIconWidth(), this.getIconWidth());
    }

    /**
     * Returns true if this card icon contains the point
     * @param point the point tested
     * @return true if this card icon contains the point
     */
    public boolean contains(Point point){
        return this.rec().contains(point);
    }

    /**
     * Returns if this card icons rank is  the same as the other card icon.
     * @param other the other card icon
     * @return true if this card same rank as other, else return false
     */
    public boolean sameRank(Card other) {
        return card.sameRank(other);
    }

      /**
     * Returns if this card icons suit is  the same as the other card icon.
     * @param other the other card icon
     * @return true if this card same suit as other, else return false
     */
    public boolean sameSuit(Card other) {
        return card.sameSuit(other);
    }

    /**
     * Returns the width of this card icon.
     * @return the width of this card icon
     */
    public final int getIconWidth() {
        return icon.getIconWidth();
    }

    /**
     * Returns the height of this card icon.
     * @return the height of this card icon
     */
    public final int getIconHeight() {
        return icon.getIconHeight();
    }

    /**
     * Returns this card icon.
     * @return this card icon
     */
    public Icon getIcon() {
        return icon;
    }

     public void paintIcon(Component c, Graphics g, int x, int y) {
        if (this.faceUp()) {
            icon.paintIcon(c, g, x, y);
        }else{
            back.paintIcon(c, g, x, y);
        }
    }

    @Override
    public String toString() {
        return card.toString();
    }

    public boolean faceUp() {
        return card.faceUp();
    }

    public void flip() {
        card.flip();
    }

    public boolean sameColor(Card other) {
        return card.sameColor(other);
    }

    public Color getColor() {
        return card.getColor();
    }
}
