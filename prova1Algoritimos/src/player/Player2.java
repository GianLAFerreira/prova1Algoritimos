package player;

import enums.End;
import model.Card;
import model.Table;

import java.util.List;
import java.util.Stack;

public class Player2 extends AbstractPlayer {

    @Override
    public void playTurn(Table table, Stack<Card> mountOfShopping) {
        boolean collected = false;
        Card chosenCard = null;
        String chosenEnd = null;
        int maxCardsCollected = 0;

        for (Card cardsHand : hand) {
            List<End> endsPossible = table.getEndsCollectible(cardsHand);
            for (End end : endsPossible) {
                int numCardsCollectible = table.getNumberOfCardsCollectibles(cardsHand, end);
                if (numCardsCollectible > maxCardsCollected) {
                    maxCardsCollected = numCardsCollectible;
                    chosenCard = cardsHand;
                    chosenEnd = String.valueOf(end);
                }
            }
        }

        if (chosenCard != null) {
            table.collectCard(chosenCard, End.valueOf(chosenEnd), this.collected);
            hand.remove(chosenCard);
            collected = true;
        }

        if (!collected) {
            Card cartaParaMesa = hand.removeLast();
            table.addCard(cartaParaMesa, End.RIGHT);
        }

        if (!mountOfShopping.isEmpty()) {
            addCardOnHand(mountOfShopping.pop());
        }
    }
}
