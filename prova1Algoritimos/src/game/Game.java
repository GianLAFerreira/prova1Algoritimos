package game;

import enums.End;
import model.Card;
import model.Table;
import player.AbstractPlayer;
import player.Player1;
import player.Player2;

import java.util.Stack;

public class Game {
    private final Stack<Card> mountOfCards;
    private final Player1 player1;
    private final Player2 player2;
    private final Table table;

    public Game(Stack<Card> monteInicial) {
        this.mountOfCards = monteInicial;
        this.player1 = new Player1();
        this.player2 = new Player2();
        this.table = new Table();
        startGame();
    }

    private void startGame() {
        for (int i = 0; i < 4; i++) {
            player1.addCardOnHand(mountOfCards.pop());
        }
        for (int i = 0; i < 4; i++) {
            player2.addCardOnHand(mountOfCards.pop());
        }
        for (int i = 0; i < 4; i++) {
            table.addCard(mountOfCards.pop(), End.RIGHT);
        }
    }

    public String play() {
        boolean turnoJogador1 = true;
        while (!mountOfCards.isEmpty()) {
            if (turnoJogador1) {
                performShift(player1);
            } else {
                performShift(player2);
            }
            turnoJogador1 = !turnoJogador1;
        }
        return determineWinner();
    }

    private void performShift(AbstractPlayer abstractPlayer) {
        abstractPlayer.playTurn(table, mountOfCards);
        if (!mountOfCards.isEmpty()) {
            table.addCard(mountOfCards.pop(), End.RIGHT);
        }
    }

    private String determineWinner() {
        int cardsPlayer1 = player1.getNumberOfCardsCollected();
        int cardsPlayer2 = player2.getNumberOfCardsCollected();

        if (cardsPlayer1 > cardsPlayer2) {
            return cardsPlayer1 + " x " + cardsPlayer2 + " : Jogador 1 venceu";
        } else if (cardsPlayer2 > cardsPlayer1) {
            return cardsPlayer1 + " x " + cardsPlayer2 + " : Jogador 2 venceu";
        } else {
            return cardsPlayer1 + " x " + cardsPlayer2 + " : Empate";
        }
    }
}
