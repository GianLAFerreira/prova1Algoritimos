package model;


//se nao compilar, é pq vc deve usar java 17 :)))
public record Card(String name) {

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Card card = (Card) obj;
        return name.equals(card.name);
    }
}

/**
 *  ou colque esse implementacao aqui
 *  public class Card {
 *     private String name;
 *
 *     public Card(String name) {
 *         this.name = name;
 *     }
 *
 *     public String getName() {
 *         return name;
 *     }
 *
 *     @Override
 *     public boolean equals(Object obj) {
 *         if (this == obj) return true;
 *         if (!(obj instanceof Card card)) return false;
 *         return name.equals(card.name);
 *     }
 *
 *     @Override
 *     public int hashCode() {
 *         return name.hashCode();
 *     }
 * }
 */
