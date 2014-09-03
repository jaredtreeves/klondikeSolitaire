
package card;

import java.awt.Color;


/**
 * A concrete card that will be used in various card games.
 * This concrete card is a physical card that is a standard
 * playing card. This class extends the card class.
 *
 *
 * @author Jared T Reeves
 * @version 12-07-2010
 */
public class ConcreteCard implements Card
{

    // Private constants for the toString method.

    /** A string representing a heart. */
    private static final String SPADE_STRING = "\u2660";
    /** A string representing a heart. */
    private static final String CLUB_STRING = "\u2663";
    /** A string representing a heart. */
    private static final String HEART_STRING = "\u2665";
    /** A string representing a heart. */
    private static final String DIAMOND_STRING = "\u2666";
    private static final String[] suits = {
        SPADE_STRING, CLUB_STRING, HEART_STRING, DIAMOND_STRING};
    private static final String[] ranks = {
        "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"
    };

    private final int rank;
    private final int suit;
    private boolean faceUp;
    private final Color color;

    /**
     * Initialize this card to the given rank and suit.
     * Precondition: rank is between 1 (Ace) and 13 (King) -- inclusive
     * Precondition: suit is SPADES, CLUBS, HEARTS, or DIAMONDS
     * @param rank the rank of this card
     * @param suit the suit of this card
     */
    public ConcreteCard(int rank, int suit) {
        assert 1 <= rank && rank <= 13 : "Card: rank is out of range";
        assert SPADES <= suit && suit <= DIAMONDS :
            "Card: suit is out of range";
        this.rank = rank - 1;
        this.suit = suit;
        faceUp = false;
        if(this.suit == SPADES || this.suit == CLUBS){
            color = Color.BLACK;
        }else{
            color = Color.RED;
        }
        
        
    }

    /**
     * Return the rank of this card. The rank is an integer between 1 and 13.
     * Ace is 1; Jack is 11; Queen is 12; King is 13;
     * ranks between 2 and 10 (inclusive) are equal to the same.
     * @return the rank of this card.
     */
    public int getRank() {
        return this.rank + 1;
    }

    /**
     * The suit of this card:
     * Card.SPADES, Card.CLUBS, Card.HEARTS, or Card.DIAMONDS.
     * @return the suit of this card.
     */
    public int getSuit() {
        return this.suit;
    }

    /**
     * Return whether or not this card is the same rank as the other.
     * Precondition: other is not null
     * @param other the card to compare to this card
     * @return whether or not this card is the same rank as the other
     */
    public boolean sameRank(Card other) {
        assert other != null : "sameRank: other is null";
        return this.getRank() == other.getRank();
    }

    /**
     * Return whether or not this card is the same suit as the other.
     * Precondition: other is not null
     * @param other
     * @return whether or not this card is the same suit as the other
     */
    public boolean sameSuit(Card other) {
        assert other != null : "sameSuit: other is null";
        return this.getSuit() == other.getSuit();
    }

    /**
     * Returns this cards color.
     * @return this cards color
     */
    public Color getColor(){
        return this.color;
    }

    /**
     * Returns whether ornot this card is face up or face down.
     * @return whether ornot this card is face up or face down
     */
    public boolean faceUp() {
        return faceUp;
    }

    /**
     * A method to flip this card.
     */
     public void flip() {
        faceUp = !faceUp;
        
    }

     /**
      * Returns whether this card same color as other card.
      * @param other the other card to be compared to
      * @returnwhether this card same color as other card
      */
    public boolean sameColor(Card other) {
       return this.color == other.getColor();
    }

    @Override
    public String toString() {
        return ranks[rank] + suits[suit];
    }
   
}
