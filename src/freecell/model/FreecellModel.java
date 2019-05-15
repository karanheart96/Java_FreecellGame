package freecell.model;

import java.util.HashMap;
import java.util.List;

import java.util.Map;
import java.util.Random;

import java.util.ArrayList;

import java.util.Collections;

/**
 * Class to implement the FreecellOperations interface.
 */
public class FreecellModel implements FreecellOperations<Card> {
  List<Pile> openpile;
  List<Pile> cascadepile;
  List<Pile> foundationpile;
  int cascades;
  int opens;
  int gamestart = 0;


  /**
   * Constructor to intialize a Freecellmodel.
   *
   * @param openpile       Open pile list from builder.
   * @param cascadepile    Cascade pile list from builder.
   * @param foundationpile Foundation Pile list from builder.
   * @param cascades       The total number of cascade.
   * @param opens          The total number of open piles.
   */
  public FreecellModel(List<Pile> openpile, List<Pile> cascadepile,
                       List<Pile> foundationpile, int cascades, int opens) {
    this.openpile = openpile;
    this.cascadepile = cascadepile;
    this.foundationpile = foundationpile;
    this.cascades = cascades;
    this.opens = opens;
  }


  @Override
  public List<Card> getDeck() {
    List<Card> deck = new ArrayList<>();
    create(Cardtype.CLUBS, Cardcolor.BLACK, deck);
    create(Cardtype.DIAMONDS, Cardcolor.RED, deck);
    create(Cardtype.HEARTS, Cardcolor.RED, deck);
    create(Cardtype.SPADES, Cardcolor.BLACK, deck);
    boolean isDeckCorrect = checkUsingToString(deck);
    if (isDeckCorrect) {
      return deck;
    } else {
      throw new IllegalStateException("proper deck not created");
    }
  }


  /**
   * Method to clear cascade, foundation and open piles.
   */
  private void clearArray() {
    for (int i = 0; i < this.openpile.size(); i++) {
      openpile.get(i).cardlist.clear();
    }

    for (int i = 0; i < this.foundationpile.size(); i++) {
      foundationpile.get(i).cardlist.clear();
    }

    for (int i = 0; i < this.cascadepile.size(); i++) {
      cascadepile.get(i).cardlist.clear();
    }
  }


  /**
   * Method to check if a deck is valid using toString Method of card objects.
   *
   * @param deck The deck to be checked.
   * @return True if valid deck else false.
   */
  private boolean checkUsingToString(List<Card> deck) {

    if (deck.size() != 52) {
      return false;
    }
    String current_card;
    current_card = "";
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
      numbers.put(key, numbers.get(key) + 1);

    }

    if (hearts != 13
            || clubs != 13
            || diamonds != 13
            || spades != 13) {
      return false;
    }

