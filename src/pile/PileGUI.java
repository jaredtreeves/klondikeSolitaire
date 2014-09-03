package pile;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import javax.swing.*;

/**
 * This is Pile GUI Class that is used to handle how the piles are constructed
 * visually.
 *
 * @author Jared Reeves
 * @version 12-07-2010
 */
public class PileGUI {

    protected Icon blank = new ImageIcon("cards/blank.gif");
    protected Component component;
    protected  Pile pile;
    protected  int x;
    protected  int y;
    Rectangle2D card;
    
    /**
     * Constructs a new Pile GUI.
     * @param c
     * @param pile
     * @param x
     * @param y
     */
    public PileGUI(Component c, Pile pile, int x, int y) {
        this.component = c;
        this.pile = pile;
        this.x = x;
        this.y = y;
        card = new Rectangle(x,y,blank.getIconWidth(),blank.getIconHeight());
    }

    /**
     * Returns whether this GUI contains the point
     * @param point to check
     * @return whether this GUI contains the point
     */
    public boolean contains(Point point){
       return card.contains(point);
    }
     
    public void setX(int x){
        this.x = x; 
    }
    
    public void setY(int y){
        this.y = y;
    }
    
    public void paintPile(Graphics g) {
        if (this.pile.isEmpty()) {
            blank.paintIcon(component, g, x, y);
        } else {
            this.pile.top().paintIcon(component, g, x, y);
            
        }

    }
}
