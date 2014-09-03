/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pile;

import card.*;

/**
 * A Stockpile used in Klondike that extends the Pile class.
 *
 * @author Jared Reeves
 * @version 12-07-2010
 */
public class StockPile extends Pile {

    public StockPile(){
    }

    /**
     * Returns whether this pile can add card icon
     * @param card to be added
     * @return whether this pile can add card icon
     */
    public boolean canAdd(CardIcon card){
        return true;
    }

    /**
     * Makes a new Stock pile.
     * @return the new pile
     */
    public Pile makePile(){
        StockPile sp = new StockPile();
        return sp;
    }

}
