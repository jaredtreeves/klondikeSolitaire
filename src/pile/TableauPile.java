/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pile;

import card.*;

/**
 *
 * @author reevej01
 */
public class TableauPile extends Pile {

    public TableauPile() {
    }

    /**
     * Returns whether this pile can add card icon
     * @param card to be added
     * @return whether this pile can add card icon
     */
    public boolean canAdd(CardIcon card) {
        if (this.isEmpty() && card.getRank() == Card.KING) {
            return true;
        } else if (this.isEmpty() && card.getRank() != Card.KING) {
            return false;
        } else if (!this.get(this.size() - 1).sameColor(card)) {
            if (this.get(this.size() - 1).getRank() == (card.getRank() + 1)) {
                return true;
            }
        }
        return false;
    }
    /**
     * Returns whether a pile can be removed from this pile.
     * @param i the number to remove
     * @return whether a pile can be removed from this pile.
     */
    @Override
    public boolean canRemovePile(int i) {
        return true;
    }

    /**
     * Returns whether this pile can add pile
     * @return whether this pile can add pile
     */
    @Override
    public boolean canAdd(Pile other) {
        if (this.isEmpty() && other.bottom().getRank() == Card.KING) {
            return true;
        } else if (this.isEmpty() && other.bottom().getRank() != Card.KING) {
            return false;
        } else if (!this.top().sameColor(other.bottom()) && this.top().getRank() == other.bottom().getRank() + 1) {
            return true;
        }
        return false;
    }

    /**
     * Makes a new Tableau pile.
     * @return the new pile
     */
    public Pile makePile() {
        TableauPile tp = new TableauPile();
        return tp;
    }
}
