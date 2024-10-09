package simulator;

import game.Game;
import model.Card;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

public class SimulatorGame {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/resources/partidas.txt"))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                Stack<Card> monteInicial = new Stack<>();
                String[] cartas = linha.split(" ");
                for (int i = cartas.length - 1; i >= 0; i--) {
                    monteInicial.push(new Card(cartas[i]));
                }

                Game jogo = new Game(monteInicial);
                String resultado = jogo.play();
                System.out.println(resultado);
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivco: " + e.getMessage());
        }
    }
}
