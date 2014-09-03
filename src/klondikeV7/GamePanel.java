package klondikeV7;

import card.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.*;
import javax.swing.*;
import pile.*;

/**
 * Constructs a game panel that deals with the logic of the game.
 *
 * @author Jared Reeves
 * @version Klondike7
 */
public class GamePanel extends JPanel {

    private PileGUI stockGUI;
    private PileGUI wasteGUI;
    private PileGUI foundation1GUI;
    private PileGUI foundation2GUI;
    private PileGUI foundation3GUI;
    private PileGUI foundation4GUI;
    private PileGUI tempGUI;

    private TableauGUI tableau1GUI;
    private TableauGUI tableau2GUI;
    private TableauGUI tableau3GUI;
    private TableauGUI tableau4GUI;
    private TableauGUI tableau5GUI;
    private TableauGUI tableau6GUI;
    private TableauGUI tableau7GUI;

    private Pile stock;
    private Pile waste;
    private Pile foundation1;
    private Pile foundation2;
    private Pile foundation3;
    private Pile foundation4;
    private Pile tableau1;
    private Pile tableau2;
    private Pile tableau3;
    private Pile tableau4;
    private Pile tableau5;
    private Pile tableau6;
    private Pile tableau7;

    private Deck deck = new Deck();
    private Iterator<CardIcon> iter = deck.iterator();
    private Icon blank = new ImageIcon("cards/blank.gif");
    private int y = 20 + blank.getIconHeight() + 30;
    private int x = 20 + blank.getIconWidth() + 30;
    private Point mouseClick;
    private Pile tempClick;
    private Point mousePress;
    private Pile dragPile = new TableauPile();
    private Point mouseReleased;
    private String from;
    private JMenuBar menuBar;
    private JMenu menu;

    public GamePanel() {

        addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent event) {
                mouseClick = event.getPoint();
                from = "stock";
                tempClick = new WastePile();
                if (stockGUI.contains(mouseClick)) {
                    if (stock.canRemovePile(1) && !stock.isEmpty()) {
                        tempClick = stock.removePile(1);
                        waste.addCard(tempClick.top());
                        waste.top().flip();
                    } else if (stock.isEmpty()) {
                        while (!waste.isEmpty()) {
                            stock.addCard(waste.removeCard());
                            stock.top().flip();
                        }
                    }
                } else if (tableau1GUI.contains(mouseClick) && !tableau1.isEmpty()) {
                    if (!tableau1.top().faceUp()) {
                        tableau1.top().flip();
                    }
                } else if (tableau2GUI.contains(mouseClick) && !tableau2.isEmpty()) {
                    if (!tableau2.top().faceUp()) {
                        tableau2.top().flip();
                    }
                } else if (tableau3GUI.contains(mouseClick) && !tableau3.isEmpty()) {
                    if (!tableau3.top().faceUp()) {
                        tableau3.top().flip();
                    }
                } else if (tableau4GUI.contains(mouseClick) && !tableau4.isEmpty()) {
                    if (!tableau4.top().faceUp()) {
                        tableau4.top().flip();
                    }
                } else if (tableau5GUI.contains(mouseClick) && !tableau5.isEmpty()) {
                    if (!tableau5.top().faceUp()) {
                        tableau5.top().flip();
                    }
                } else if (tableau6GUI.contains(mouseClick) && !tableau6.isEmpty()) {
                    if (!tableau6.top().faceUp()) {
                        tableau6.top().flip();
                    }
                } else if (tableau7GUI.contains(mouseClick) && !tableau7.isEmpty()) {
                    if (!tableau7.top().faceUp()) {
                        tableau7.top().flip();
                    }
                }
                repaint();
                mouseClick = null;
            }

