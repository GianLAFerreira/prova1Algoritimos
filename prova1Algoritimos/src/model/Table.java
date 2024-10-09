package model;

import enums.End;
import java.util.*;

public class Table {
    private Deque<Card> cardsOnTheTable;

    public Table() {
        cardsOnTheTable = new ArrayDeque<>();
    }

    public void addCard(Card card, End end) {
        if (end == End.LEFT) {
            cardsOnTheTable.addFirst(card);
        } else {
            cardsOnTheTable.addLast(card);
        }
    }

    public boolean canCollect(Card card) {
        return card.equals(cardsOnTheTable.peekFirst()) || card.equals(cardsOnTheTable.peekLast());
    }

    public boolean collectCard(Card card, End end, Stack<Card> collected) {
        if (end == null) {
            return false;
        }

        boolean collectedAny = false;
        Deque<Card> tempDeque = new ArrayDeque<>();

        while (!cardsOnTheTable.isEmpty()) {
            Card extremityCard = (end == End.RIGHT) ? cardsOnTheTable.peekLast() : cardsOnTheTable.peekFirst();

            if (!card.equals(extremityCard)) {
                break;
            }

            Card removedCard = (end == End.RIGHT) ? cardsOnTheTable.pollLast() : cardsOnTheTable.pollFirst();
            collected.push(removedCard);
            collectedAny = true;
        }

        return collectedAny;
    }

    public List<End> getEndsCollectible(Card card) {
        List<End> extremities = new ArrayList<>();
        if (card.equals(cardsOnTheTable.peekFirst())) {
            extremities.add(End.LEFT);
        }
        if (card.equals(cardsOnTheTable.peekLast())) {
            extremities.add(End.RIGHT);
        }
        return extremities;
    }

    public int getNumberOfCardsCollectibles(Card card, End end) {
        if (end == null) {
            return 0;
        }

        Iterator<Card> iterator = (end == End.LEFT) ? cardsOnTheTable.iterator() : cardsOnTheTable.descendingIterator();
        int count = 0;

        while (iterator.hasNext()) {
            Card c = iterator.next();
            if (c.equals(card)) {
                count++;
            } else {
                break;
            }
        }

        return count;
    }
}

