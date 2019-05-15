package freecell.model;

/**
 * The class to deonote a single card.
 */
public class Card {
  String value;
  int numericval;
  Cardtype type;
  Cardcolor color;


  /**
   * Constructor to intialize a card object.
   *
   * @param value      The printed string on the card.
   * @param numericval The value in a freecell game.
   * @param type       The type of the card.
   * @param color      The color of the card.
   */
  public Card(String value, int numericval, Cardtype type, Cardcolor color) {
    this.value = value;
    this.numericval = numericval;
    this.type = type;
    this.color = color;
  }

  /**
   * The method to convert the object into String.
   *
   * @return The value and the symbol as a String.
   */
  @Override
  public String toString() {
    return value + symbol(this.type);
  }

  /**
   * Method to convert enum into Unicode for the card type.
   *
   * @param c The type of card.
   * @return The unicode of the type.
   */
  private String symbol(Cardtype c) {
    if (c == Cardtype.HEARTS) {
      return "\u2665";
    } else if (c == Cardtype.DIAMONDS) {
      return "\u2666";
    } else if (c == Cardtype.SPADES) {
      return "\u2660";
    } else if (c == Cardtype.CLUBS) {
      return "\u2663";
    } else {
      return "";
    }
  }


}