            @Override
            public void mousePressed(MouseEvent event) {
                mousePress = event.getPoint();
                if (wasteGUI.contains(mousePress) && !waste.isEmpty()) {
                    from = "waste";
                    if (waste.canRemovePile(1)) {
                        dragPile.addPile(waste.removePile(1));
                    }
                    repaint();

                } else if (tableau1GUI.contains(mousePress) && !tableau1.isEmpty()) {
                    from = "tableau1";
                    if (tableau1.canRemovePile(tableau1GUI.toRemove(mousePress))) {
                        dragPile.addPile(tableau1.removePile(tableau1GUI.toRemove(mousePress)));
                    }
                    repaint();
                } else if (tableau2GUI.contains(mousePress) && !tableau2.isEmpty()) {
                    from = "tableau2";
                    if (tableau2.canRemovePile(tableau2GUI.toRemove(mousePress))) {
                        dragPile.addPile(tableau2.removePile(tableau2GUI.toRemove(mousePress)));
                    }
                    repaint();
                } else if (tableau3GUI.contains(mousePress) && !tableau3.isEmpty()) {
                    from = "tableau3";
                    if (tableau3.canRemovePile(tableau3GUI.toRemove(mousePress))) {
                        dragPile.addPile(tableau3.removePile(tableau3GUI.toRemove(mousePress)));
                    }
                    repaint();
                } else if (tableau4GUI.contains(mousePress) && !tableau4.isEmpty()) {
                    from = "tableau4";
                    if (tableau4.canRemovePile(tableau4GUI.toRemove(mousePress))) {
                        dragPile.addPile(tableau4.removePile(tableau4GUI.toRemove(mousePress)));
                    }
                    repaint();
                } else if (tableau5GUI.contains(mousePress) && !tableau5.isEmpty()) {
                    from = "tableau5";
                    if (tableau5.canRemovePile(tableau5GUI.toRemove(mousePress))) {
                        dragPile.addPile(tableau5.removePile(tableau5GUI.toRemove(mousePress)));
                    }
                    repaint();
                } else if (tableau6GUI.contains(mousePress) && !tableau6.isEmpty()) {
                    from = "tableau6";
                    if (tableau6.canRemovePile(tableau6.size() - 1)) {
                        if (tableau6.canRemovePile(tableau6GUI.toRemove(mousePress))) {
                            dragPile.addPile(tableau6.removePile(tableau6GUI.toRemove(mousePress)));
                        }
                    }
                    repaint();
                } else if (tableau7GUI.contains(mousePress) && !tableau7.isEmpty()) {
                    from = "tableau7";
                    if (tableau7.canRemovePile(tableau7.size() - 1)) {
                        if (tableau7.canRemovePile(tableau7GUI.toRemove(mousePress))) {
                            dragPile.addPile(tableau7.removePile(tableau7GUI.toRemove(mousePress)));
                        }
                    }
                    repaint();
                } else {
                    mousePress = null;
                }
            }

