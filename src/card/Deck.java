package card;



import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * A 52-card card list that can be shuffled. Cards can never be removed from a card list.
 * Since the card list can be shuffled, it is mutable.
 *
 * @author Anne Cable
 * @version September 13, 2010
 */
public class Deck {

    private final ArrayList<CardIcon> cardlist;
    

    /**
     * Construct a 52-card unshuffled card list.
     * Postcondition: the card list is a standard 52-card poker card list.
     */
    public Deck() {
        cardlist = new ArrayList<CardIcon>();
        for (int suit = CardIcon.SPADES; suit <= CardIcon.DIAMONDS; suit++) {
            for (int rank = 1; rank <= 13; rank++) {
                cardlist.add(new CardIcon(rank, suit));
            }
        }
    }

    /**
     * Shuffle the card list.
     */
    public void shuffle() {
        Collections.shuffle(cardlist);
    }

    /**
     * Return the card at the specified index in this deck.
     * <BR>Precondition: 0 <= index < 52.
     * @param index the index of the card to return
     * @return the card at the specified index
     */
    public Card get(int index) {
        assert 0 <= index && index < 52: "get: index out of range";
        return cardlist.get(index);
    }

    public Iterator<CardIcon> iterator(){
       return new Iterator<CardIcon>() {
            private int index = 0;

            public boolean hasNext() {
                return (index < cardlist.size());
            }

            public CardIcon next() {
                return cardlist.get(index++);
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        };
    }

    @Override
    public String toString() {
        return cardlist.toString();
    }
}
