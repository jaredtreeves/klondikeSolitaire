package pile;

import card.CardIcon;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Iterator;

/**
 *
 * @author Jared Reeves
 * @version 12-07-2010
 */
public class TableauGUI extends PileGUI {

    protected int numberToRemove;

    /**
     * Constructs a new tableau GUI
     *
     * @param c
     * @param pile
     * @param x
     * @param y
     */
    public TableauGUI(Component c, Pile pile, int x, int y) {
        super(c, pile, x, y);
        card = new Rectangle(x, y, blank.getIconWidth(), blank.getIconHeight() + 20);
    }

    /**
     * Returns the number of card icons to be removed.
     *
     * @param point to be tested
     * @return the number of card icons to be removed.
     */
    public int toRemove(Point point) {
        Pile temp = pile;
        Iterator<CardIcon> test = temp.reveseIterator();
        numberToRemove = 1;
        while (test.hasNext()) {
            if (test.next().rec().contains(point)) {
                return numberToRemove;
            } else {
                numberToRemove++;
            }
        }
        return numberToRemove;
    }

    /**
     * Returns whether this GUI contains the point
     *
     * @param point to check
     * @return whether this GUI contains the point
     */
    @Override
    public boolean contains(Point point) {
        if (!pile.isEmpty()) {
            return card.contains(point);
        }else{
            return false;
        }
    }

    @Override
    public void paintPile(Graphics g) {
        int y2 = y;
        if (this.pile.isEmpty()) {
            blank.paintIcon(component, g, x, y);
        } else if (this.pile.size() == 1) {
            this.pile.top().paintIcon(component, g, x, y2);
            this.pile.top().recSet(x, y2);
        } else {
            for (int i = 0; i < pile.size(); i++) {
                this.pile.get(i).paintIcon(component, g, x, y2);
                this.pile.get(i).recSet(x, y2);
                y2 = y2 + 15;
            }
        }
    }
}