    for (String key1 : numbers.keySet()) {
      if (numbers.get(key1) != 4) {
        return false;
      }
    }
    return true;
  }


  @Override
  public void startGame(List<Card> deck, boolean shuffle) throws IllegalArgumentException {
    this.clearArray();
    gamestart = 0;
    if (deck == null) {
      throw new IllegalArgumentException("Invalid deck");
    }
    boolean isDeckcorrect = this.checkUsingToString(deck);
    if (!isDeckcorrect) {
      throw new IllegalArgumentException("Invalid deck" + deck.size());
    }

    if (shuffle) {
      Collections.shuffle(deck, new Random(0));
    }
    for (int i = 0; i < 52; i++) {
      cascadepile.get(i % cascades).cardlist.add((Card) deck.get(i));
    }
    gamestart = 1;

  }

  @Override
  public void move(PileType source, int pileNumber, int cardIndex, PileType destination,
                   int destPileNumber) throws IllegalArgumentException, IllegalStateException {
    int fromval;
    int toval;
    int opensize;
    int fromsize;
    Cardcolor fromcolor;
    Cardcolor tocolor;
    Cardtype totype;
    Cardtype fromtype;
    Card from;

    if (source == null || destination == null) {
      throw new IllegalArgumentException("null input");
    }
    if (gamestart == 0) {
      throw new IllegalStateException("Game not started");
    }
    if (pileNumber < 0 || destPileNumber < 0 || cardIndex < 0) {
      throw new IllegalArgumentException("Negative input in move");
    }
    if (source == PileType.CASCADE && destination == PileType.CASCADE
            && (pileNumber != destPileNumber)) {
      try {
        fromsize = cascadepile.get(pileNumber).cardlist.size();
      } catch (IndexOutOfBoundsException e) {
        throw new IllegalArgumentException("Move not possible");
      }
      if (pileNumber >= cascades || destPileNumber >= cascades || fromsize == 0
              || cardIndex != cascadepile.get(pileNumber).cardlist.size() - 1) {
        throw new IllegalArgumentException("Move not possible");
      } else {
        if (cascadepile.get(destPileNumber).cardlist.size() != 0) {
          fromval = cascadepile.get(pileNumber).cardlist.get(cascadepile.get(pileNumber)
                  .cardlist.size() - 1).numericval;
          fromcolor = cascadepile.get(pileNumber).cardlist.get(cascadepile.get(pileNumber)
                  .cardlist.size() - 1).color;
          from = cascadepile.get(pileNumber).cardlist.get(cascadepile.get(pileNumber)
                  .cardlist.size() - 1);
          toval = cascadepile.get(destPileNumber).cardlist.get(cascadepile.get(destPileNumber)
                  .cardlist.size() - 1).numericval;
          tocolor = cascadepile.get(destPileNumber).cardlist.get(cascadepile.get(destPileNumber)
                  .cardlist.size() - 1).color;
          if ((fromval + 1 == toval) && fromcolor != tocolor) {
            cascadepile.get(pileNumber).cardlist.remove(cascadepile.get(pileNumber)
                    .cardlist.size() - 1);
            cascadepile.get(destPileNumber).cardlist.add(from);
          } else {
            throw new IllegalArgumentException("Move not possible");
          }
        } else {
          from = cascadepile.get(pileNumber).cardlist.get(cascadepile.get(pileNumber)
                  .cardlist.size() - 1);
          cascadepile.get(pileNumber).cardlist.remove(cascadepile.get(pileNumber)
                  .cardlist.size() - 1);
          cascadepile.get(destPileNumber).cardlist.add(from);
        }
      }
    } else if (source == PileType.CASCADE && destination == PileType.CASCADE
            && (pileNumber == destPileNumber)) {
      try {
        fromsize = cascadepile.get(pileNumber).cardlist.size();
      } catch (IndexOutOfBoundsException e) {
        throw new IllegalArgumentException("Move not possible");
      }
      if (pileNumber >= cascades || destPileNumber >= cascades || fromsize == 0
              || cardIndex != cascadepile.get(pileNumber).cardlist.size() - 1) {
        throw new IllegalArgumentException("Move not possible");
      } else {
        fromval = cascadepile.get(pileNumber).cardlist.get(cascadepile.get(pileNumber)
                .cardlist.size() - 1).numericval;
        fromcolor = cascadepile.get(pileNumber).cardlist.get(cascadepile.get(pileNumber)
                .cardlist.size() - 1).color;
        from = cascadepile.get(pileNumber).cardlist.get(cascadepile.get(pileNumber)
                .cardlist.size() - 1);
        toval = cascadepile.get(destPileNumber).cardlist.get(cascadepile.get(destPileNumber)
                .cardlist.size() - 2).numericval;
        tocolor = cascadepile.get(destPileNumber).cardlist.get(cascadepile.get(destPileNumber)
                .cardlist.size() - 2).color;
        if ((fromval + 1 == toval) && fromcolor != tocolor) {
          cascadepile.get(pileNumber).cardlist.remove(cascadepile.get(pileNumber)
                  .cardlist.size() - 1);
          cascadepile.get(destPileNumber).cardlist.add(from);
        } else {
          throw new IllegalArgumentException("Move not possible");
        }
      }
    } else if (source == PileType.CASCADE && destination == PileType.FOUNDATION) {
      try {
        fromsize = cascadepile.get(pileNumber).cardlist.size();
      } catch (IndexOutOfBoundsException e) {
        throw new IllegalArgumentException("Move not possible");
      }
      if (pileNumber >= cascades || destPileNumber >= 4 || fromsize == 0
              || cardIndex != cascadepile.get(pileNumber).cardlist.size() - 1) {
        throw new IllegalArgumentException("Move not possible");
      } else {
        if (foundationpile.get(destPileNumber).cardlist.size() == 0) {
          fromval = cascadepile.get(pileNumber).cardlist.get(cascadepile.get(pileNumber)
                  .cardlist.size() - 1).numericval;
          from = cascadepile.get(pileNumber).cardlist.get(cascadepile.get(pileNumber)
                  .cardlist.size() - 1);
          if (fromval == 1) {
            cascadepile.get(pileNumber).cardlist.remove(cascadepile.get(pileNumber)
                    .cardlist.size() - 1);
            foundationpile.get(destPileNumber).cardlist.add(from);
          } else if (fromval != 1) {
            throw new IllegalArgumentException("Move not possible");
          }

        } else {
          fromval = cascadepile.get(pileNumber).cardlist.get(cascadepile.get(pileNumber)
                  .cardlist.size() - 1).numericval;
          fromtype = cascadepile.get(pileNumber).cardlist.get(cascadepile.get(pileNumber)
                  .cardlist.size() - 1).type;
          from = cascadepile.get(pileNumber).cardlist.get(cascadepile.get(pileNumber)
                  .cardlist.size() - 1);
          toval = foundationpile.get(destPileNumber).cardlist.get(foundationpile.get(destPileNumber)
                  .cardlist.size() - 1).numericval;
          totype = foundationpile.get(destPileNumber).cardlist
                  .get(foundationpile.get(destPileNumber).cardlist.size() - 1).type;
          if (fromtype == totype && (toval + 1 == fromval)) {
            cascadepile.get(pileNumber).cardlist.remove(cascadepile.get(pileNumber)
                    .cardlist.size() - 1);
            foundationpile.get(destPileNumber).cardlist.add(from);
          } else {
            throw new IllegalArgumentException("Move not possible");
          }
        }
      }
    } else if (source == PileType.CASCADE && destination == PileType.OPEN) {
      try {
        fromsize = cascadepile.get(pileNumber).cardlist.size();
      } catch (IndexOutOfBoundsException e) {
        throw new IllegalArgumentException("Move not possible");
      }
      if (pileNumber >= cascades || destPileNumber >= opens || fromsize == 0
              || cardIndex != cascadepile.get(pileNumber).cardlist.size() - 1) {
        throw new IllegalArgumentException("Move not possible");
      } else {
        fromval = cascadepile.get(pileNumber).cardlist.get(cascadepile.get(pileNumber)
                .cardlist.size() - 1).numericval;
        opensize = openpile.get(destPileNumber).cardlist.size();
        if (opensize == 0) {
          from = cascadepile.get(pileNumber).cardlist.get(cascadepile.get(pileNumber)
                  .cardlist.size() - 1);
          cascadepile.get(pileNumber).cardlist.remove(cascadepile.get(pileNumber)
                  .cardlist.size() - 1);
          openpile.get(destPileNumber).cardlist.add(from);
        } else {
          throw new IllegalArgumentException("Move not possible");
        }

      }
    } else if (source == PileType.FOUNDATION && destination == PileType.CASCADE) {
      try {
        fromsize = foundationpile.get(pileNumber).cardlist.size();
      } catch (IndexOutOfBoundsException e) {
        throw new IllegalArgumentException("Move not possible");
      }
      if (pileNumber >= 4 || destPileNumber >= cascades || fromsize == 0
              || cardIndex != foundationpile.get(pileNumber).cardlist.size() - 1) {
        throw new IllegalArgumentException("Move not possible");
      } else {
        if (cascadepile.get(destPileNumber).cardlist.size() != 0) {
          fromval = foundationpile.get(pileNumber).cardlist.get(foundationpile.get(pileNumber)
                  .cardlist.size() - 1).numericval;
          fromcolor = foundationpile.get(pileNumber).cardlist.get(foundationpile.get(pileNumber)
                  .cardlist.size() - 1).color;
          from = foundationpile.get(pileNumber).cardlist.get(foundationpile.get(pileNumber)
                  .cardlist.size() - 1);
          toval = cascadepile.get(destPileNumber).cardlist.get(cascadepile.get(destPileNumber)
                  .cardlist.size() - 1).numericval;
          tocolor = cascadepile.get(destPileNumber).cardlist.get(cascadepile.get(destPileNumber)
                  .cardlist.size() - 1).color;
          if ((fromval + 1 == toval) && fromcolor != tocolor) {
            foundationpile.get(pileNumber).cardlist.remove(foundationpile.get(pileNumber)
                    .cardlist.size() - 1);
            cascadepile.get(destPileNumber).cardlist.add(from);
          } else {
            throw new IllegalArgumentException("Move not possible");
          }
        } else {
          from = foundationpile.get(pileNumber).cardlist.get(foundationpile.get(pileNumber)
                  .cardlist.size() - 1);
          foundationpile.get(pileNumber).cardlist.remove(foundationpile.get(pileNumber)
                  .cardlist.size() - 1);
          cascadepile.get(destPileNumber).cardlist.add(from);
        }
      }
    } else if (source == PileType.FOUNDATION && destination == PileType.OPEN) {
      try {
        fromsize = foundationpile.get(pileNumber).cardlist.size();
      } catch (IndexOutOfBoundsException e) {
        throw new IllegalArgumentException("Move not possible");
      }
      if (pileNumber >= 4 || destPileNumber >= opens || fromsize == 0
              || cardIndex != foundationpile.get(pileNumber).cardlist.size() - 1) {
        throw new IllegalArgumentException("Move not possible");
      } else {
        from = foundationpile.get(pileNumber).cardlist.get(foundationpile.get(pileNumber)
                .cardlist.size() - 1);
        opensize = openpile.get(destPileNumber).cardlist.size();
        if (opensize == 0) {
          foundationpile.get(pileNumber).cardlist.remove(foundationpile.get(pileNumber)
                  .cardlist.size() - 1);
          openpile.get(destPileNumber).cardlist.add(from);
        } else if (opensize > 0) {
          throw new IllegalArgumentException("Move not possible");
        }
      }
    } else if (source == PileType.FOUNDATION && destination == PileType.FOUNDATION
            && (pileNumber != destPileNumber)) {
      try {
        fromsize = foundationpile.get(pileNumber).cardlist.size();
      } catch (IndexOutOfBoundsException e) {
        throw new IllegalArgumentException("Move not possible");
      }
      if (pileNumber >= 4 || destPileNumber >= 4 || fromsize == 0
              || cardIndex != foundationpile.get(pileNumber).cardlist.size() - 1) {
        throw new IllegalArgumentException("Move not possible");
      } else {
        int sourcesize = foundationpile.get(pileNumber).cardlist.size();
        int destsize = foundationpile.get(destPileNumber).cardlist.size();
        if (sourcesize == 1 && destsize == 0) {
          from = foundationpile.get(pileNumber).cardlist.get(foundationpile.get(pileNumber)
                  .cardlist.size() - 1);
          foundationpile.get(pileNumber).cardlist.remove(foundationpile.get(pileNumber)
                  .cardlist.size() - 1);
          foundationpile.get(destPileNumber).cardlist.add(from);
        } else {
          throw new IllegalArgumentException("Move not possible");
        }
      }
    } else if (source == PileType.OPEN && destination == PileType.FOUNDATION) {
      try {
        fromsize = openpile.get(pileNumber).cardlist.size();
      } catch (IndexOutOfBoundsException e) {
        throw new IllegalArgumentException("Move not possible");
      }
      if (pileNumber >= opens || destPileNumber >= 4 || fromsize == 0
              || cardIndex != openpile.get(pileNumber).cardlist.size() - 1) {
        throw new IllegalArgumentException("Move not possible");
      } else {
        if (foundationpile.get(destPileNumber).cardlist.size() == 0) {
          fromval = openpile.get(pileNumber).cardlist.get(0).numericval;
          from = openpile.get(pileNumber).cardlist.get(0);
          if (fromval == 1) {
            openpile.get(pileNumber).cardlist.remove(0);
            foundationpile.get(destPileNumber).cardlist.add(from);
          } else if (fromval != 1) {
            throw new IllegalArgumentException("Move not possible");
          }

        } else {
          fromval = openpile.get(pileNumber).cardlist.get(0).numericval;
          fromtype = openpile.get(pileNumber).cardlist.get(0).type;
          from = openpile.get(pileNumber).cardlist.get(0);
          toval = foundationpile.get(destPileNumber).cardlist.get(foundationpile.get(destPileNumber)
                  .cardlist.size() - 1).numericval;
          totype = foundationpile.get(destPileNumber).cardlist
                  .get(foundationpile.get(destPileNumber).cardlist.size() - 1).type;
          if (fromtype == totype && (toval + 1 == fromval)) {
            openpile.get(pileNumber).cardlist.remove(0);
            foundationpile.get(destPileNumber).cardlist.add(from);
          } else {
            throw new IllegalArgumentException("Move not possible");
          }
        }
      }
    } else if (source == PileType.OPEN && destination == PileType.CASCADE) {
      try {
        fromsize = openpile.get(pileNumber).cardlist.size();
      } catch (IndexOutOfBoundsException e) {
        throw new IllegalArgumentException("Move not possible");
      }
      if (pileNumber >= opens || destPileNumber >= cascades || fromsize == 0
              || cardIndex != openpile.get(pileNumber).cardlist.size() - 1) {
        throw new IllegalArgumentException("Move not possible");
      } else {
        if (cascadepile.get(destPileNumber).cardlist.size() != 0) {
          fromval = openpile.get(pileNumber).cardlist.get(0).numericval;
          fromcolor = openpile.get(pileNumber).cardlist.get(0).color;
          toval = cascadepile.get(destPileNumber).cardlist.get(cascadepile.get(destPileNumber)
                  .cardlist.size() - 1).numericval;
          tocolor = cascadepile.get(destPileNumber).cardlist.get(cascadepile.get(destPileNumber)
                  .cardlist.size() - 1).color;
          from = openpile.get(pileNumber).cardlist.get(0);
          if (fromval + 1 == toval && fromcolor != tocolor) {
            openpile.get(pileNumber).cardlist.remove(0);
            cascadepile.get(destPileNumber).cardlist.add(from);
          } else {
            throw new IllegalArgumentException("Move not possible");
          }
        } else {
          from = openpile.get(pileNumber).cardlist.get(0);
          openpile.get(pileNumber).cardlist.remove(0);
          cascadepile.get(destPileNumber).cardlist.add(from);
        }
      }
    } else if (source == PileType.OPEN && destination == PileType.OPEN
            && (pileNumber != destPileNumber)) {
      try {
        fromsize = openpile.get(pileNumber).cardlist.size();
      } catch (IndexOutOfBoundsException e) {
        throw new IllegalArgumentException("Move not possible");
      }
      if (pileNumber >= opens || destPileNumber >= opens || fromsize == 0
              || cardIndex != openpile.get(pileNumber).cardlist.size() - 1) {
        throw new IllegalArgumentException("Move not possible");
      } else {
        opensize = openpile.get(destPileNumber).cardlist.size();
        if (opensize == 0) {
          from = openpile.get(pileNumber).cardlist.get(0);
          openpile.get(pileNumber).cardlist.remove(0);
          openpile.get(destPileNumber).cardlist.add(from);
        } else if (opensize > 0) {
          throw new IllegalArgumentException("Move not possible");
        }
      }
    }
  }

  @Override
  public boolean isGameOver() {
    return (foundationpile.get(0).cardlist.size() == 13 && foundationpile.get(1).cardlist.size()
            == 13
            && foundationpile.get(2).cardlist.size() == 13 && foundationpile.get(3).cardlist.size()
            == 13);
  }

  private String stringHelper(List<Pile> currentPile, String type) {
    String result = "";
    for (int i = 0; i < currentPile.size(); i++) {
      result = result + type + Integer.toString(i + 1) + ":";
      if (currentPile.get(i).cardlist.size() == 0) {
        result = result + "\n";
      }
      for (int j = 0; j < currentPile.get(i).cardlist.size(); j++) {
        if (j == currentPile.get(i).cardlist.size() - 1) {
          result = result + " " + currentPile.get(i).cardlist.get(j).toString() + "\n";
        } else {
          result = result + " " + currentPile.get(i).cardlist.get(j).toString() + ",";
        }
      }
    }
    return result;
  }

  @Override
  public String getGameState() {
    String result = "";
    if (gamestart == 0) {
      return result;
    } else {
      result = result + stringHelper(foundationpile, "F");
      result = result + stringHelper(openpile, "O");
      result = result + stringHelper(cascadepile, "C");
      return result.substring(0, result.length() - 1);
    }
  }


  /**
   * Helper function to create a deck of cards.
   *
   * @param type  The type of the card.
   * @param color The color of the card.
   * @param deck  The deck to insert the card.
   */
  private void create(Cardtype type, Cardcolor color, List<Card> deck) {
    for (int i = 0; i < 13; i++) {
      Card obj;
      String value;
      int numericval;
      if (i == 0) {
        value = "A";
        numericval = 1;
        obj = new Card(value, numericval, type, color);
        deck.add(obj);
      } else if (i == 1) {
        value = "2";
        numericval = 2;
        obj = new Card(value, numericval, type, color);
        deck.add(obj);
      } else if (i == 2) {
        value = "3";
        numericval = 3;
        obj = new Card(value, numericval, type, color);
        deck.add(obj);
      } else if (i == 3) {
        value = "4";
        numericval = 4;
        obj = new Card(value, numericval, type, color);
        deck.add(obj);
      } else if (i == 4) {
        value = "5";
        numericval = 5;
        obj = new Card(value, numericval, type, color);
        deck.add(obj);
      } else if (i == 5) {
        value = "6";
        numericval = 6;
        obj = new Card(value, numericval, type, color);
        deck.add(obj);
      } else if (i == 6) {
        value = "7";
        numericval = 7;
        obj = new Card(value, numericval, type, color);
        deck.add(obj);
      } else if (i == 7) {
        value = "8";
        numericval = 8;
        obj = new Card(value, numericval, type, color);
        deck.add(obj);
      } else if (i == 8) {
        value = "9";
        numericval = 9;
        obj = new Card(value, numericval, type, color);
        deck.add(obj);
      } else if (i == 9) {
        value = "10";
        numericval = 10;
        obj = new Card(value, numericval, type, color);
        deck.add(obj);
      } else if (i == 10) {
        value = "J";
        numericval = 11;
        obj = new Card(value, numericval, type, color);
        deck.add(obj);
      } else if (i == 11) {
        value = "Q";
        numericval = 12;
        obj = new Card(value, numericval, type, color);
        deck.add(obj);
      } else if (i == 12) {
        value = "K";
        numericval = 13;
        obj = new Card(value, numericval, type, color);
        deck.add(obj);
      }
    }


  }


  /**
   * A static method to call the Builder class object.
   *
   * @return a new Builder object.
   */
  public static Builder getBuilder() {
    return new Builder();
  }

}

