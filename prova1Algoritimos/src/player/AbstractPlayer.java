package player;

import model.Card;
import model.Table;

import java.util.LinkedList;
import java.util.Stack;

public abstract class AbstractPlayer {
    protected LinkedList<Card> hand;
    protected Stack<Card> collected;

    public AbstractPlayer() {
        hand = new LinkedList<>();
        collected = new Stack<>();
    }

    public abstract void playTurn(Table table, Stack<Card> mountOfShopping);

    public void addCardOnHand(Card card) {
        hand.addLast(card);
    }

    public int getNumberOfCardsCollected() {
        return collected.size();
    }
}
