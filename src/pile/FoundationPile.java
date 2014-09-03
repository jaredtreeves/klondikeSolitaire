package pile;

import card.*;

/**
 * A Foundation pile used in Klondike that extends the Pile class.
 *
 * @author Jared Reeves
 * @version 12-07-2010
 */
public class FoundationPile extends Pile {

    /**
     * Returns whether this pile can add card icon
     * @param card to be added
     * @return whether this pile can add card icon
     */
    public boolean canAdd(CardIcon card) {
        if (this.isEmpty()) {
            return card.getRank() == Card.ACE;
        } else if (this.get(this.size() - 1).sameSuit(card)) {
            if (this.get(this.size() - 1).getRank() == (card.getRank() - 1)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns whether this pile can add pile
     * @param pile to be added
     * @return whether this pile can add pile
     */
    @Override
    public boolean canAdd(Pile pile) {
        if (pile.size() == 1) {
            if (this.isEmpty()) {
                return pile.bottom().getRank() == Card.ACE;
            } else if (this.get(this.size() - 1).sameSuit(pile.bottom())) {
                if (this.get(this.size() - 1).getRank() == (pile.bottom().getRank() - 1)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Makes a new foundation pile.
     * @return the new pile
     */
    public Pile makePile() {
        FoundationPile fp = new FoundationPile();
        return fp;
    }
}
