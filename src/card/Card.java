package card;

import java.awt.Color;

/**
 *
 * @author Jared Reeves
 * @Version 10-26-2010
 *
 */
public interface Card {
    // Public constants for the card suits.

    /** The card suit spades. */
    static final int SPADES = 0;
    /** The card suit clubs. */
    static final int CLUBS = 1;
    /** The card suit hearts. */
    static final int HEARTS = 2;
    /** The card suit diamonds. */
    static final int DIAMONDS = 3;
    static final int ACE = 1;
    static final int JACK = 11;
    static final int QUEEN = 12;
    static final int KING = 13;
   
    /**
     * Return true if this card is face up else return false
     * @return true if this card face up else return false
     */
    boolean faceUp();

    /**
     * Return the rank of this card. The rank is an integer between 1 and 13.
     * Ace is 1; Jack is 11; Queen is 12; King is 13;
     * ranks between 2 and 10 (inclusive) are equal to the same.
     * @return the rank of this card.
     */
    int getRank();

    /**
     * The suit of this card:
     * Card.SPADES, Card.CLUBS, Card.HEARTS, or Card.DIAMONDS.
     * @return the suit of this card.
     */
    int getSuit();

    /**
     * Returns the color of this card.
     * @return the color of this card
     */
    Color getColor();

    /**
     * Returns true if this card the same color as other card, else
     * returns false.
     * @param other the other card
     * @return true if t]other card same color as this card
     */
    boolean sameColor(Card other);

    /**
     * Return whether or not this card is the same rank as the other.
     * Precondition: other is not null
     * @param other the card to compare to this card
     * @return whether or not this card is the same rank as the other
     */
    boolean sameRank(Card other);

    /**
     * Return whether or not this card is the same suit as the other.
     * Precondition: other is not null
     * @param other
     * @return whether or not this card is the same suit as the other
     */
    boolean sameSuit(Card other);

    @Override
    String toString();
}



