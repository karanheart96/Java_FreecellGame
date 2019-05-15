import org.junit.Test;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import freecell.model.Card;
import freecell.model.Cardcolor;
import freecell.model.Cardtype;
import freecell.model.FreecellModel;
import freecell.model.FreecellOperations;
import freecell.model.PileType;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;


public class FreecellModelTest {


  @Test
  public void invalidmoves() {
    FreecellOperations model = FreecellModel
            .getBuilder()
            .cascades(6)
            .opens(4)
            .build();
    List<Card> a = model.getDeck();
    model.startGame(a, false);
    assertEquals("F1:\n" +
            "F2:\n" +
            "F3:\n" +
            "F4:\n" +
            "O1:\n" +
            "O2:\n" +
            "O3:\n" +
            "O4:\n" +
            "C1: A♣, 7♣, K♣, 6♦, Q♦, 5♥, J♥, 4♠, 10♠\n" +
            "C2: 2♣, 8♣, A♦, 7♦, K♦, 6♥, Q♥, 5♠, J♠\n" +
            "C3: 3♣, 9♣, 2♦, 8♦, A♥, 7♥, K♥, 6♠, Q♠\n" +
            "C4: 4♣, 10♣, 3♦, 9♦, 2♥, 8♥, A♠, 7♠, K♠\n" +
            "C5: 5♣, J♣, 4♦, 10♦, 3♥, 9♥, 2♠, 8♠\n" +
            "C6: 6♣, Q♣, 5♦, J♦, 4♥, 10♥, 3♠, 9♠", model.getGameState());
    System.out.println(model.getGameState());
    try {
      model.move(PileType.OPEN, 0, 0, PileType.OPEN, 2);
    } catch (IllegalArgumentException e) {
      e.printStackTrace();
    }
    try {
      model.move(PileType.FOUNDATION, 0, 0, PileType.FOUNDATION, 2);
    } catch (IllegalArgumentException e) {
      e.printStackTrace();
    }
    try {
      model.move(PileType.OPEN, 5, 0, PileType.OPEN, 2);
    } catch (IllegalArgumentException e) {
      e.printStackTrace();
    }
    try {
      model.move(PileType.CASCADE, 0, 0, PileType.OPEN, 6);
    } catch (IllegalArgumentException e) {
      e.printStackTrace();
    }
    try {
      model.move(PileType.CASCADE, 0, 8, PileType.OPEN, 2);
      model.move(PileType.CASCADE, 0, 7, PileType.OPEN, 2);
    } catch (IllegalArgumentException e) {
      e.printStackTrace();
    }
    try {
      model.move(PileType.CASCADE, 1, 8, PileType.FOUNDATION, 0);
      model.move(PileType.CASCADE, 1, 8, PileType.FOUNDATION, 1);
      model.move(PileType.CASCADE, 1, 8, PileType.FOUNDATION, 2);
      model.move(PileType.CASCADE, 1, 8, PileType.FOUNDATION, 3);
    } catch (IllegalArgumentException e) {
      e.printStackTrace();
    }
    try {
      model.move(PileType.CASCADE, 3, 8, PileType.OPEN, 0);
      model.move(PileType.CASCADE, 3, 7, PileType.OPEN, 1);
      model.move(PileType.CASCADE, 3, 6, PileType.FOUNDATION, 0);
      model.move(PileType.CASCADE, 1, 5, PileType.FOUNDATION, 0);
      model.move(PileType.CASCADE, 4, 7, PileType.OPEN, 3);
    } catch (IllegalArgumentException e) {
      e.printStackTrace();
    }
    try {
      model.move(PileType.CASCADE, 4, 7, PileType.OPEN, 3);
      model.move(PileType.CASCADE, 4, 6, PileType.FOUNDATION, 0);
      model.move(PileType.FOUNDATION, 0, 1, PileType.FOUNDATION, 1);
    } catch (IllegalArgumentException e) {
      e.printStackTrace();
    }
    try {
      model.move(PileType.CASCADE, 7, 7, PileType.OPEN, 0);
    } catch (IllegalArgumentException e) {
      e.printStackTrace();
    }
    try {
      model.move(PileType.CASCADE, 0, 7, PileType.CASCADE, 4);
    } catch (IllegalArgumentException e) {
      e.printStackTrace();
    }
    try {
      model.move(PileType.FOUNDATION, 0, 1, PileType.FOUNDATION, 1);
    } catch (IllegalArgumentException e) {
      e.printStackTrace();
    }

  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMoveWhenSourceEmpty() {
    FreecellOperations model = FreecellModel
            .getBuilder()
            .cascades(6)
            .opens(4)
            .build();
    List<Card> a = model.getDeck();
    model.startGame(a, false);
    model.move(PileType.OPEN, 0, 0, PileType.OPEN, 2);

  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMove2() {
    FreecellOperations model = FreecellModel
            .getBuilder()
            .cascades(6)
            .opens(4)
            .build();
    List<Card> a = model.getDeck();
    model.startGame(a, false);
    model.move(PileType.FOUNDATION, 0, 0, PileType.FOUNDATION, 2);

  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMove3() {
    FreecellOperations model = FreecellModel
            .getBuilder()
            .cascades(6)
            .opens(4)
            .build();
    List<Card> a = model.getDeck();
    model.startGame(a, false);
    model.move(PileType.OPEN, 5, 0, PileType.OPEN, 2);

  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMove4() {
    FreecellOperations model = FreecellModel
            .getBuilder()
            .cascades(6)
            .opens(4)
            .build();
    List<Card> a = model.getDeck();
    model.startGame(a, false);
    model.move(PileType.CASCADE, 0, 0, PileType.OPEN, 6);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMoveMovingFromBetween() {
    FreecellOperations model = FreecellModel
            .getBuilder()
            .cascades(6)
            .opens(4)
            .build();
    List<Card> a = model.getDeck();
    model.startGame(a, false);
    model.move(PileType.CASCADE, 0, 4, PileType.OPEN, 6);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMoveMovingOnSameColor() {
    FreecellOperations model = FreecellModel
            .getBuilder()
            .cascades(52)
            .opens(52)
            .build();
    List<Card> a = model.getDeck();
    model.startGame(a, false);
    System.out.println(model.getGameState());
    model.move(PileType.CASCADE, 21, 0, PileType.CASCADE, 22);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMoveMovingOnWrongNumber() {
    FreecellOperations model = FreecellModel
            .getBuilder()
            .cascades(6)
            .opens(4)
            .build();
    List<Card> a = model.getDeck();
    model.startGame(a, false);
    model.move(PileType.CASCADE, 48, 4, PileType.CASCADE, 37);
  }


  @Test
  public void getDeckCorrectDeck() {
    FreecellOperations model = FreecellModel
            .getBuilder()
            .cascades(6)
            .opens(4)
            .build();

    List<Card> deck = model.getDeck();
    assertEquals(52, deck.size());
    String current_card = "";
    int hearts = 0;
    int clubs = 0;
    int diamonds = 0;
    int spades = 0;
    Map<String, Integer> numbers = new HashMap<>();
    numbers.put("A", 0);
    numbers.put("2", 0);
    numbers.put("3", 0);
    numbers.put("4", 0);
    numbers.put("5", 0);
    numbers.put("6", 0);
    numbers.put("7", 0);
    numbers.put("8", 0);
    numbers.put("9", 0);
    numbers.put("10", 0);
    numbers.put("J", 0);
    numbers.put("Q", 0);
    numbers.put("K", 0);
    String key = "";
    for (int i = 0; i < deck.size(); i++) {
      current_card = deck.get(i).toString();

      switch (current_card.charAt(current_card.length() - 1)) {
        case '\u2665': {
          hearts++;
          break;
        }
        case '\u2666': {
          diamonds++;
          break;
        }
        case '\u2660': {
          spades++;
          break;
        }
        case '\u2663': {
          clubs++;
          break;
        }
        default: {
          throw new IllegalArgumentException("Invalid suite");
        }

      }
      key = current_card.substring(0, current_card.length() - 1);
      numbers.put(key, numbers.get(key)
              + 1);

    }

    assertEquals(hearts, 13);
    assertEquals(clubs, 13);
    assertEquals(diamonds, 13);
    assertEquals(spades, 13);

    for (String key1 : numbers.keySet()) {
      assertEquals(4, (long) numbers.get(key1));
    }
  }


  @Test
  public void startGameCorrectUnshuffled() {

    // cascade = 6 and open = 4
    FreecellOperations model = FreecellModel
            .getBuilder()
            .cascades(6)
            .opens(4)
            .build();

    List<Card> deck = model.getDeck();
    model.startGame(deck, false);
    assertEquals("F1:\n"

            + "F2:\n"

            + "F3:\n"

            + "F4:\n"

            + "O1:\n"

            + "O2:\n"

            + "O3:\n"

            + "O4:\n"

            + "C1: A♣, 7♣, K♣, 6♦, Q♦, 5♥, J♥, 4♠, 10♠\n"

            + "C2: 2♣, 8♣, A♦, 7♦, K♦, 6♥, Q♥, 5♠, J♠\n"

            + "C3: 3♣, 9♣, 2♦, 8♦, A♥, 7♥, K♥, 6♠, Q♠\n"

            + "C4: 4♣, 10♣, 3♦, 9♦, 2♥, 8♥, A♠, 7♠, K♠\n"

            + "C5: 5♣, J♣, 4♦, 10♦, 3♥, 9♥, 2♠, 8♠\n"

            + "C6: 6♣, Q♣, 5♦, J♦, 4♥, 10♥, 3♠, 9♠", model.getGameState());

  }

  @Test
  public void startGameCorrectShuffled() {
    // cascade = 6 and open = 4
    FreecellOperations model = FreecellModel
            .getBuilder()
            .cascades(6)
            .opens(4)
            .build();

    List<Card> deck = model.getDeck();
    model.startGame(deck, true);
    assertEquals("F1:\n"

            + "F2:\n"

            + "F3:\n"

            + "F4:\n"

            + "O1:\n"

            + "O2:\n"

            + "O3:\n"

            + "O4:\n"

            + "C1: 9♠, K♠, 10♠, 4♠, 8♣, 7♣, 2♥, A♥, 3♣\n"

            + "C2: Q♦, 10♣, J♣, 8♦, A♦, 9♣, 5♦, 7♠, 4♥\n"

            + "C3: K♦, J♦, 6♥, Q♥, K♥, 7♥, Q♠, 9♦, 3♥\n"

            + "C4: J♥, 6♣, 5♥, 8♠, 2♠, 4♣, 8♥, 10♥, 6♠\n"

            + "C5: 3♦, 9♥, A♠, 2♣, 7♦, A♣, 4♦, 10♦\n"

            + "C6: 5♠, 6♦, 3♠, K♣, 2♦, 5♣, J♠, Q♣", model.getGameState());

  }

  @Test(expected = IllegalArgumentException.class)
  public void startGameIncorrectDeck() {
    FreecellOperations model = FreecellModel
            .getBuilder()
            .cascades(6)
            .opens(4)
            .build();

    List<Card> deck = model.getDeck();
    model.startGame(new ArrayList<Integer>(), true);
  }

  @Test(expected = IllegalArgumentException.class)
  public void startGameDuplicateCard() {
    FreecellOperations model = FreecellModel
            .getBuilder()
            .cascades(6)
            .opens(4)
            .build();

    List<Card> deck = model.getDeck();

    deck.add(new Card("A", 1, Cardtype.SPADES, Cardcolor.BLACK));
    model.startGame(deck, true);
  }

  @Test(expected = IllegalArgumentException.class)
  public void startGameLessCards() {
    FreecellOperations model = FreecellModel
            .getBuilder()
            .cascades(6)
            .opens(4)
            .build();

    List<Card> deck = model.getDeck();
    deck.remove(0);
    model.startGame(deck, true);
  }

  @Test
  public void moveALLValidMoves() {
    FreecellOperations model = FreecellModel
            .getBuilder()
            .cascades(52)
            .opens(52)
            .build();
    List<Card> deck = model.getDeck();
    model.startGame(deck, false);

    // CASCADE TO OPEN
    model.move(PileType.CASCADE, 1, 0, PileType.OPEN, 0);
    assertEquals("F1:\n"

                    +
                    "F2:\n"

                    +
                    "F3:\n"

                    +
                    "F4:\n"
                    +
                    "O1: 2♣\n"
                    +
                    "O2:\n"
                    +
                    "O3:\n"
                    +
                    "O4:\n"
                    +
                    "O5:\n"
                    +
                    "O6:\n"
                    +
                    "O7:\n"
                    +
                    "O8:\n"
                    +
                    "O9:\n"
                    +
                    "O10:\n"
                    +
                    "O11:\n"
                    +
                    "O12:\n"
                    +
                    "O13:\n"
                    +
                    "O14:\n"
                    +
                    "O15:\n"
                    +
                    "O16:\n"
                    +
                    "O17:\n"
                    +
                    "O18:\n"
                    +
                    "O19:\n"
                    +
                    "O20:\n"
                    +
                    "O21:\n"
                    +
                    "O22:\n"
                    +
                    "O23:\n"
                    +
                    "O24:\n"
                    +
                    "O25:\n"
                    +
                    "O26:\n"
                    +
                    "O27:\n"
                    +
                    "O28:\n"
                    +
                    "O29:\n"
                    +
                    "O30:\n"
                    +
                    "O31:\n"
                    +
                    "O32:\n"
                    +
                    "O33:\n"
                    +
                    "O34:\n"
                    +
                    "O35:\n"
                    +
                    "O36:\n"
                    +
                    "O37:\n"
                    +
                    "O38:\n"
                    +
                    "O39:\n"
                    +
                    "O40:\n"
                    +
                    "O41:\n"
                    +
                    "O42:\n"
                    +
                    "O43:\n"
                    +
                    "O44:\n"
                    +
                    "O45:\n"
                    +
                    "O46:\n"
                    +
                    "O47:\n"
                    +
                    "O48:\n"
                    +
                    "O49:\n"
                    +
                    "O50:\n"
                    +
                    "O51:\n"
                    +
                    "O52:\n"
                    +
                    "C1: A♣\n"
                    +
                    "C2:\n"
                    +
                    "C3: 3♣\n"
                    +
                    "C4: 4♣\n"
                    +
                    "C5: 5♣\n"
                    +
                    "C6: 6♣\n"
                    +
                    "C7: 7♣\n"
                    +
                    "C8: 8♣\n"
                    +
                    "C9: 9♣\n"
                    +
                    "C10: 10♣\n"
                    +
                    "C11: J♣\n"
                    +
                    "C12: Q♣\n"
                    +
                    "C13: K♣\n"
                    +
                    "C14: A♦\n"
                    +
                    "C15: 2♦\n"
                    +
                    "C16: 3♦\n"
                    +
                    "C17: 4♦\n"
                    +
                    "C18: 5♦\n"
                    +
                    "C19: 6♦\n"
                    +
                    "C20: 7♦\n"
                    +
                    "C21: 8♦\n"
                    +
                    "C22: 9♦\n"
                    +
                    "C23: 10♦\n"
                    +
                    "C24: J♦\n"
                    +
                    "C25: Q♦\n"
                    +
                    "C26: K♦\n"
                    +
                    "C27: A♥\n"
                    +
                    "C28: 2♥\n"
                    +
                    "C29: 3♥\n"
                    +
                    "C30: 4♥\n"
                    +
                    "C31: 5♥\n"
                    +
                    "C32: 6♥\n"
                    +
                    "C33: 7♥\n"
                    +
                    "C34: 8♥\n"
                    +
                    "C35: 9♥\n"
                    +
                    "C36: 10♥\n"
                    +
                    "C37: J♥\n"
                    +
                    "C38: Q♥\n"
                    +
                    "C39: K♥\n"
                    +
                    "C40: A♠\n"
                    +
                    "C41: 2♠\n"
                    +
                    "C42: 3♠\n"
                    +
                    "C43: 4♠\n"
                    +
                    "C44: 5♠\n"
                    +
                    "C45: 6♠\n"
                    +
                    "C46: 7♠\n"
                    +
                    "C47: 8♠\n"
                    +
                    "C48: 9♠\n"
                    +
                    "C49: 10♠\n"
                    +
                    "C50: J♠\n"
                    +
                    "C51: Q♠\n"
                    +
                    "C52: K♠"
            , model.getGameState());

    // CASCADE TO FOUNDATION
    model.move(PileType.CASCADE, 0, 0, PileType.FOUNDATION, 0);
    assertEquals("F1: A♣\n"
            +
            "F2:\n"
            +
            "F3:\n"
            +
            "F4:\n"
            +
            "O1: 2♣\n"
            +
            "O2:\n"
            +
            "O3:\n"
            +
            "O4:\n"
            +
            "O5:\n"
            +
            "O6:\n"
            +
            "O7:\n"
            +
            "O8:\n"
            +
            "O9:\n"
            +
            "O10:\n"
            +
            "O11:\n"
            +
            "O12:\n"
            +
            "O13:\n"
            +
            "O14:\n"
            +
            "O15:\n"
            +
            "O16:\n"
            +
            "O17:\n"
            +
            "O18:\n"
            +
            "O19:\n"
            +
            "O20:\n"
            +
            "O21:\n"
            +
            "O22:\n"
            +
            "O23:\n"
            +
            "O24:\n"
            +
            "O25:\n"
            +
            "O26:\n"
            +
            "O27:\n"
            +
            "O28:\n"
            +
            "O29:\n"
            +
            "O30:\n"
            +
            "O31:\n"
            +
            "O32:\n"
            +
            "O33:\n"
            +
            "O34:\n"
            +
            "O35:\n"
            +
            "O36:\n"
            +
            "O37:\n"
            +
            "O38:\n"
            +
            "O39:\n"
            +
            "O40:\n"
            +
            "O41:\n"
            +
            "O42:\n"
            +
            "O43:\n"
            +
            "O44:\n"
            +
            "O45:\n"
            +
            "O46:\n"
            +
            "O47:\n"
            +
            "O48:\n"
            +
            "O49:\n"
            +
            "O50:\n"
            +
            "O51:\n"
            +
            "O52:\n"
            +
            "C1:\n"
            +
            "C2:\n"
            +
            "C3: 3♣\n"
            +
            "C4: 4♣\n"
            +
            "C5: 5♣\n"
            +
            "C6: 6♣\n"
            +
            "C7: 7♣\n"
            +
            "C8: 8♣\n"
            +
            "C9: 9♣\n"
            +
            "C10: 10♣\n"
            +
            "C11: J♣\n"
            +
            "C12: Q♣\n"
            +
            "C13: K♣\n"
            +
            "C14: A♦\n"
            +
            "C15: 2♦\n"
            +
            "C16: 3♦\n"
            +
            "C17: 4♦\n"
            +
            "C18: 5♦\n"
            +
            "C19: 6♦\n"
            +
            "C20: 7♦\n"
            +
            "C21: 8♦\n"
            +
            "C22: 9♦\n"
            +
            "C23: 10♦\n"
            +
            "C24: J♦\n"
            +
            "C25: Q♦\n"
            +
            "C26: K♦\n"
            +
            "C27: A♥\n"
            +
            "C28: 2♥\n"
            +
            "C29: 3♥\n"
            +
            "C30: 4♥\n"
            +
            "C31: 5♥\n"
            +
            "C32: 6♥\n"
            +
            "C33: 7♥\n"
            +
            "C34: 8♥\n"
            +
            "C35: 9♥\n"
            +
            "C36: 10♥\n"
            +
            "C37: J♥\n"
            +
            "C38: Q♥\n"
            +
            "C39: K♥\n"
            +
            "C40: A♠\n"
            +
            "C41: 2♠\n"
            +
            "C42: 3♠\n"
            +
            "C43: 4♠\n"
            +
            "C44: 5♠\n"
            +
            "C45: 6♠\n"
            +
            "C46: 7♠\n"
            +
            "C47: 8♠\n"
            +
            "C48: 9♠\n"
            +
            "C49: 10♠\n"
            +
            "C50: J♠\n"
            +
            "C51: Q♠\n"
            +
            "C52: K♠", model.getGameState());

    // CASCADE TO CASCADE
    model.move(PileType.CASCADE, 2, 0, PileType.CASCADE, 29);
    assertEquals("F1: A♣\n"
            +
            "F2:\n"
            +
            "F3:\n"
            +
            "F4:\n"
            +
            "O1: 2♣\n"
            +
            "O2:\n"
            +
            "O3:\n"
            +
            "O4:\n"
            +
            "O5:\n"
            +
            "O6:\n"
            +
            "O7:\n"
            +
            "O8:\n"
            +
            "O9:\n"
            +
            "O10:\n"
            +
            "O11:\n"
            +
            "O12:\n"
            +
            "O13:\n"
            +
            "O14:\n"
            +
            "O15:\n"
            +
            "O16:\n"
            +
            "O17:\n"
            +
            "O18:\n"
            +
            "O19:\n"
            +
            "O20:\n"
            +
            "O21:\n"
            +
            "O22:\n"
            +
            "O23:\n"
            +
            "O24:\n"
            +
            "O25:\n"
            +
            "O26:\n"
            +
            "O27:\n"
            +
            "O28:\n"
            +
            "O29:\n"
            +
            "O30:\n"
            +
            "O31:\n"
            +
            "O32:\n"
            +
            "O33:\n"
            +
            "O34:\n"
            +
            "O35:\n"
            +
            "O36:\n"
            +
            "O37:\n"
            +
            "O38:\n"
            +
            "O39:\n"
            +
            "O40:\n"
            +
            "O41:\n"
            +
            "O42:\n"
            +
            "O43:\n"
            +
            "O44:\n"
            +
            "O45:\n"
            +
            "O46:\n"
            +
            "O47:\n"
            +
            "O48:\n"
            +
            "O49:\n"
            +
            "O50:\n"
            +
            "O51:\n"
            +
            "O52:\n"
            +
            "C1:\n"
            +
            "C2:\n"
            +
            "C3:\n"
            +
            "C4: 4♣\n"
            +
            "C5: 5♣\n"
            +
            "C6: 6♣\n"
            +
            "C7: 7♣\n"
            +
            "C8: 8♣\n"
            +
            "C9: 9♣\n"
            +
            "C10: 10♣\n"
            +
            "C11: J♣\n"
            +
            "C12: Q♣\n"
            +
            "C13: K♣\n"
            +
            "C14: A♦\n"
            +
            "C15: 2♦\n"
            +
            "C16: 3♦\n"
            +
            "C17: 4♦\n"
            +
            "C18: 5♦\n"
            +
            "C19: 6♦\n"
            +
            "C20: 7♦\n"
            +
            "C21: 8♦\n"
            +
            "C22: 9♦\n"
            +
            "C23: 10♦\n"
            +
            "C24: J♦\n"
            +
            "C25: Q♦\n"
            +
            "C26: K♦\n"
            +
            "C27: A♥\n"
            +
            "C28: 2♥\n"
            +
            "C29: 3♥\n"
            +
            "C30: 4♥, 3♣\n"
            +
            "C31: 5♥\n"
            +
            "C32: 6♥\n"
            +
            "C33: 7♥\n"
            +
            "C34: 8♥\n"
            +
            "C35: 9♥\n"
            +
            "C36: 10♥\n"
            +
            "C37: J♥\n"
            +
            "C38: Q♥\n"
            +
            "C39: K♥\n"
            +
            "C40: A♠\n"
            +
            "C41: 2♠\n"
            +
            "C42: 3♠\n"
            +
            "C43: 4♠\n"
            +
            "C44: 5♠\n"
            +
            "C45: 6♠\n"
            +
            "C46: 7♠\n"
            +
            "C47: 8♠\n"
            +
            "C48: 9♠\n"
            +
            "C49: 10♠\n"
            +
            "C50: J♠\n"
            +
            "C51: Q♠\n"
            +
            "C52: K♠", model.getGameState());

    // OPEN TO CASCADE
    model.move(PileType.CASCADE, 3, 0, PileType.OPEN, 51);
    model.move(PileType.OPEN, 51, 0, PileType.CASCADE, 1);
    assertEquals("F1: A♣\n"
            +
            "F2:\n"
            +
            "F3:\n"
            +
            "F4:\n"
            +
            "O1: 2♣\n"
            +
            "O2:\n"
            +
            "O3:\n"
            +
            "O4:\n"
            +
            "O5:\n"
            +
            "O6:\n"
            +
            "O7:\n"
            +
            "O8:\n"
            +
            "O9:\n"
            +
            "O10:\n"
            +
            "O11:\n"
            +
            "O12:\n"
            +
            "O13:\n"
            +
            "O14:\n"
            +
            "O15:\n"
            +
            "O16:\n"
            +
            "O17:\n"
            +
            "O18:\n"
            +
            "O19:\n"
            +
            "O20:\n"
            +
            "O21:\n"
            +
            "O22:\n"
            +
            "O23:\n"
            +
            "O24:\n"
            +
            "O25:\n"
            +
            "O26:\n"
            +
            "O27:\n"
            +
            "O28:\n"
            +
            "O29:\n"
            +
            "O30:\n"
            +
            "O31:\n"
            +
            "O32:\n"
            +
            "O33:\n"
            +
            "O34:\n"
            +
            "O35:\n"
            +
            "O36:\n"
            +
            "O37:\n"
            +
            "O38:\n"
            +
            "O39:\n"
            +
            "O40:\n"
            +
            "O41:\n"
            +
            "O42:\n"
            +
            "O43:\n"
            +
            "O44:\n"
            +
            "O45:\n"
            +
            "O46:\n"
            +
            "O47:\n"
            +
            "O48:\n"
            +
            "O49:\n"
            +
            "O50:\n"
            +
            "O51:\n"
            +
            "O52:\n"
            +
            "C1:\n"
            +
            "C2: 4♣\n"
            +
            "C3:\n"
            +
            "C4:\n"
            +
            "C5: 5♣\n"
            +
            "C6: 6♣\n"
            +
            "C7: 7♣\n"
            +
            "C8: 8♣\n"
            +
            "C9: 9♣\n"
            +
            "C10: 10♣\n"
            +
            "C11: J♣\n"
            +
            "C12: Q♣\n"
            +
            "C13: K♣\n"
            +
            "C14: A♦\n"
            +
            "C15: 2♦\n"
            +
            "C16: 3♦\n"
            +
            "C17: 4♦\n"
            +
            "C18: 5♦\n"
            +
            "C19: 6♦\n"
            +
            "C20: 7♦\n"
            +
            "C21: 8♦\n"
            +
            "C22: 9♦\n"
            +
            "C23: 10♦\n"
            +
            "C24: J♦\n"
            +
            "C25: Q♦\n"
            +
            "C26: K♦\n"
            +
            "C27: A♥\n"
            +
            "C28: 2♥\n"
            +
            "C29: 3♥\n"
            +
            "C30: 4♥, 3♣\n"
            +
            "C31: 5♥\n"
            +
            "C32: 6♥\n"
            +
            "C33: 7♥\n"
            +
            "C34: 8♥\n"
            +
            "C35: 9♥\n"
            +
            "C36: 10♥\n"
            +
            "C37: J♥\n"
            +
            "C38: Q♥\n"
            +
            "C39: K♥\n"
            +
            "C40: A♠\n"
            +
            "C41: 2♠\n"
            +
            "C42: 3♠\n"
            +
            "C43: 4♠\n"
            +
            "C44: 5♠\n"
            +
            "C45: 6♠\n"
            +
            "C46: 7♠\n"
            +
            "C47: 8♠\n"
            +
            "C48: 9♠\n"
            +
            "C49: 10♠\n"
            +
            "C50: J♠\n"
            +
            "C51: Q♠\n"
            +
            "C52: K♠", model.getGameState());
    // OPEN TO FOUNDATION
    model.move(PileType.CASCADE, 26, 0, PileType.OPEN, 51);
    model.move(PileType.OPEN, 51, 0, PileType.FOUNDATION, 1);
    assertEquals("F1: A♣\n"
            +
            "F2: A♥\n"
            +
            "F3:\n"
            +
            "F4:\n"
            +
            "O1: 2♣\n"
            +
            "O2:\n"
            +
            "O3:\n"
            +
            "O4:\n"
            +
            "O5:\n"
            +
            "O6:\n"
            +
            "O7:\n"
            +
            "O8:\n"
            +
            "O9:\n"
            +
            "O10:\n"
            +
            "O11:\n"
            +
            "O12:\n"
            +
            "O13:\n"
            +
            "O14:\n"
            +
            "O15:\n"
            +
            "O16:\n"
            +
            "O17:\n"
            +
            "O18:\n"
            +
            "O19:\n"
            +
            "O20:\n"
            +
            "O21:\n"
            +
            "O22:\n"
            +
            "O23:\n"
            +
            "O24:\n"
            +
            "O25:\n"
            +
            "O26:\n"
            +
            "O27:\n"
            +
            "O28:\n"
            +
            "O29:\n"
            +
            "O30:\n"
            +
            "O31:\n"
            +
            "O32:\n"
            +
            "O33:\n"
            +
            "O34:\n"
            +
            "O35:\n"
            +
            "O36:\n"
            +
            "O37:\n"
            +
            "O38:\n"
            +
            "O39:\n"
            +
            "O40:\n"
            +
            "O41:\n"
            +
            "O42:\n"
            +
            "O43:\n"
            +
            "O44:\n"
            +
            "O45:\n"
            +
            "O46:\n"
            +
            "O47:\n"
            +
            "O48:\n"
            +
            "O49:\n"
            +
            "O50:\n"
            +
            "O51:\n"
            +
            "O52:\n"
            +
            "C1:\n"
            +
            "C2: 4♣\n"
            +
            "C3:\n"
            +
            "C4:\n"
            +
            "C5: 5♣\n"
            +
            "C6: 6♣\n"
            +
            "C7: 7♣\n"
            +
            "C8: 8♣\n"
            +
            "C9: 9♣\n"
            +
            "C10: 10♣\n"
            +
            "C11: J♣\n"
            +
            "C12: Q♣\n"
            +
            "C13: K♣\n"
            +
            "C14: A♦\n"
            +
            "C15: 2♦\n"
            +
            "C16: 3♦\n"
            +
            "C17: 4♦\n"
            +
            "C18: 5♦\n"
            +
            "C19: 6♦\n"
            +
            "C20: 7♦\n"
            +
            "C21: 8♦\n"
            +
            "C22: 9♦\n"
            +
            "C23: 10♦\n"
            +
            "C24: J♦\n"
            +
            "C25: Q♦\n"
            +
            "C26: K♦\n"
            +
            "C27:\n"
            +
            "C28: 2♥\n"
            +
            "C29: 3♥\n"
            +
            "C30: 4♥, 3♣\n"
            +
            "C31: 5♥\n"
            +
            "C32: 6♥\n"
            +
            "C33: 7♥\n"
            +
            "C34: 8♥\n"
            +
            "C35: 9♥\n"
            +
            "C36: 10♥\n"
            +
            "C37: J♥\n"
            +
            "C38: Q♥\n"
            +
            "C39: K♥\n"
            +
            "C40: A♠\n"
            +
            "C41: 2♠\n"
            +
            "C42: 3♠\n"
            +
            "C43: 4♠\n"
            +
            "C44: 5♠\n"
            +
            "C45: 6♠\n"
            +
            "C46: 7♠\n"
            +
            "C47: 8♠\n"
            +
            "C48: 9♠\n"
            +
            "C49: 10♠\n"
            +
            "C50: J♠\n"
            +
            "C51: Q♠\n"
            +
            "C52: K♠", model.getGameState());


    // OPEN TO OPEN
    model.move(PileType.CASCADE, 1, 0, PileType.OPEN, 51);
    model.move(PileType.OPEN, 51, 0, PileType.OPEN, 50);
    assertEquals("F1: A♣\n"
            +
            "F2: A♥\n"
            +
            "F3:\n"
            +
            "F4:\n"
            +
            "O1: 2♣\n"
            +
            "O2:\n"
            +
            "O3:\n"
            +
            "O4:\n"
            +
            "O5:\n"
            +
            "O6:\n"
            +
            "O7:\n"
            +
            "O8:\n"
            +
            "O9:\n"
            +
            "O10:\n"
            +
            "O11:\n"
            +
            "O12:\n"
            +
            "O13:\n"
            +
            "O14:\n"
            +
            "O15:\n"
            +
            "O16:\n"
            +
            "O17:\n"
            +
            "O18:\n"
            +
            "O19:\n"
            +
            "O20:\n"
            +
            "O21:\n"
            +
            "O22:\n"
            +
            "O23:\n"
            +
            "O24:\n"
            +
            "O25:\n"
            +
            "O26:\n"
            +
            "O27:\n"
            +
            "O28:\n"
            +
            "O29:\n"
            +
            "O30:\n"
            +
            "O31:\n"
            +
            "O32:\n"
            +
            "O33:\n"
            +
            "O34:\n"
            +
            "O35:\n"
            +
            "O36:\n"
            +
            "O37:\n"
            +
            "O38:\n"
            +
            "O39:\n"
            +
            "O40:\n"
            +
            "O41:\n"
            +
            "O42:\n"
            +
            "O43:\n"
            +
            "O44:\n"
            +
            "O45:\n"
            +
            "O46:\n"
            +
            "O47:\n"
            +
            "O48:\n"
            +
            "O49:\n"
            +
            "O50:\n"
            +
            "O51: 4♣\n"
            +
            "O52:\n"
            +
            "C1:\n"
            +
            "C2:\n"
            +
            "C3:\n"
            +
            "C4:\n"
            +
            "C5: 5♣\n"
            +
            "C6: 6♣\n"
            +
            "C7: 7♣\n"
            +
            "C8: 8♣\n"
            +
            "C9: 9♣\n"
            +
            "C10: 10♣\n"
            +
            "C11: J♣\n"
            +
            "C12: Q♣\n"
            +
            "C13: K♣\n"
            +
            "C14: A♦\n"
            +
            "C15: 2♦\n"
            +
            "C16: 3♦\n"
            +
            "C17: 4♦\n"
            +
            "C18: 5♦\n"
            +
            "C19: 6♦\n"
            +
            "C20: 7♦\n"
            +
            "C21: 8♦\n"
            +
            "C22: 9♦\n"
            +
            "C23: 10♦\n"
            +
            "C24: J♦\n"
            +
            "C25: Q♦\n"
            +
            "C26: K♦\n"
            +
            "C27:\n"
            +
            "C28: 2♥\n"
            +
            "C29: 3♥\n"
            +
            "C30: 4♥, 3♣\n"
            +
            "C31: 5♥\n"
            +
            "C32: 6♥\n"
            +
            "C33: 7♥\n"
            +
            "C34: 8♥\n"
            +
            "C35: 9♥\n"
            +
            "C36: 10♥\n"
            +
            "C37: J♥\n"
            +
            "C38: Q♥\n"
            +
            "C39: K♥\n"
            +
            "C40: A♠\n"
            +
            "C41: 2♠\n"
            +
            "C42: 3♠\n"
            +
            "C43: 4♠\n"
            +
            "C44: 5♠\n"
            +
            "C45: 6♠\n"
            +
            "C46: 7♠\n"
            +
            "C47: 8♠\n"
            +
            "C48: 9♠\n"
            +
            "C49: 10♠\n"
            +
            "C50: J♠\n"
            +
            "C51: Q♠\n"
            +
            "C52: K♠", model.getGameState());

    // FOUNDATION TO CASCADE
    model.move(PileType.FOUNDATION, 0, 0, PileType.CASCADE, 26);
    assertEquals("F1:\n"
            +
            "F2: A♥\n"
            +
            "F3:\n"
            +
            "F4:\n"
            +
            "O1: 2♣\n"
            +
            "O2:\n"
            +
            "O3:\n"
            +
            "O4:\n"
            +
            "O5:\n"
            +
            "O6:\n"
            +
            "O7:\n"
            +
            "O8:\n"
            +
            "O9:\n"
            +
            "O10:\n"
            +
            "O11:\n"
            +
            "O12:\n"
            +
            "O13:\n"
            +
            "O14:\n"
            +
            "O15:\n"
            +
            "O16:\n"
            +
            "O17:\n"
            +
            "O18:\n"
            +
            "O19:\n"
            +
            "O20:\n"
            +
            "O21:\n"
            +
            "O22:\n"
            +
            "O23:\n"
            +
            "O24:\n"
            +
            "O25:\n"
            +
            "O26:\n"
            +
            "O27:\n"
            +
            "O28:\n"
            +
            "O29:\n"
            +
            "O30:\n"
            +
            "O31:\n"
            +
            "O32:\n"
            +
            "O33:\n"
            +
            "O34:\n"
            +
            "O35:\n"
            +
            "O36:\n"
            +
            "O37:\n"
            +
            "O38:\n"
            +
            "O39:\n"
            +
            "O40:\n"
            +
            "O41:\n"
            +
            "O42:\n"
            +
            "O43:\n"
            +
            "O44:\n"
            +
            "O45:\n"
            +
            "O46:\n"
            +
            "O47:\n"
            +
            "O48:\n"
            +
            "O49:\n"
            +
            "O50:\n"
            +
            "O51: 4♣\n"
            +
            "O52:\n"
            +
            "C1:\n"
            +
            "C2:\n"
            +
            "C3:\n"
            +
            "C4:\n"
            +
            "C5: 5♣\n"
            +
            "C6: 6♣\n"
            +
            "C7: 7♣\n"
            +
            "C8: 8♣\n"
            +
            "C9: 9♣\n"
            +
            "C10: 10♣\n"
            +
            "C11: J♣\n"
            +
            "C12: Q♣\n"
            +
            "C13: K♣\n"
            +
            "C14: A♦\n"
            +
            "C15: 2♦\n"
            +
            "C16: 3♦\n"
            +
            "C17: 4♦\n"
            +
            "C18: 5♦\n"
            +
            "C19: 6♦\n"
            +
            "C20: 7♦\n"
            +
            "C21: 8♦\n"
            +
            "C22: 9♦\n"
            +
            "C23: 10♦\n"
            +
            "C24: J♦\n"
            +
            "C25: Q♦\n"
            +
            "C26: K♦\n"
            +
            "C27: A♣\n"
            +
            "C28: 2♥\n"
            +
            "C29: 3♥\n"
            +
            "C30: 4♥, 3♣\n"
            +
            "C31: 5♥\n"
            +
            "C32: 6♥\n"
            +
            "C33: 7♥\n"
            +
            "C34: 8♥\n"
            +
            "C35: 9♥\n"
            +
            "C36: 10♥\n"
            +
            "C37: J♥\n"
            +
            "C38: Q♥\n"
            +
            "C39: K♥\n"
            +
            "C40: A♠\n"
            +
            "C41: 2♠\n"
            +
            "C42: 3♠\n"
            +
            "C43: 4♠\n"
            +
            "C44: 5♠\n"
            +
            "C45: 6♠\n"
            +
            "C46: 7♠\n"
            +
            "C47: 8♠\n"
            +
            "C48: 9♠\n"
            +
            "C49: 10♠\n"
            +
            "C50: J♠\n"
            +
            "C51: Q♠\n"
            +
            "C52: K♠", model.getGameState());

    // FOUNDATION TO OPEN
    model.move(PileType.FOUNDATION, 1, 0, PileType.OPEN, 1);
    assertEquals("F1:\n"
            +
            "F2:\n"
            +
            "F3:\n"
            +
            "F4:\n"
            +
            "O1: 2♣\n"
            +
            "O2: A♥\n"
            +
            "O3:\n"
            +
            "O4:\n"
            +
            "O5:\n"
            +
            "O6:\n"
            +
            "O7:\n"
            +
            "O8:\n"
            +
            "O9:\n"
            +
            "O10:\n"
            +
            "O11:\n"
            +
            "O12:\n"
            +
            "O13:\n"
            +
            "O14:\n"
            +
            "O15:\n"
            +
            "O16:\n"
            +
            "O17:\n"
            +
            "O18:\n"
            +
            "O19:\n"
            +
            "O20:\n"
            +
            "O21:\n"
            +
            "O22:\n"
            +
            "O23:\n"
            +
            "O24:\n"
            +
            "O25:\n"
            +
            "O26:\n"
            +
            "O27:\n"
            +
            "O28:\n"
            +
            "O29:\n"
            +
            "O30:\n"
            +
            "O31:\n"
            +
            "O32:\n"
            +
            "O33:\n"
            +
            "O34:\n"
            +
            "O35:\n"
            +
            "O36:\n"
            +
            "O37:\n"
            +
            "O38:\n"
            +
            "O39:\n"
            +
            "O40:\n"
            +
            "O41:\n"
            +
            "O42:\n"
            +
            "O43:\n"
            +
            "O44:\n"
            +
            "O45:\n"
            +
            "O46:\n"
            +
            "O47:\n"
            +
            "O48:\n"
            +
            "O49:\n"
            +
            "O50:\n"
            +
            "O51: 4♣\n"
            +
            "O52:\n"
            +
            "C1:\n"
            +
            "C2:\n"
            +
            "C3:\n"
            +
            "C4:\n"
            +
            "C5: 5♣\n"
            +
            "C6: 6♣\n"
            +
            "C7: 7♣\n"
            +
            "C8: 8♣\n"
            +
            "C9: 9♣\n"
            +
            "C10: 10♣\n"
            +
            "C11: J♣\n"
            +
            "C12: Q♣\n"
            +
            "C13: K♣\n"
            +
            "C14: A♦\n"
            +
            "C15: 2♦\n"
            +
            "C16: 3♦\n"
            +
            "C17: 4♦\n"
            +
            "C18: 5♦\n"
            +
            "C19: 6♦\n"
            +
            "C20: 7♦\n"
            +
            "C21: 8♦\n"
            +
            "C22: 9♦\n"
            +
            "C23: 10♦\n"
            +
            "C24: J♦\n"
            +
            "C25: Q♦\n"
            +
            "C26: K♦\n"
            +
            "C27: A♣\n"
            +
            "C28: 2♥\n"
            +
            "C29: 3♥\n"
            +
            "C30: 4♥, 3♣\n"
            +
            "C31: 5♥\n"
            +
            "C32: 6♥\n"
            +
            "C33: 7♥\n"
            +
            "C34: 8♥\n"
            +
            "C35: 9♥\n"
            +
            "C36: 10♥\n"
            +
            "C37: J♥\n"
            +
            "C38: Q♥\n"
            +
            "C39: K♥\n"
            +
            "C40: A♠\n"
            +
            "C41: 2♠\n"
            +
            "C42: 3♠\n"
            +
            "C43: 4♠\n"
            +
            "C44: 5♠\n"
            +
            "C45: 6♠\n"
            +
            "C46: 7♠\n"
            +
            "C47: 8♠\n"
            +
            "C48: 9♠\n"
            +
            "C49: 10♠\n"
            +
            "C50: J♠\n"
            +
            "C51: Q♠\n"
            +
            "C52: K♠", model.getGameState());

    //FOUNDATION TO FOUNDATION
    model.move(PileType.OPEN, 1, 0, PileType.FOUNDATION, 0);
    model.move(PileType.FOUNDATION, 0, 0, PileType.FOUNDATION, 1);
    assertEquals("F1:\n"
            +
            "F2: A♥\n"
            +
            "F3:\n"
            +
            "F4:\n"
            +
            "O1: 2♣\n"
            +
            "O2:\n"
            +
            "O3:\n"
            +
            "O4:\n"
            +
            "O5:\n"
            +
            "O6:\n"
            +
            "O7:\n"
            +
            "O8:\n"
            +
            "O9:\n"
            +
            "O10:\n"
            +
            "O11:\n"
            +
            "O12:\n"
            +
            "O13:\n"
            +
            "O14:\n"
            +
            "O15:\n"
            +
            "O16:\n"
            +
            "O17:\n"
            +
            "O18:\n"
            +
            "O19:\n"
            +
            "O20:\n"
            +
            "O21:\n"
            +
            "O22:\n"
            +
            "O23:\n"
            +
            "O24:\n"
            +
            "O25:\n"
            +
            "O26:\n"
            +
            "O27:\n"
            +
            "O28:\n"
            +
            "O29:\n"
            +
            "O30:\n"
            +
            "O31:\n"
            +
            "O32:\n"
            +
            "O33:\n"
            +
            "O34:\n"
            +
            "O35:\n"
            +
            "O36:\n"
            +
            "O37:\n"
            +
            "O38:\n"
            +
            "O39:\n"
            +
            "O40:\n"
            +
            "O41:\n"
            +
            "O42:\n"
            +
            "O43:\n"
            +
            "O44:\n"
            +
            "O45:\n"
            +
            "O46:\n"
            +
            "O47:\n"
            +
            "O48:\n"
            +
            "O49:\n"
            +
            "O50:\n"
            +
            "O51: 4♣\n"
            +
            "O52:\n"
            +
            "C1:\n"
            +
            "C2:\n"
            +
            "C3:\n"
            +
            "C4:\n"
            +
            "C5: 5♣\n"
            +
            "C6: 6♣\n"
            +
            "C7: 7♣\n"
            +
            "C8: 8♣\n"
            +
            "C9: 9♣\n"
            +
            "C10: 10♣\n"
            +
            "C11: J♣\n"
            +
            "C12: Q♣\n"
            +
            "C13: K♣\n"
            +
            "C14: A♦\n"
            +
            "C15: 2♦\n"
            +
            "C16: 3♦\n"
            +
            "C17: 4♦\n"
            +
            "C18: 5♦\n"
            +
            "C19: 6♦\n"
            +
            "C20: 7♦\n"
            +
            "C21: 8♦\n"
            +
            "C22: 9♦\n"
            +
            "C23: 10♦\n"
            +
            "C24: J♦\n"
            +
            "C25: Q♦\n"
            +
            "C26: K♦\n"
            +
            "C27: A♣\n"
            +
            "C28: 2♥\n"
            +
            "C29: 3♥\n"
            +
            "C30: 4♥, 3♣\n"
            +
            "C31: 5♥\n"
            +
            "C32: 6♥\n"
            +
            "C33: 7♥\n"
            +
            "C34: 8♥\n"
            +
            "C35: 9♥\n"
            +
            "C36: 10♥\n"
            +
            "C37: J♥\n"
            +
            "C38: Q♥\n"
            +
            "C39: K♥\n"
            +
            "C40: A♠\n"
            +
            "C41: 2♠\n"
            +
            "C42: 3♠\n"
            +
            "C43: 4♠\n"
            +
            "C44: 5♠\n"
            +
            "C45: 6♠\n"
            +
            "C46: 7♠\n"
            +
            "C47: 8♠\n"
            +
            "C48: 9♠\n"
            +
            "C49: 10♠\n"
            +
            "C50: J♠\n"
            +
            "C51: Q♠\n"
            +
            "C52: K♠", model.getGameState());

    //System.out.println(model.getGameState());


  }


  @Test(expected = IllegalStateException.class)
  public void moveBeforeStartGameOpenToOpen() {
    FreecellOperations model = FreecellModel
            .getBuilder()
            .cascades(6)
            .opens(4)
            .build();

    List<Card> deck = model.getDeck();
    model.move(PileType.OPEN, 0, 0, PileType.OPEN, 1);
  }

  @Test(expected = IllegalStateException.class)
  public void moveBeforeStartGameOpenToCascade() {
    FreecellOperations model = FreecellModel
            .getBuilder()
            .cascades(6)
            .opens(4)
            .build();

    List<Card> deck = model.getDeck();
    model.move(PileType.OPEN, 0, 0, PileType.CASCADE, 1);
  }

  @Test(expected = IllegalStateException.class)
  public void moveBeforeStartGameOpenToFoundation() {
    FreecellOperations model = FreecellModel
            .getBuilder()
            .cascades(6)
            .opens(4)
            .build();

    List<Card> deck = model.getDeck();
    model.move(PileType.OPEN, 0, 0, PileType.FOUNDATION, 1);
  }

  @Test(expected = IllegalStateException.class)
  public void moveBeforeStartGameFoundationToFoundation() {
    FreecellOperations model = FreecellModel
            .getBuilder()
            .cascades(6)
            .opens(4)
            .build();

    List<Card> deck = model.getDeck();
    model.move(PileType.FOUNDATION, 0, 0, PileType.FOUNDATION, 1);
  }

  @Test(expected = IllegalStateException.class)
  public void moveBeforeStartGameFoundationToOpen() {
    FreecellOperations model = FreecellModel
            .getBuilder()
            .cascades(6)
            .opens(4)
            .build();

    List<Card> deck = model.getDeck();
    model.move(PileType.FOUNDATION, 0, 0, PileType.OPEN, 1);
  }

  @Test(expected = IllegalStateException.class)
  public void moveBeforeStartGameFoundationToCascade() {
    FreecellOperations model = FreecellModel
            .getBuilder()
            .cascades(6)
            .opens(4)
            .build();

    List<Card> deck = model.getDeck();
    model.move(PileType.FOUNDATION, 0, 0, PileType.CASCADE, 1);
  }

  @Test(expected = IllegalStateException.class)
  public void moveBeforeStartGameCascadeToCascade() {
    FreecellOperations model = FreecellModel
            .getBuilder()
            .cascades(6)
            .opens(4)
            .build();

    List<Card> deck = model.getDeck();
    model.move(PileType.CASCADE, 0, 0, PileType.CASCADE, 1);
  }

  @Test(expected = IllegalStateException.class)
  public void moveBeforeStartGameCascadeToOpen() {
    FreecellOperations model = FreecellModel
            .getBuilder()
            .cascades(6)
            .opens(4)
            .build();

    List<Card> deck = model.getDeck();
    model.move(PileType.CASCADE, 0, 0, PileType.OPEN, 1);
  }

  @Test(expected = IllegalStateException.class)
  public void moveBeforeStartGameCascadeTofOUNDATION() {
    FreecellOperations model = FreecellModel
            .getBuilder()
            .cascades(6)
            .opens(4)
            .build();

    List<Card> deck = model.getDeck();
    model.move(PileType.CASCADE, 0, 0, PileType.FOUNDATION, 1);
  }


  @Test
  public void isGameOver() {
    FreecellOperations model = FreecellModel
            .getBuilder()
            .cascades(52)
            .opens(52)
            .build();
    List<Card> deck = model.getDeck();

    model.startGame(deck, false);

    assertEquals(false, model.isGameOver());


  }

  @Test
  public void getGameStateWhenGameNotStarted() {
    FreecellOperations model = FreecellModel
            .getBuilder()
            .cascades(6)
            .opens(4)
            .build();
    assertEquals("", model.getGameState());

  }

  @Test
  public void getGameStateWhenGameStarted() {
    FreecellOperations model = FreecellModel
            .getBuilder()
            .cascades(6)
            .opens(4)
            .build();
    assertEquals("", model.getGameState());

  }


  @Test
  public void getBuilderCorrect() {
    // cascade = 6 and open = 4
    FreecellOperations model = FreecellModel
            .getBuilder()
            .cascades(6)
            .opens(4)
            .build();

    assertEquals("", model.getGameState());

  }

  @Test(expected = IllegalArgumentException.class)
  public void getBuilderWrongOpen() {
    // cascade = 6 and open = 4
    FreecellOperations model = FreecellModel
            .getBuilder()
            .cascades(6)
            .opens(0)
            .build();

    assertEquals("", model.getGameState());

  }

  @Test(expected = IllegalArgumentException.class)
  public void getBuilderWrongCascade() {
    // cascade = 6 and open = 4
    FreecellOperations model = FreecellModel
            .getBuilder()
            .cascades(-6)
            .opens(6)
            .build();

    assertEquals("", model.getGameState());

  }

  @Test(expected = IllegalArgumentException.class)
  public void passingNullStartGame() {
    FreecellOperations model = FreecellModel
            .getBuilder()
            .cascades(4)
            .opens(6)
            .build();

    model.startGame(null, true);

  }

  @Test(expected = IllegalArgumentException.class)
  public void passingNullMove() {
    FreecellOperations model = FreecellModel
            .getBuilder()
            .cascades(4)
            .opens(6)
            .build();

    List<Card> deck = model.getDeck();
    model.startGame(deck, false);
    model.move(null, 0, 0, null, 0);

  }


}