package player;

import enums.End;
import model.Card;
import model.Table;

import java.util.Stack;

public class Player1 extends AbstractPlayer {

    @Override
    public void playTurn(Table mesa, Stack<Card> mountOfShopping) {
        boolean collected = false;

        for (Card cardOnHand : hand) {
            if (mesa.canCollect(cardOnHand)) {
                boolean collectedRight = mesa.collectCard(cardOnHand, End.RIGHT, this.collected);
                if (!collectedRight) {
                    mesa.collectCard(cardOnHand, End.LEFT, this.collected);
                }
                hand.remove(cardOnHand);
                collected = true;
                break;
            }
        }

        if (!collected) {
            Card cardsForTable = hand.removeFirst();
            mesa.addCard(cardsForTable, End.LEFT);
        }

        if (!mountOfShopping.isEmpty()) {
            addCardOnHand(mountOfShopping.pop());
        }
    }
}

