package pile;

import card.*;
import java.util.ArrayList;
import java.util.Iterator;

/*
 * This is a generic pile class that inherits from the arraylist class. It is
 * used to store pile of playing cards. It will be used in various card games
 */
/**
 *
 * @author Jared Reeves
 * @version 9-20-2010
 * 
 */
public abstract class Pile {

    protected ArrayList<CardIcon> pile;

    /**
     * Constructs a new empty pile
     *
     * mutator method
     */
    protected Pile() {
        pile = new ArrayList<CardIcon>();
    }

    public void clear(){
        pile.clear();
    }

    /**
     * Adds an CardIcon to this pile
     * @param card the card to be added to this pile
     *
     * mutator method
     */
    public void addCard(CardIcon card) {
        pile.add(card);
    }

    /**
     * Adds an pile to this pile
     * @param other the pile to be added to this pile
     *
     * mutator method
     */
    public void addPile(Pile other) {
        pile.addAll(other.getPile());
    }

    /**
     * Returns the bottom card in this pile
     * @return the bottom card in this pile
     */
    public CardIcon bottom() {
        return pile.get(0);
    }


    abstract boolean canAdd(CardIcon card);

    /**
     * Returns whether this pile can add other pile.
     * @param other pile to be added
     * @return whether this pile can add other pile
     */
    public boolean canAdd(Pile other) {
         return true;
    }

    /**
     * Returns whether this pile can remove other pile.
     * @param n
     * @return whether this pile can remove other pile
     */
    public boolean canRemovePile(int n) {
        return true;
    }

    /**
     * Returns whether this pile is empty.
     * @return whether this pile is empty
     */
    public boolean isEmpty() {
        return pile.isEmpty();
    }

    /**
     * An iterator for this pile
     * @return 
     */
    public Iterator<CardIcon> iterator() {
        return new Iterator<CardIcon>() {

            private int index = 0;

            public boolean hasNext() {
                return index < pile.size();
            }

            public CardIcon next() {
                if (index < pile.size()) {
                    index++;
                }
                return pile.get(index - 1);
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        };
    }

    /**
     * a reverse Iterator for this pile.
     * @return 
     */
    public Iterator<CardIcon> reveseIterator() {
        return new Iterator<CardIcon>() {

            private int index = pile.size();

            public boolean hasNext() {
                return index > 0;
            }

            public CardIcon next() {
                if (index > 0) {
                    index--;
                }
                return pile.get(index);
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        };
    }

    /**
     * Makes a new Pile.
     * @return new pile
     */
    public abstract Pile makePile();

    /**
     * Removes an CardIcon to this pile
     * @return 
     */
    public CardIcon removeCard() {
        return pile.remove(pile.size() - 1);
    }

    /**
     * Removes an CardIcon to this pile
     * @param index
     * @return 
     */
    public Pile removePile(int index) {
        WastePile newpile = new WastePile();
        int pointer = pile.size() - index;
        for (int i = 0; i < index; i++) {
            newpile.addCard(pile.remove(pointer));
        }
        return newpile;
    }

    /**
     * Return this pile.
     * @return this pile
     */
    public ArrayList<CardIcon> getPile() {
        return pile;
    }

    /**
     * returns the top card icon in this pile.
     * @return the top card icon in this pile
     */
    public CardIcon top() {
        return pile.get(pile.size() - 1);
    }

    /**
     * Returns this piles size.
     * @return pile size
     */
    public int size() {
        return pile.size();
    }

    /**
     * returns the card icon at index i.
     * @param i the index to get
     * @return card icon at index i
     */
    public CardIcon get(int i) {
        return pile.get(i);
    }
}

