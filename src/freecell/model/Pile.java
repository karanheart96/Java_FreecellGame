package freecell.model;

import java.util.List;

/**
 * Class to store multiple lists of cards.
 */
public class Pile {
  List<Card> cardlist;
  PileType pile;

  /**
   * Constructur to intialize the pile.
   *
   * @param cardlist The list of cardlists.
   * @param pile     The type of pile.
   */
  Pile(List<Card> cardlist, PileType pile) {
    this.cardlist = cardlist;
    this.pile = pile;
  }
}