            @Override
            public void mouseReleased(
                    MouseEvent event) {
                mouseReleased = event.getPoint();
                if (dragPile != null) {
                    if (foundation1GUI.contains(mouseReleased)) {
                        if (foundation1.canAdd(dragPile)) {
                            foundation1.addCard(dragPile.top());
                            dragPile.clear();
                        } else {
                            returnPrevious();
                        }
                        resetDrag();
                        repaint();
                    } else if (foundation2GUI.contains(mouseReleased)) {
                        if (foundation2.canAdd(dragPile)) {
                            foundation2.addCard(dragPile.top());
                            dragPile.clear();
                        } else {
                            returnPrevious();
                        }
                        resetDrag();
                        repaint();
                    } else if (foundation3GUI.contains(mouseReleased)) {
                        if (foundation3.canAdd(dragPile)) {
                            foundation3.addCard(dragPile.top());
                            dragPile.clear();
                        } else {
                            returnPrevious();
                        }
                        resetDrag();
                        repaint();
                    } else if (foundation4GUI.contains(mouseReleased)) {
                        if (foundation4.canAdd(dragPile)) {
                            foundation4.addCard(dragPile.top());
                            dragPile.clear();
                        } else {
                            returnPrevious();
                        }
                        resetDrag();
                        repaint();
                    } else if (tableau1GUI.contains(mouseReleased)) {
                        if (tableau1.canAdd(dragPile)) {
                            tableau1.addPile(dragPile);
                            dragPile.clear();
                        } else {
                            returnPrevious();
                        }
                        resetDrag();
                        repaint();
                    } else if (tableau2GUI.contains(mouseReleased)) {
                        if (tableau2.canAdd(dragPile)) {
                            tableau2.addPile(dragPile);
                            dragPile.clear();
                        } else {
                            returnPrevious();
                        }
                        resetDrag();
                        repaint();
                    } else if (tableau3GUI.contains(mouseReleased)) {
                        if (tableau3.canAdd(dragPile)) {
                            tableau3.addPile(dragPile);
                            dragPile.clear();
                        } else {
                            returnPrevious();
                        }
                        resetDrag();
                        repaint();
                    } else if (tableau4GUI.contains(mouseReleased)) {

                        if (tableau4.canAdd(dragPile)) {
                            tableau4.addPile(dragPile);
                            dragPile.clear();
                        } else {
                            returnPrevious();
                        }
                        resetDrag();
                        repaint();
                    } else if (tableau5GUI.contains(mouseReleased)) {
                        if (tableau5.canAdd(dragPile)) {
                            tableau5.addPile(dragPile);
                            dragPile.clear();
                        } else {
                            returnPrevious();
                        }
                        resetDrag();
                        repaint();
                    } else if (tableau6GUI.contains(mouseReleased)) {
                        if (tableau6.canAdd(dragPile)) {
                            tableau6.addPile(dragPile);
                            dragPile.clear();
                        } else {
                            returnPrevious();
                        }
                        resetDrag();
                        repaint();
                    } else if (tableau7GUI.contains(mouseReleased)) {
                        if (tableau7.canAdd(dragPile)) {
                            tableau7.addPile(dragPile);
                        } else {
                            returnPrevious();
                        }
                        resetDrag();
                        repaint();

                    } else {
                        returnPrevious();
                        resetDrag();
                        repaint();
                    }
                }
            }
        });

        this.addMouseMotionListener(new MouseMotionAdapter() {

            @Override
            public void mouseDragged(MouseEvent event) {
                if (mousePress == null) {
                    return;
                }
                tempGUI.setX(event.getX() - 50);
                tempGUI.setY(event.getY() - 40);
                repaint();
            }
        });

        deck.shuffle();
        intTableau();
        intStock();
        intFoundation();
        intWaste();
        intGUI();
    }

    private void buildMenuBar(){
        
    }
    
    
    private void returnPrevious() {
        if (from.equals("waste")) {
            waste.addPile(dragPile);
        } else if (from.equals("tableau1")) {
            tableau1.addPile(dragPile);
        } else if (from.equals("tableau2")) {
            tableau2.addPile(dragPile);
        } else if (from.equals("tableau3")) {
            tableau3.addPile(dragPile);
        } else if (from.equals("tableau4")) {
            tableau4.addPile(dragPile);
        } else if (from.equals("tableau5")) {
            tableau5.addPile(dragPile);
        } else if (from.equals("tableau6")) {
            tableau6.addPile(dragPile);
        } else if (from.equals("tableau7")) {
            tableau7.addPile(dragPile);
        }
    }

    private void resetDrag() {
        dragPile.clear();
        tempGUI.setX(-100);
        tempGUI.setY(0);
    }

    /**
     * Constructs the sock pile and will adds a new deck of cards.
     */
    private void intStock() {
        stock = new StockPile();
        while (iter.hasNext()) {
            stock.addCard(iter.next());
        }
    }

    /**
     * Constructs the Tableau piles of this game.
     */
    private void intTableau() {
        tableau1 = new TableauPile();
        tableau1.addCard(iter.next());
        tableau1.top().flip();

        tableau2 = new TableauPile();
        for (int i = 0; i < 2; i++) {
            tableau2.addCard(iter.next());
        }
        tableau2.top().flip();

        tableau3 = new TableauPile();
        for (int i = 0; i < 3; i++) {
            tableau3.addCard(iter.next());
        }
        tableau3.top().flip();

        tableau4 = new TableauPile();
        for (int i = 0; i < 4; i++) {
            tableau4.addCard(iter.next());
        }
        tableau4.top().flip();

        tableau5 = new TableauPile();
        for (int i = 0; i < 5; i++) {
            tableau5.addCard(iter.next());
        }
        tableau5.top().flip();

        tableau6 = new TableauPile();
        for (int i = 0; i < 6; i++) {
            tableau6.addCard(iter.next());
        }
        tableau6.top().flip();

        tableau7 = new TableauPile();
        for (int i = 0; i < 7; i++) {
            tableau7.addCard(iter.next());
        }
        tableau7.top().flip();
    }

    /**
     * Constructs the foundation piles of this game.
     */
    private void intFoundation() {
        foundation1 = new FoundationPile();
        foundation2 = new FoundationPile();
        foundation3 = new FoundationPile();
        foundation4 = new FoundationPile();
    }

    /**
     * Constructs the waste pile of this game
     */
    private void intWaste() {
        waste = new WastePile();
    }

    /**
     * Constructs the visual aspects of this game.
     */
    private void intGUI() {
        stockGUI = new PileGUI(this, stock, 20, 20);
        wasteGUI = new PileGUI(this, waste, x, 20);
        foundation1GUI = new PileGUI(this, foundation1, x * 3, 20);
        foundation2GUI = new PileGUI(this, foundation2, x * 4, 20);
        foundation3GUI = new PileGUI(this, foundation3, x * 5, 20);
        foundation4GUI = new PileGUI(this, foundation4, x * 6, 20);
        tableau1GUI = new TableauGUI(this, tableau1, 20, y);
        tableau2GUI = new TableauGUI(this, tableau2, x, y);
        tableau3GUI = new TableauGUI(this, tableau3, x * 2, y);
        tableau4GUI = new TableauGUI(this, tableau4, x * 3, y);
        tableau5GUI = new TableauGUI(this, tableau5, x * 4, y);
        tableau6GUI = new TableauGUI(this, tableau6, x * 5, y);
        tableau7GUI = new TableauGUI(this, tableau7, x * 6, y);
        tempGUI = new TableauGUI(this, dragPile, -100, 0);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        stockGUI.paintPile(g);
        wasteGUI.paintPile(g);

        foundation1GUI.paintPile(g);
        foundation2GUI.paintPile(g);
        foundation3GUI.paintPile(g);
        foundation4GUI.paintPile(g);
        tableau1GUI.paintPile(g);
        tableau2GUI.paintPile(g);
        tableau3GUI.paintPile(g);
        tableau4GUI.paintPile(g);
        tableau5GUI.paintPile(g);
        tableau6GUI.paintPile(g);
        tableau7GUI.paintPile(g);
        tempGUI.paintPile(g);
    }
}
