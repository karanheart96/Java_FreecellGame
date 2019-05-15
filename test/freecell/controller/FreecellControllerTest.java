package freecell.controller;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.io.Reader;
import java.io.StringReader;
import java.util.List;

import freecell.model.FreecellModel;
import freecell.model.FreecellMultiMoveModel;
import freecell.model.FreecellOperations;

public class FreecellControllerTest {

  @Test
  public void playGameCorrectFreecellModel() {
    FreecellOperations model = FreecellModel
            .getBuilder()
            .cascades(4)
            .opens(6)
            .build();
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("C1 13 O1 Q");
    //Reader in = new InputStreamReader(System.in);
    IFreecellController controller = new FreecellController(in, out);
    List deck = model.getDeck();
    controller.playGame(deck, model, false);
    String out1 = "F1:\n"
            +
            "F2:\n"
            +
            "F3:\n"
            +
            "F4:\n"
            +
            "O1:\n"
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
            "C1: A♣, 5♣, 9♣, K♣, 4♦, 8♦, Q♦, 3♥, 7♥, J♥, 2♠, 6♠, 10♠\n"


            +
            "C2: 2♣, 6♣, 10♣, A♦, 5♦, 9♦, K♦, 4♥, 8♥, Q♥, 3♠, 7♠, J♠\n"


            +
            "C3: 3♣, 7♣, J♣, 2♦, 6♦, 10♦, A♥, 5♥, 9♥, K♥, 4♠, 8♠, Q♠\n"


            +
            "C4: 4♣, 8♣, Q♣, 3♦, 7♦, J♦, 2♥, 6♥, 10♥, A♠, 5♠, 9♠, K♠\n"


            +
            "F1:\n"


            +
            "F2:\n"


            +
            "F3:\n"


            +
            "F4:\n"


            +
            "O1: 10♠\n"


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
            "C1: A♣, 5♣, 9♣, K♣, 4♦, 8♦, Q♦, 3♥, 7♥, J♥, 2♠, 6♠\n"


            +
            "C2: 2♣, 6♣, 10♣, A♦, 5♦, 9♦, K♦, 4♥, 8♥, Q♥, 3♠, 7♠, J♠\n"


            +
            "C3: 3♣, 7♣, J♣, 2♦, 6♦, 10♦, A♥, 5♥, 9♥, K♥, 4♠, 8♠, Q♠\n"


            +
            "C4: 4♣, 8♣, Q♣, 3♦, 7♦, J♦, 2♥, 6♥, 10♥, A♠, 5♠, 9♠, K♠\n"


            +
            "Game quit prematurely.";
    assertEquals(out.toString(), out1);
  }

  @Test
  public void playGameCorrectFreecellMultiMoveModel() {
    FreecellOperations model = FreecellMultiMoveModel
            .getBuilder()
            .cascades(4)
            .opens(6)
            .build();
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("C1 13 O1 Q");
    //Reader in = new InputStreamReader(System.in);
    IFreecellController controller = new FreecellController(in, out);
    List deck = model.getDeck();
    controller.playGame(deck, model, false);
    String out1 = "F1:\n"


            +
            "F2:\n"


            +
            "F3:\n"


            +
            "F4:\n"


            +
            "O1:\n"


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
            "C1: A♣, 5♣, 9♣, K♣, 4♦, 8♦, Q♦, 3♥, 7♥, J♥, 2♠, 6♠, 10♠\n"


            +
            "C2: 2♣, 6♣, 10♣, A♦, 5♦, 9♦, K♦, 4♥, 8♥, Q♥, 3♠, 7♠, J♠\n"


            +
            "C3: 3♣, 7♣, J♣, 2♦, 6♦, 10♦, A♥, 5♥, 9♥, K♥, 4♠, 8♠, Q♠\n"


            +
            "C4: 4♣, 8♣, Q♣, 3♦, 7♦, J♦, 2♥, 6♥, 10♥, A♠, 5♠, 9♠, K♠\n"


            +
            "F1:\n"


            +
            "F2:\n"


            +
            "F3:\n"


            +
            "F4:\n"


            +
            "O1: 10♠\n"


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
            "C1: A♣, 5♣, 9♣, K♣, 4♦, 8♦, Q♦, 3♥, 7♥, J♥, 2♠, 6♠\n"


            +
            "C2: 2♣, 6♣, 10♣, A♦, 5♦, 9♦, K♦, 4♥, 8♥, Q♥, 3♠, 7♠, J♠\n"


            +
            "C3: 3♣, 7♣, J♣, 2♦, 6♦, 10♦, A♥, 5♥, 9♥, K♥, 4♠, 8♠, Q♠\n"


            +
            "C4: 4♣, 8♣, Q♣, 3♦, 7♦, J♦, 2♥, 6♥, 10♥, A♠, 5♠, 9♠, K♠\n"


            +
            "Game quit prematurely.";
    assertEquals(out.toString(), out1);
  }


  @Test
  public void playGameOnlyq() {
    FreecellOperations model = FreecellModel
            .getBuilder()
            .cascades(4)
            .opens(6)
            .build();
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("q");
    //Reader in = new InputStreamReader(System.in);
    IFreecellController controller = new FreecellController(in, out);
    List deck = model.getDeck();
    controller.playGame(deck, model, false);
    assertEquals("F1:\n"


            +
            "F2:\n"


            +
            "F3:\n"


            + "F4:\n"


            + "O1:\n"


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
            "C1: A♣, 5♣, 9♣, K♣, 4♦, 8♦, Q♦, 3♥, 7♥, J♥, 2♠, 6♠, 10♠\n"


            +
            "C2: 2♣, 6♣, 10♣, A♦, 5♦, 9♦, K♦, 4♥, 8♥, Q♥, 3♠, 7♠, J♠\n"


            +
            "C3: 3♣, 7♣, J♣, 2♦, 6♦, 10♦, A♥, 5♥, 9♥, K♥, 4♠, 8♠, Q♠\n"


            +
            "C4: 4♣, 8♣, Q♣, 3♦, 7♦, J♦, 2♥, 6♥, 10♥, A♠, 5♠, 9♠, K♠\n"


            +
            "Game quit prematurely.", out.toString());
  }


  @Test
  public void playGameMuktipleSpacesInBetween() {
    FreecellOperations model = FreecellModel
            .getBuilder()
            .cascades(4)
            .opens(6)
            .build();
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("C1 13        O1 Q");
    //Reader in = new InputStreamReader(System.in);
    IFreecellController controller = new FreecellController(in, out);
    List deck = model.getDeck();
    controller.playGame(deck, model, false);

    assertEquals("F1:\n"
            +
            "F2:\n"
            +
            "F3:\n"
            +
            "F4:\n"
            +
            "O1:\n"
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
            "C1: A♣, 5♣, 9♣, K♣, 4♦, 8♦, Q♦, 3♥, 7♥, J♥, 2♠, 6♠, 10♠\n"
            +
            "C2: 2♣, 6♣, 10♣, A♦, 5♦, 9♦, K♦, 4♥, 8♥, Q♥, 3♠, 7♠, J♠\n"
            +
            "C3: 3♣, 7♣, J♣, 2♦, 6♦, 10♦, A♥, 5♥, 9♥, K♥, 4♠, 8♠, Q♠\n"
            +
            "C4: 4♣, 8♣, Q♣, 3♦, 7♦, J♦, 2♥, 6♥, 10♥, A♠, 5♠, 9♠, K♠\n"
            +
            "F1:\n"
            +
            "F2:\n"
            +
            "F3:\n"
            +
            "F4:\n"
            +
            "O1: 10♠\n"
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
            "C1: A♣, 5♣, 9♣, K♣, 4♦, 8♦, Q♦, 3♥, 7♥, J♥, 2♠, 6♠\n"
            +
            "C2: 2♣, 6♣, 10♣, A♦, 5♦, 9♦, K♦, 4♥, 8♥, Q♥, 3♠, 7♠, J♠\n"
            +
            "C3: 3♣, 7♣, J♣, 2♦, 6♦, 10♦, A♥, 5♥, 9♥, K♥, 4♠, 8♠, Q♠\n"
            +
            "C4: 4♣, 8♣, Q♣, 3♦, 7♦, J♦, 2♥, 6♥, 10♥, A♠, 5♠, 9♠, K♠\n"
            +
            "Game quit prematurely.", out.toString());
  }

  @Test
  public void playGameMultipleMoves() {

    FreecellOperations model = FreecellModel
            .getBuilder()
            .cascades(4)
            .opens(6)
            .build();
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("C1 13 O1 C2 13 O2 C3 13 03 Q");
    //Reader in = new InputStreamReader(System.in);
    IFreecellController controller = new FreecellController(in, out);
    List deck = model.getDeck();
    controller.playGame(deck, model, false);
    assertEquals("F1:\n"
            +
            "F2:\n"
            +
            "F3:\n"
            +
            "F4:\n"
            +
            "O1:\n"
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
            "C1: A♣, 5♣, 9♣, K♣, 4♦, 8♦, Q♦, 3♥, 7♥, J♥, 2♠, 6♠, 10♠\n"
            +
            "C2: 2♣, 6♣, 10♣, A♦, 5♦, 9♦, K♦, 4♥, 8♥, Q♥, 3♠, 7♠, J♠\n"
            +
            "C3: 3♣, 7♣, J♣, 2♦, 6♦, 10♦, A♥, 5♥, 9♥, K♥, 4♠, 8♠, Q♠\n"
            +
            "C4: 4♣, 8♣, Q♣, 3♦, 7♦, J♦, 2♥, 6♥, 10♥, A♠, 5♠, 9♠, K♠\n"
            +
            "F1:\n"
            +
            "F2:\n"
            +
            "F3:\n"
            +
            "F4:\n"
            +
            "O1: 10♠\n"
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
            "C1: A♣, 5♣, 9♣, K♣, 4♦, 8♦, Q♦, 3♥, 7♥, J♥, 2♠, 6♠\n"
            +
            "C2: 2♣, 6♣, 10♣, A♦, 5♦, 9♦, K♦, 4♥, 8♥, Q♥, 3♠, 7♠, J♠\n"
            +
            "C3: 3♣, 7♣, J♣, 2♦, 6♦, 10♦, A♥, 5♥, 9♥, K♥, 4♠, 8♠, Q♠\n"
            +
            "C4: 4♣, 8♣, Q♣, 3♦, 7♦, J♦, 2♥, 6♥, 10♥, A♠, 5♠, 9♠, K♠\n"
            +
            "F1:\n"
            +
            "F2:\n"
            +
            "F3:\n"
            +
            "F4:\n"
            +
            "O1: 10♠\n"
            +
            "O2: J♠\n"
            +
            "O3:\n"
            +
            "O4:\n"
            +
            "O5:\n"
            +
            "O6:\n"
            +
            "C1: A♣, 5♣, 9♣, K♣, 4♦, 8♦, Q♦, 3♥, 7♥, J♥, 2♠, 6♠\n"
            +
            "C2: 2♣, 6♣, 10♣, A♦, 5♦, 9♦, K♦, 4♥, 8♥, Q♥, 3♠, 7♠\n"
            +
            "C3: 3♣, 7♣, J♣, 2♦, 6♦, 10♦, A♥, 5♥, 9♥, K♥, 4♠, 8♠, Q♠\n"
            +
            "C4: 4♣, 8♣, Q♣, 3♦, 7♦, J♦, 2♥, 6♥, 10♥, A♠, 5♠, 9♠, K♠\n"
            +
            "Game quit prematurely.", out.toString());

  }


  @Test
  public void playGameWrongDestination() {
    FreecellOperations model = FreecellModel
            .getBuilder()
            .cascades(4)
            .opens(6)
            .build();
    StringBuffer out = new StringBuffer();

    Reader in = new StringReader("C1 13 aaaa O1 q");
    IFreecellController controller = new FreecellController(in, out);
    List deck = model.getDeck();
    controller.playGame(deck, model, false);

    assertEquals("F1:\n"
            +
            "F2:\n"
            +
            "F3:\n"
            +
            "F4:\n"
            +
            "O1:\n"
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
            "C1: A♣, 5♣, 9♣, K♣, 4♦, 8♦, Q♦, 3♥, 7♥, J♥, 2♠, 6♠, 10♠\n"
            +
            "C2: 2♣, 6♣, 10♣, A♦, 5♦, 9♦, K♦, 4♥, 8♥, Q♥, 3♠, 7♠, J♠\n"
            +
            "C3: 3♣, 7♣, J♣, 2♦, 6♦, 10♦, A♥, 5♥, 9♥, K♥, 4♠, 8♠, Q♠\n"
            +
            "C4: 4♣, 8♣, Q♣, 3♦, 7♦, J♦, 2♥, 6♥, 10♥, A♠, 5♠, 9♠, K♠\n"
            +
            "F1:\n"
            +
            "F2:\n"
            +
            "F3:\n"
            +
            "F4:\n"
            +
            "O1: 10♠\n"
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
            "C1: A♣, 5♣, 9♣, K♣, 4♦, 8♦, Q♦, 3♥, 7♥, J♥, 2♠, 6♠\n"
            +
            "C2: 2♣, 6♣, 10♣, A♦, 5♦, 9♦, K♦, 4♥, 8♥, Q♥, 3♠, 7♠, J♠\n"
            +
            "C3: 3♣, 7♣, J♣, 2♦, 6♦, 10♦, A♥, 5♥, 9♥, K♥, 4♠, 8♠, Q♠\n"
            +
            "C4: 4♣, 8♣, Q♣, 3♦, 7♦, J♦, 2♥, 6♥, 10♥, A♠, 5♠, 9♠, K♠\n"
            +
            "Game quit prematurely.", out.toString());

  }

  @Test
  public void playGameWrongCardIndex() {
    FreecellOperations model = FreecellModel
            .getBuilder()
            .cascades(4)
            .opens(6)
            .build();
    StringBuffer out = new StringBuffer();

    Reader in = new StringReader("C1 aaaa 13 O1 q");
    IFreecellController controller = new FreecellController(in, out);
    List deck = model.getDeck();
    controller.playGame(deck, model, false);

    assertEquals("F1:\n"
            +
            "F2:\n"
            +
            "F3:\n"
            +
            "F4:\n"
            +
            "O1:\n"
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
            "C1: A♣, 5♣, 9♣, K♣, 4♦, 8♦, Q♦, 3♥, 7♥, J♥, 2♠, 6♠, 10♠\n"
            +
            "C2: 2♣, 6♣, 10♣, A♦, 5♦, 9♦, K♦, 4♥, 8♥, Q♥, 3♠, 7♠, J♠\n"
            +
            "C3: 3♣, 7♣, J♣, 2♦, 6♦, 10♦, A♥, 5♥, 9♥, K♥, 4♠, 8♠, Q♠\n"
            +
            "C4: 4♣, 8♣, Q♣, 3♦, 7♦, J♦, 2♥, 6♥, 10♥, A♠, 5♠, 9♠, K♠\n"
            +
            "F1:\n"
            +
            "F2:\n"
            +
            "F3:\n"
            +
            "F4:\n"
            +
            "O1: 10♠\n"
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
            "C1: A♣, 5♣, 9♣, K♣, 4♦, 8♦, Q♦, 3♥, 7♥, J♥, 2♠, 6♠\n"
            +
            "C2: 2♣, 6♣, 10♣, A♦, 5♦, 9♦, K♦, 4♥, 8♥, Q♥, 3♠, 7♠, J♠\n"
            +
            "C3: 3♣, 7♣, J♣, 2♦, 6♦, 10♦, A♥, 5♥, 9♥, K♥, 4♠, 8♠, Q♠\n"
            +
            "C4: 4♣, 8♣, Q♣, 3♦, 7♦, J♦, 2♥, 6♥, 10♥, A♠, 5♠, 9♠, K♠\n"
            +
            "Game quit prematurely.", out.toString());

  }

  @Test
  public void playGameWrongSource() {
    FreecellOperations model = FreecellModel
            .getBuilder()
            .cascades(4)
            .opens(6)
            .build();
    StringBuffer out = new StringBuffer();

    Reader in = new StringReader("AAAA C1 13 O1 q");
    IFreecellController controller = new FreecellController(in, out);
    List deck = model.getDeck();
    controller.playGame(deck, model, false);

    assertEquals("F1:\n"
            +
            "F2:\n"
            +
            "F3:\n"
            +
            "F4:\n"
            +
            "O1:\n"
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
            "C1: A♣, 5♣, 9♣, K♣, 4♦, 8♦, Q♦, 3♥, 7♥, J♥, 2♠, 6♠, 10♠\n"
            +
            "C2: 2♣, 6♣, 10♣, A♦, 5♦, 9♦, K♦, 4♥, 8♥, Q♥, 3♠, 7♠, J♠\n"
            +
            "C3: 3♣, 7♣, J♣, 2♦, 6♦, 10♦, A♥, 5♥, 9♥, K♥, 4♠, 8♠, Q♠\n"
            +
            "C4: 4♣, 8♣, Q♣, 3♦, 7♦, J♦, 2♥, 6♥, 10♥, A♠, 5♠, 9♠, K♠\n"
            +
            "F1:\n"
            +
            "F2:\n"
            +
            "F3:\n"
            +
            "F4:\n"
            +
            "O1: 10♠\n"
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
            "C1: A♣, 5♣, 9♣, K♣, 4♦, 8♦, Q♦, 3♥, 7♥, J♥, 2♠, 6♠\n"
            +
            "C2: 2♣, 6♣, 10♣, A♦, 5♦, 9♦, K♦, 4♥, 8♥, Q♥, 3♠, 7♠, J♠\n"
            +
            "C3: 3♣, 7♣, J♣, 2♦, 6♦, 10♦, A♥, 5♥, 9♥, K♥, 4♠, 8♠, Q♠\n"
            +
            "C4: 4♣, 8♣, Q♣, 3♦, 7♦, J♦, 2♥, 6♥, 10♥, A♠, 5♠, 9♠, K♠\n"
            +
            "Game quit prematurely.", out.toString());

  }

  @Test
  public void playGameCallingMultiMove() {
    FreecellOperations model = FreecellMultiMoveModel
            .getBuilder()
            .cascades(4)
            .opens(6)
            .build();
    StringBuffer out = new StringBuffer();

    Reader in = new StringReader("C1 13 O1 q");
    IFreecellController controller = new FreecellController(in, out);
    List deck = model.getDeck();
    controller.playGame(deck, model, false);

    assertEquals("F1:\n"
            +
            "F2:\n"
            +
            "F3:\n"
            +
            "F4:\n"
            +
            "O1:\n"
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
            "C1: A♣, 5♣, 9♣, K♣, 4♦, 8♦, Q♦, 3♥, 7♥, J♥, 2♠, 6♠, 10♠\n"
            +
            "C2: 2♣, 6♣, 10♣, A♦, 5♦, 9♦, K♦, 4♥, 8♥, Q♥, 3♠, 7♠, J♠\n"
            +
            "C3: 3♣, 7♣, J♣, 2♦, 6♦, 10♦, A♥, 5♥, 9♥, K♥, 4♠, 8♠, Q♠\n"
            +
            "C4: 4♣, 8♣, Q♣, 3♦, 7♦, J♦, 2♥, 6♥, 10♥, A♠, 5♠, 9♠, K♠\n"
            +
            "F1:\n"
            +
            "F2:\n"
            +
            "F3:\n"
            +
            "F4:\n"
            +
            "O1: 10♠\n"
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
            "C1: A♣, 5♣, 9♣, K♣, 4♦, 8♦, Q♦, 3♥, 7♥, J♥, 2♠, 6♠\n"
            +
            "C2: 2♣, 6♣, 10♣, A♦, 5♦, 9♦, K♦, 4♥, 8♥, Q♥, 3♠, 7♠, J♠\n"
            +
            "C3: 3♣, 7♣, J♣, 2♦, 6♦, 10♦, A♥, 5♥, 9♥, K♥, 4♠, 8♠, Q♠\n"
            +
            "C4: 4♣, 8♣, Q♣, 3♦, 7♦, J♦, 2♥, 6♥, 10♥, A♠, 5♠, 9♠, K♠\n"
            +
            "Game quit prematurely.", out.toString());

  }


  @Test(expected = IllegalArgumentException.class)
  public void playGameCallingNullDeck() {
    FreecellOperations model = FreecellMultiMoveModel
            .getBuilder()
            .cascades(4)
            .opens(6)
            .build();
    StringBuffer out = new StringBuffer();

    Reader in = new StringReader("C1 13 O1 q");
    IFreecellController controller = new FreecellController(in, out);
    List deck = model.getDeck();
    controller.playGame(null, model, false);

  }

  @Test(expected = IllegalArgumentException.class)
  public void playGameCallingNullModel() {
    FreecellOperations model = FreecellMultiMoveModel
            .getBuilder()
            .cascades(4)
            .opens(6)
            .build();
    StringBuffer out = new StringBuffer();

    Reader in = new StringReader("C1 13 O1 q");
    IFreecellController controller = new FreecellController(in, out);
    List deck = model.getDeck();
    controller.playGame(deck, null, false);

  }


  @Test
  public void playGameInvalidMoveCascadeToOpen() {
    FreecellOperations model = FreecellMultiMoveModel
            .getBuilder()
            .cascades(52)
            .opens(52)
            .build();
    StringBuffer out = new StringBuffer();

    Reader in = new StringReader("C1 13 O1 q");
    IFreecellController controller = new FreecellController(in, out);
    List deck = model.getDeck();
    controller.playGame(deck, model, true);
    assertEquals("F1:\n"
            +
            "F2:\n"
            +
            "F3:\n"
            +
            "F4:\n"
            +
            "O1:\n"
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
            "C1: 9♠\n"
            +
            "C2: Q♦\n"
            +
            "C3: K♦\n"
            +
            "C4: J♥\n"
            +
            "C5: 3♦\n"
            +
            "C6: 5♠\n"
            +
            "C7: K♠\n"
            +
            "C8: 10♣\n"
            +
            "C9: J♦\n"
            +
            "C10: 6♣\n"
            +
            "C11: 9♥\n"
            +
            "C12: 6♦\n"
            +
            "C13: 10♠\n"
            +
            "C14: J♣\n"
            +
            "C15: 6♥\n"
            +
            "C16: 5♥\n"
            +
            "C17: A♠\n"
            +
            "C18: 3♠\n"
            +
            "C19: 4♠\n"
            +
            "C20: 8♦\n"
            +
            "C21: Q♥\n"
            +
            "C22: 8♠\n"
            +
            "C23: 2♣\n"
            +
            "C24: K♣\n"
            +
            "C25: 8♣\n"
            +
            "C26: A♦\n"
            +
            "C27: K♥\n"
            +
            "C28: 2♠\n"
            +
            "C29: 7♦\n"
            +
            "C30: 2♦\n"
            +
            "C31: 7♣\n"
            +
            "C32: 9♣\n"
            +
            "C33: 7♥\n"
            +
            "C34: 4♣\n"
            +
            "C35: A♣\n"
            +
            "C36: 5♣\n"
            +
            "C37: 2♥\n"
            +
            "C38: 5♦\n"
            +
            "C39: Q♠\n"
            +
            "C40: 8♥\n"
            +
            "C41: 4♦\n"
            +
            "C42: J♠\n"
            +
            "C43: A♥\n"
            +
            "C44: 7♠\n"
            +
            "C45: 9♦\n"
            +
            "C46: 10♥\n"
            +
            "C47: 10♦\n"
            +
            "C48: Q♣\n"
            +
            "C49: 3♣\n"
            +
            "C50: 4♥\n"
            +
            "C51: 3♥\n"
            +
            "C52: 6♠\n"
            +
            "Invalid move. Try again.\n"
            +
            "Game quit prematurely.", out.toString());

  }


  @Test(expected = IllegalStateException.class)
  public void InvalidDeck() {
    FreecellOperations model = FreecellMultiMoveModel
            .getBuilder()
            .cascades(52)
            .opens(52)
            .build();
    StringBuffer out = new StringBuffer();

    Reader in = new StringReader("C1 13 O1 q");
    IFreecellController controller = new FreecellController(in, out);
    List deck = model.getDeck();
    deck.add(null);
    controller.playGame(deck, model, true);

  }

  @Test
  public void openToOpenValid() {
    FreecellOperations model = FreecellMultiMoveModel
            .getBuilder()
            .cascades(52)
            .opens(52)
            .build();
    StringBuffer out = new StringBuffer();

    Reader in = new StringReader("C1 1 O1 O1 1 O2 q");
    IFreecellController controller = new FreecellController(in, out);
    List deck = model.getDeck();
    controller.playGame(deck, model, true);
    assertEquals("F1:\n"
            +
            "F2:\n"
            +
            "F3:\n"
            +
            "F4:\n"
            +
            "O1:\n"
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
            "C1: 9♠\n"
            +
            "C2: Q♦\n"
            +
            "C3: K♦\n"
            +
            "C4: J♥\n"
            +
            "C5: 3♦\n"
            +
            "C6: 5♠\n"
            +
            "C7: K♠\n"
            +
            "C8: 10♣\n"
            +
            "C9: J♦\n"
            +
            "C10: 6♣\n"
            +
            "C11: 9♥\n"
            +
            "C12: 6♦\n"
            +
            "C13: 10♠\n"
            +
            "C14: J♣\n"
            +
            "C15: 6♥\n"
            +
            "C16: 5♥\n"
            +
            "C17: A♠\n"
            +
            "C18: 3♠\n"
            +
            "C19: 4♠\n"
            +
            "C20: 8♦\n"
            +
            "C21: Q♥\n"
            +
            "C22: 8♠\n"
            +
            "C23: 2♣\n"
            +
            "C24: K♣\n"
            +
            "C25: 8♣\n"
            +
            "C26: A♦\n"
            +
            "C27: K♥\n"
            +
            "C28: 2♠\n"
            +
            "C29: 7♦\n"
            +
            "C30: 2♦\n"
            +
            "C31: 7♣\n"
            +
            "C32: 9♣\n"
            +
            "C33: 7♥\n"
            +
            "C34: 4♣\n"
            +
            "C35: A♣\n"
            +
            "C36: 5♣\n"
            +
            "C37: 2♥\n"
            +
            "C38: 5♦\n"
            +
            "C39: Q♠\n"
            +
            "C40: 8♥\n"
            +
            "C41: 4♦\n"
            +
            "C42: J♠\n"
            +
            "C43: A♥\n"
            +
            "C44: 7♠\n"
            +
            "C45: 9♦\n"
            +
            "C46: 10♥\n"
            +
            "C47: 10♦\n"
            +
            "C48: Q♣\n"
            +
            "C49: 3♣\n"
            +
            "C50: 4♥\n"
            +
            "C51: 3♥\n"
            +
            "C52: 6♠\n"
            +
            "F1:\n"
            +
            "F2:\n"
            +
            "F3:\n"
            +
            "F4:\n"
            +
            "O1: 9♠\n"
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
            "C2: Q♦\n"
            +
            "C3: K♦\n"
            +
            "C4: J♥\n"
            +
            "C5: 3♦\n"
            +
            "C6: 5♠\n"
            +
            "C7: K♠\n"
            +
            "C8: 10♣\n"
            +
            "C9: J♦\n"
            +
            "C10: 6♣\n"
            +
            "C11: 9♥\n"
            +
            "C12: 6♦\n"
            +
            "C13: 10♠\n"
            +
            "C14: J♣\n"
            +
            "C15: 6♥\n"
            +
            "C16: 5♥\n"
            +
            "C17: A♠\n"
            +
            "C18: 3♠\n"
            +
            "C19: 4♠\n"
            +
            "C20: 8♦\n"
            +
            "C21: Q♥\n"
            +
            "C22: 8♠\n"
            +
            "C23: 2♣\n"
            +
            "C24: K♣\n"
            +
            "C25: 8♣\n"
            +
            "C26: A♦\n"
            +
            "C27: K♥\n"
            +
            "C28: 2♠\n"
            +
            "C29: 7♦\n"
            +
            "C30: 2♦\n"
            +
            "C31: 7♣\n"
            +
            "C32: 9♣\n"
            +
            "C33: 7♥\n"
            +
            "C34: 4♣\n"
            +
            "C35: A♣\n"
            +
            "C36: 5♣\n"
            +
            "C37: 2♥\n"
            +
            "C38: 5♦\n"
            +
            "C39: Q♠\n"
            +
            "C40: 8♥\n"
            +
            "C41: 4♦\n"
            +
            "C42: J♠\n"
            +
            "C43: A♥\n"
            +
            "C44: 7♠\n"
            +
            "C45: 9♦\n"
            +
            "C46: 10♥\n"
            +
            "C47: 10♦\n"
            +
            "C48: Q♣\n"
            +
            "C49: 3♣\n"
            +
            "C50: 4♥\n"
            +
            "C51: 3♥\n"
            +
            "C52: 6♠\n"
            +
            "F1:\n"
            +
            "F2:\n"
            +
            "F3:\n"
            +
            "F4:\n"
            +
            "O1:\n"
            +
            "O2: 9♠\n"
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
            "C2: Q♦\n"
            +
            "C3: K♦\n"
            +
            "C4: J♥\n"
            +
            "C5: 3♦\n"
            +
            "C6: 5♠\n"
            +
            "C7: K♠\n"
            +
            "C8: 10♣\n"
            +
            "C9: J♦\n"
            +
            "C10: 6♣\n"
            +
            "C11: 9♥\n"
            +
            "C12: 6♦\n"
            +
            "C13: 10♠\n"
            +
            "C14: J♣\n"
            +
            "C15: 6♥\n"
            +
            "C16: 5♥\n"
            +
            "C17: A♠\n"
            +
            "C18: 3♠\n"
            +
            "C19: 4♠\n"
            +
            "C20: 8♦\n"
            +
            "C21: Q♥\n"
            +
            "C22: 8♠\n"
            +
            "C23: 2♣\n"
            +
            "C24: K♣\n"
            +
            "C25: 8♣\n"
            +
            "C26: A♦\n"
            +
            "C27: K♥\n"
            +
            "C28: 2♠\n"
            +
            "C29: 7♦\n"
            +
            "C30: 2♦\n"
            +
            "C31: 7♣\n"
            +
            "C32: 9♣\n"
            +
            "C33: 7♥\n"
            +
            "C34: 4♣\n"
            +
            "C35: A♣\n"
            +
            "C36: 5♣\n"
            +
            "C37: 2♥\n"
            +
            "C38: 5♦\n"
            +
            "C39: Q♠\n"
            +
            "C40: 8♥\n"
            +
            "C41: 4♦\n"
            +
            "C42: J♠\n"
            +
            "C43: A♥\n"
            +
            "C44: 7♠\n"
            +
            "C45: 9♦\n"
            +
            "C46: 10♥\n"
            +
            "C47: 10♦\n"
            +
            "C48: Q♣\n"
            +
            "C49: 3♣\n"
            +
            "C50: 4♥\n"
            +
            "C51: 3♥\n"
            +
            "C52: 6♠\n"
            +
            "Game quit prematurely.", out.toString());

  }

  @Test
  public void allInValid() {
    FreecellOperations model = FreecellMultiMoveModel
            .getBuilder()
            .cascades(4)
            .opens(1)
            .build();
    StringBuffer out = new StringBuffer();

    Reader in = new StringReader("O1 13 O2 "
            +
            "O1 13 F1 "
            +
            "O1 12 C1 "
            +
            "F1 12 F2 "
            +
            "F1 12 O1 "
            +
            "F1 12 C1 "
            +
            "C1 12 C2 "
            +
            "C2 12 F1 "
            +
            "q");
    IFreecellController controller = new FreecellController(in, out);
    List deck = model.getDeck();
    controller.playGame(deck, model, true);
    assertEquals("F1:\n"
            +
            "F2:\n"
            +
            "F3:\n"
            +
            "F4:\n"
            +
            "O1:\n"
            +
            "C1: 9♠, 3♦, J♦, 10♠, A♠, Q♥, 8♣, 7♦, 7♥, 2♥, 4♦, 9♦, 3♣\n"
            +
            "C2: Q♦, 5♠, 6♣, J♣, 3♠, 8♠, A♦, 2♦, 4♣, 5♦, J♠, 10♥, 4♥\n"
            +
            "C3: K♦, K♠, 9♥, 6♥, 4♠, 2♣, K♥, 7♣, A♣, Q♠, A♥, 10♦, 3♥\n"
            +
            "C4: J♥, 10♣, 6♦, 5♥, 8♦, K♣, 2♠, 9♣, 5♣, 8♥, 7♠, Q♣, 6♠\n"
            +
            "Invalid move. Try again.\n"
            +
            "Invalid move. Try again.\n"
            +
            "Invalid move. Try again.\n"
            +
            "Invalid move. Try again.\n"
            +
            "Invalid move. Try again.\n"
            +
            "Invalid move. Try again.\n"
            +
            "Invalid move. Try again.\n"
            +
            "Invalid move. Try again.\n"
            +
            "Game quit prematurely.", out.toString());

  }

  @Test
  public void cascadeToFoundationValid() {
    FreecellOperations model = FreecellMultiMoveModel
            .getBuilder()
            .cascades(52)
            .opens(52)
            .build();
    StringBuffer out = new StringBuffer();

    Reader in = new StringReader("C1 1 F1 Q");
    IFreecellController controller = new FreecellController(in, out);
    List deck = model.getDeck();
    controller.playGame(deck, model, false);
    assertEquals("F1:\n"
            +
            "F2:\n"
            +
            "F3:\n"
            +
            "F4:\n"
            +
            "O1:\n"
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
            "C2: 2♣\n"
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
            "C52: K♠\n"
            +
            "F1: A♣\n"
            +
            "F2:\n"
            +
            "F3:\n"
            +
            "F4:\n"
            +
            "O1:\n"
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
            "C2: 2♣\n"
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
            "C52: K♠\n"
            +
            "Game quit prematurely.", out.toString());

  }

  @Test
  public void testvalidmoves() {
    FreecellOperations model = FreecellModel
            .getBuilder()
            .cascades(8)
            .opens(6)
            .build();
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("C8 6 O1 " +
            "C8 5 F2 " +
            "C8 4 O6 " +
            "C1 7 O4 " +
            "C1 6 F2 " +
            "F2 2 O2 " +
            "F2 1 O5 " +
            "O5 1 F2 " +
            "O2 1 F2 " +
            "O6 1 C6 " +
            "O4 1 O5 " +
            "C2 7 O6 " +
            "C2 6 O3 " +
            "O3 1 F2 " +
            "C6 7 O2 " +
            "C6 6 O3 " +
            "C6 5 O4 " +
            "F2 3 C6 " +
            "C1 5 C7 " +
            "Q");
    //Reader in = new InputStreamReader(System.in);
    IFreecellController controller = new FreecellController(in, out);
    List deck = model.getDeck();
    controller.playGame(deck, model, false);
    String out1 = "F1:\n"
            +
            "F2:\n"
            +
            "F3:\n"
            +
            "F4:\n"
            +
            "O1:\n"
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
            "C1: A♣, 9♣, 4♦, Q♦, 7♥, 2♠, 10♠\n"
            +
            "C2: 2♣, 10♣, 5♦, K♦, 8♥, 3♠, J♠\n"
            +
            "C3: 3♣, J♣, 6♦, A♥, 9♥, 4♠, Q♠\n"
            +
            "C4: 4♣, Q♣, 7♦, 2♥, 10♥, 5♠, K♠\n"
            +
            "C5: 5♣, K♣, 8♦, 3♥, J♥, 6♠\n"
            +
            "C6: 6♣, A♦, 9♦, 4♥, Q♥, 7♠\n"
            +
            "C7: 7♣, 2♦, 10♦, 5♥, K♥, 8♠\n"
            +
            "C8: 8♣, 3♦, J♦, 6♥, A♠, 9♠\n"
            +
            "F1:\n"
            +
            "F2:\n"
            +
            "F3:\n"
            +
            "F4:\n"
            +
            "O1: 9♠\n"
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
            "C1: A♣, 9♣, 4♦, Q♦, 7♥, 2♠, 10♠\n"
            +
            "C2: 2♣, 10♣, 5♦, K♦, 8♥, 3♠, J♠\n"
            +
            "C3: 3♣, J♣, 6♦, A♥, 9♥, 4♠, Q♠\n"
            +
            "C4: 4♣, Q♣, 7♦, 2♥, 10♥, 5♠, K♠\n"
            +
            "C5: 5♣, K♣, 8♦, 3♥, J♥, 6♠\n"
            +
            "C6: 6♣, A♦, 9♦, 4♥, Q♥, 7♠\n"
            +
            "C7: 7♣, 2♦, 10♦, 5♥, K♥, 8♠\n"
            +
            "C8: 8♣, 3♦, J♦, 6♥, A♠\n"
            +
            "F1:\n"
            +
            "F2: A♠\n"
            +
            "F3:\n"
            +
            "F4:\n"
            +
            "O1: 9♠\n"
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
            "C1: A♣, 9♣, 4♦, Q♦, 7♥, 2♠, 10♠\n"
            +
            "C2: 2♣, 10♣, 5♦, K♦, 8♥, 3♠, J♠\n"
            +
            "C3: 3♣, J♣, 6♦, A♥, 9♥, 4♠, Q♠\n"
            +
            "C4: 4♣, Q♣, 7♦, 2♥, 10♥, 5♠, K♠\n"
            +
            "C5: 5♣, K♣, 8♦, 3♥, J♥, 6♠\n"
            +
            "C6: 6♣, A♦, 9♦, 4♥, Q♥, 7♠\n"
            +
            "C7: 7♣, 2♦, 10♦, 5♥, K♥, 8♠\n"
            +
            "C8: 8♣, 3♦, J♦, 6♥\n"
            +
            "F1:\n"
            +
            "F2: A♠\n"
            +
            "F3:\n"
            +
            "F4:\n"
            +
            "O1: 9♠\n"
            +
            "O2:\n"
            +
            "O3:\n"
            +
            "O4:\n"
            +
            "O5:\n"
            +
            "O6: 6♥\n"
            +
            "C1: A♣, 9♣, 4♦, Q♦, 7♥, 2♠, 10♠\n"
            +
            "C2: 2♣, 10♣, 5♦, K♦, 8♥, 3♠, J♠\n"
            +
            "C3: 3♣, J♣, 6♦, A♥, 9♥, 4♠, Q♠\n"
            +
            "C4: 4♣, Q♣, 7♦, 2♥, 10♥, 5♠, K♠\n"
            +
            "C5: 5♣, K♣, 8♦, 3♥, J♥, 6♠\n"
            +
            "C6: 6♣, A♦, 9♦, 4♥, Q♥, 7♠\n"
            +
            "C7: 7♣, 2♦, 10♦, 5♥, K♥, 8♠\n"
            +
            "C8: 8♣, 3♦, J♦\n"
            +
            "F1:\n"
            +
            "F2: A♠\n"
            +
            "F3:\n"
            +
            "F4:\n"
            +
            "O1: 9♠\n"
            +
            "O2:\n"
            +
            "O3:\n"
            +
            "O4: 10♠\n"
            +
            "O5:\n"
            +
            "O6: 6♥\n"
            +
            "C1: A♣, 9♣, 4♦, Q♦, 7♥, 2♠\n"
            +
            "C2: 2♣, 10♣, 5♦, K♦, 8♥, 3♠, J♠\n"
            +
            "C3: 3♣, J♣, 6♦, A♥, 9♥, 4♠, Q♠\n"
            +
            "C4: 4♣, Q♣, 7♦, 2♥, 10♥, 5♠, K♠\n"
            +
            "C5: 5♣, K♣, 8♦, 3♥, J♥, 6♠\n"
            +
            "C6: 6♣, A♦, 9♦, 4♥, Q♥, 7♠\n"
            +
            "C7: 7♣, 2♦, 10♦, 5♥, K♥, 8♠\n"
            +
            "C8: 8♣, 3♦, J♦\n"
            +
            "F1:\n"
            +
            "F2: A♠, 2♠\n"
            +
            "F3:\n"
            +
            "F4:\n"
            +
            "O1: 9♠\n"
            +
            "O2:\n"
            +
            "O3:\n"
            +
            "O4: 10♠\n"
            +
            "O5:\n"
            +
            "O6: 6♥\n"
            +
            "C1: A♣, 9♣, 4♦, Q♦, 7♥\n"
            +
            "C2: 2♣, 10♣, 5♦, K♦, 8♥, 3♠, J♠\n"
            +
            "C3: 3♣, J♣, 6♦, A♥, 9♥, 4♠, Q♠\n"
            +
            "C4: 4♣, Q♣, 7♦, 2♥, 10♥, 5♠, K♠\n"
            +
            "C5: 5♣, K♣, 8♦, 3♥, J♥, 6♠\n"
            +
            "C6: 6♣, A♦, 9♦, 4♥, Q♥, 7♠\n"
            +
            "C7: 7♣, 2♦, 10♦, 5♥, K♥, 8♠\n"
            +
            "C8: 8♣, 3♦, J♦\n"
            +
            "F1:\n"
            +
            "F2: A♠\n"
            +
            "F3:\n"
            +
            "F4:\n"
            +
            "O1: 9♠\n"
            +
            "O2: 2♠\n"
            +
            "O3:\n"
            +
            "O4: 10♠\n"
            +
            "O5:\n"
            +
            "O6: 6♥\n"
            +
            "C1: A♣, 9♣, 4♦, Q♦, 7♥\n"
            +
            "C2: 2♣, 10♣, 5♦, K♦, 8♥, 3♠, J♠\n"
            +
            "C3: 3♣, J♣, 6♦, A♥, 9♥, 4♠, Q♠\n"
            +
            "C4: 4♣, Q♣, 7♦, 2♥, 10♥, 5♠, K♠\n"
            +
            "C5: 5♣, K♣, 8♦, 3♥, J♥, 6♠\n"
            +
            "C6: 6♣, A♦, 9♦, 4♥, Q♥, 7♠\n"
            +
            "C7: 7♣, 2♦, 10♦, 5♥, K♥, 8♠\n"
            +
            "C8: 8♣, 3♦, J♦\n"
            +
            "F1:\n"
            +
            "F2:\n"
            +
            "F3:\n"
            +
            "F4:\n"
            +
            "O1: 9♠\n"
            +
            "O2: 2♠\n"
            +
            "O3:\n"
            +
            "O4: 10♠\n"
            +
            "O5: A♠\n"
            +
            "O6: 6♥\n"
            +
            "C1: A♣, 9♣, 4♦, Q♦, 7♥\n"
            +
            "C2: 2♣, 10♣, 5♦, K♦, 8♥, 3♠, J♠\n"
            +
            "C3: 3♣, J♣, 6♦, A♥, 9♥, 4♠, Q♠\n"
            +
            "C4: 4♣, Q♣, 7♦, 2♥, 10♥, 5♠, K♠\n"
            +
            "C5: 5♣, K♣, 8♦, 3♥, J♥, 6♠\n"
            +
            "C6: 6♣, A♦, 9♦, 4♥, Q♥, 7♠\n"
            +
            "C7: 7♣, 2♦, 10♦, 5♥, K♥, 8♠\n"
            +
            "C8: 8♣, 3♦, J♦\n"
            +
            "F1:\n"
            +
            "F2: A♠\n"
            +
            "F3:\n"
            +
            "F4:\n"
            +
            "O1: 9♠\n"
            +
            "O2: 2♠\n"
            +
            "O3:\n"
            +
            "O4: 10♠\n"
            +
            "O5:\n"
            +
            "O6: 6♥\n"
            +
            "C1: A♣, 9♣, 4♦, Q♦, 7♥\n"
            +
            "C2: 2♣, 10♣, 5♦, K♦, 8♥, 3♠, J♠\n"
            +
            "C3: 3♣, J♣, 6♦, A♥, 9♥, 4♠, Q♠\n"
            +
            "C4: 4♣, Q♣, 7♦, 2♥, 10♥, 5♠, K♠\n"
            +
            "C5: 5♣, K♣, 8♦, 3♥, J♥, 6♠\n"
            +
            "C6: 6♣, A♦, 9♦, 4♥, Q♥, 7♠\n"
            +
            "C7: 7♣, 2♦, 10♦, 5♥, K♥, 8♠\n"
            +
            "C8: 8♣, 3♦, J♦\n"
            +
            "F1:\n"
            +
            "F2: A♠, 2♠\n"
            +
            "F3:\n"
            +
            "F4:\n"
            +
            "O1: 9♠\n"
            +
            "O2:\n"
            +
            "O3:\n"
            +
            "O4: 10♠\n"
            +
            "O5:\n"
            +
            "O6: 6♥\n"
            +
            "C1: A♣, 9♣, 4♦, Q♦, 7♥\n"
            +
            "C2: 2♣, 10♣, 5♦, K♦, 8♥, 3♠, J♠\n"
            +
            "C3: 3♣, J♣, 6♦, A♥, 9♥, 4♠, Q♠\n"
            +
            "C4: 4♣, Q♣, 7♦, 2♥, 10♥, 5♠, K♠\n"
            +
            "C5: 5♣, K♣, 8♦, 3♥, J♥, 6♠\n"
            +
            "C6: 6♣, A♦, 9♦, 4♥, Q♥, 7♠\n"
            +
            "C7: 7♣, 2♦, 10♦, 5♥, K♥, 8♠\n"
            +
            "C8: 8♣, 3♦, J♦\n"
            +
            "F1:\n"
            +
            "F2: A♠, 2♠\n"
            +
            "F3:\n"
            +
            "F4:\n"
            +
            "O1: 9♠\n"
            +
            "O2:\n"
            +
            "O3:\n"
            +
            "O4: 10♠\n"
            +
            "O5:\n"
            +
            "O6:\n"
            +
            "C1: A♣, 9♣, 4♦, Q♦, 7♥\n"
            +
            "C2: 2♣, 10♣, 5♦, K♦, 8♥, 3♠, J♠\n"
            +
            "C3: 3♣, J♣, 6♦, A♥, 9♥, 4♠, Q♠\n"
            +
            "C4: 4♣, Q♣, 7♦, 2♥, 10♥, 5♠, K♠\n"
            +
            "C5: 5♣, K♣, 8♦, 3♥, J♥, 6♠\n"
            +
            "C6: 6♣, A♦, 9♦, 4♥, Q♥, 7♠, 6♥\n"
            +
            "C7: 7♣, 2♦, 10♦, 5♥, K♥, 8♠\n"
            +
            "C8: 8♣, 3♦, J♦\n"
            +
            "F1:\n"
            +
            "F2: A♠, 2♠\n"
            +
            "F3:\n"
            +
            "F4:\n"
            +
            "O1: 9♠\n"
            +
            "O2:\n"
            +
            "O3:\n"
            +
            "O4:\n"
            +
            "O5: 10♠\n"
            +
            "O6:\n"
            +
            "C1: A♣, 9♣, 4♦, Q♦, 7♥\n"
            +
            "C2: 2♣, 10♣, 5♦, K♦, 8♥, 3♠, J♠\n"
            +
            "C3: 3♣, J♣, 6♦, A♥, 9♥, 4♠, Q♠\n"
            +
            "C4: 4♣, Q♣, 7♦, 2♥, 10♥, 5♠, K♠\n"
            +
            "C5: 5♣, K♣, 8♦, 3♥, J♥, 6♠\n"
            +
            "C6: 6♣, A♦, 9♦, 4♥, Q♥, 7♠, 6♥\n"
            +
            "C7: 7♣, 2♦, 10♦, 5♥, K♥, 8♠\n"
            +
            "C8: 8♣, 3♦, J♦\n"
            +
            "F1:\n"
            +
            "F2: A♠, 2♠\n"
            +
            "F3:\n"
            +
            "F4:\n"
            +
            "O1: 9♠\n"
            +
            "O2:\n"
            +
            "O3:\n"
            +
            "O4:\n"
            +
            "O5: 10♠\n"
            +
            "O6: J♠\n"
            +
            "C1: A♣, 9♣, 4♦, Q♦, 7♥\n"
            +
            "C2: 2♣, 10♣, 5♦, K♦, 8♥, 3♠\n"
            +
            "C3: 3♣, J♣, 6♦, A♥, 9♥, 4♠, Q♠\n"
            +
            "C4: 4♣, Q♣, 7♦, 2♥, 10♥, 5♠, K♠\n"
            +
            "C5: 5♣, K♣, 8♦, 3♥, J♥, 6♠\n"
            +
            "C6: 6♣, A♦, 9♦, 4♥, Q♥, 7♠, 6♥\n"
            +
            "C7: 7♣, 2♦, 10♦, 5♥, K♥, 8♠\n"
            +
            "C8: 8♣, 3♦, J♦\n"
            +
            "F1:\n"
            +
            "F2: A♠, 2♠\n"
            +
            "F3:\n"
            +
            "F4:\n"
            +
            "O1: 9♠\n"
            +
            "O2:\n"
            +
            "O3: 3♠\n"
            +
            "O4:\n"
            +
            "O5: 10♠\n"
            +
            "O6: J♠\n"
            +
            "C1: A♣, 9♣, 4♦, Q♦, 7♥\n"
            +
            "C2: 2♣, 10♣, 5♦, K♦, 8♥\n"
            +
            "C3: 3♣, J♣, 6♦, A♥, 9♥, 4♠, Q♠\n"
            +
            "C4: 4♣, Q♣, 7♦, 2♥, 10♥, 5♠, K♠\n"
            +
            "C5: 5♣, K♣, 8♦, 3♥, J♥, 6♠\n"
            +
            "C6: 6♣, A♦, 9♦, 4♥, Q♥, 7♠, 6♥\n"
            +
            "C7: 7♣, 2♦, 10♦, 5♥, K♥, 8♠\n"
            +
            "C8: 8♣, 3♦, J♦\n"
            +
            "F1:\n"
            +
            "F2: A♠, 2♠, 3♠\n"
            +
            "F3:\n"
            +
            "F4:\n"
            +
            "O1: 9♠\n"
            +
            "O2:\n"
            +
            "O3:\n"
            +
            "O4:\n"
            +
            "O5: 10♠\n"
            +
            "O6: J♠\n"
            +
            "C1: A♣, 9♣, 4♦, Q♦, 7♥\n"
            +
            "C2: 2♣, 10♣, 5♦, K♦, 8♥\n"
            +
            "C3: 3♣, J♣, 6♦, A♥, 9♥, 4♠, Q♠\n"
            +
            "C4: 4♣, Q♣, 7♦, 2♥, 10♥, 5♠, K♠\n"
            +
            "C5: 5♣, K♣, 8♦, 3♥, J♥, 6♠\n"
            +
            "C6: 6♣, A♦, 9♦, 4♥, Q♥, 7♠, 6♥\n"
            +
            "C7: 7♣, 2♦, 10♦, 5♥, K♥, 8♠\n"
            +
            "C8: 8♣, 3♦, J♦\n"
            +
            "F1:\n"
            +
            "F2: A♠, 2♠, 3♠\n"
            +
            "F3:\n"
            +
            "F4:\n"
            +
            "O1: 9♠\n"
            +
            "O2: 6♥\n"
            +
            "O3:\n"
            +
            "O4:\n"
            +
            "O5: 10♠\n"
            +
            "O6: J♠\n"
            +
            "C1: A♣, 9♣, 4♦, Q♦, 7♥\n"
            +
            "C2: 2♣, 10♣, 5♦, K♦, 8♥\n"
            +
            "C3: 3♣, J♣, 6♦, A♥, 9♥, 4♠, Q♠\n"
            +
            "C4: 4♣, Q♣, 7♦, 2♥, 10♥, 5♠, K♠\n"
            +
            "C5: 5♣, K♣, 8♦, 3♥, J♥, 6♠\n"
            +
            "C6: 6♣, A♦, 9♦, 4♥, Q♥, 7♠\n"
            +
            "C7: 7♣, 2♦, 10♦, 5♥, K♥, 8♠\n"
            +
            "C8: 8♣, 3♦, J♦\n"
            +
            "F1:\n"
            +
            "F2: A♠, 2♠, 3♠\n"
            +
            "F3:\n"
            +
            "F4:\n"
            +
            "O1: 9♠\n"
            +
            "O2: 6♥\n"
            +
            "O3: 7♠\n"
            +
            "O4:\n"
            +
            "O5: 10♠\n"
            +
            "O6: J♠\n"
            +
            "C1: A♣, 9♣, 4♦, Q♦, 7♥\n"
            +
            "C2: 2♣, 10♣, 5♦, K♦, 8♥\n"
            +
            "C3: 3♣, J♣, 6♦, A♥, 9♥, 4♠, Q♠\n"
            +
            "C4: 4♣, Q♣, 7♦, 2♥, 10♥, 5♠, K♠\n"
            +
            "C5: 5♣, K♣, 8♦, 3♥, J♥, 6♠\n"
            +
            "C6: 6♣, A♦, 9♦, 4♥, Q♥\n"
            +
            "C7: 7♣, 2♦, 10♦, 5♥, K♥, 8♠\n"
            +
            "C8: 8♣, 3♦, J♦\n"
            +
            "F1:\n"
            +
            "F2: A♠, 2♠, 3♠\n"
            +
            "F3:\n"
            +
            "F4:\n"
            +
            "O1: 9♠\n"
            +
            "O2: 6♥\n"
            +
            "O3: 7♠\n"
            +
            "O4: Q♥\n"
            +
            "O5: 10♠\n"
            +
            "O6: J♠\n"
            +
            "C1: A♣, 9♣, 4♦, Q♦, 7♥\n"
            +
            "C2: 2♣, 10♣, 5♦, K♦, 8♥\n"
            +
            "C3: 3♣, J♣, 6♦, A♥, 9♥, 4♠, Q♠\n"
            +
            "C4: 4♣, Q♣, 7♦, 2♥, 10♥, 5♠, K♠\n"
            +
            "C5: 5♣, K♣, 8♦, 3♥, J♥, 6♠\n"
            +
            "C6: 6♣, A♦, 9♦, 4♥\n"
            +
            "C7: 7♣, 2♦, 10♦, 5♥, K♥, 8♠\n"
            +
            "C8: 8♣, 3♦, J♦\n"
            +
            "F1:\n"
            +
            "F2: A♠, 2♠\n"
            +
            "F3:\n"
            +
            "F4:\n"
            +
            "O1: 9♠\n"
            +
            "O2: 6♥\n"
            +
            "O3: 7♠\n"
            +
            "O4: Q♥\n"
            +
            "O5: 10♠\n"
            +
            "O6: J♠\n"
            +
            "C1: A♣, 9♣, 4♦, Q♦, 7♥\n"
            +
            "C2: 2♣, 10♣, 5♦, K♦, 8♥\n"
            +
            "C3: 3♣, J♣, 6♦, A♥, 9♥, 4♠, Q♠\n"
            +
            "C4: 4♣, Q♣, 7♦, 2♥, 10♥, 5♠, K♠\n"
            +
            "C5: 5♣, K♣, 8♦, 3♥, J♥, 6♠\n"
            +
            "C6: 6♣, A♦, 9♦, 4♥, 3♠\n"
            +
            "C7: 7♣, 2♦, 10♦, 5♥, K♥, 8♠\n"
            +
            "C8: 8♣, 3♦, J♦\n"
            +
            "F1:\n"
            +
            "F2: A♠, 2♠\n"
            +
            "F3:\n"
            +
            "F4:\n"
            +
            "O1: 9♠\n"
            +
            "O2: 6♥\n"
            +
            "O3: 7♠\n"
            +
            "O4: Q♥\n"
            +
            "O5: 10♠\n"
            +
            "O6: J♠\n"
            +
            "C1: A♣, 9♣, 4♦, Q♦\n"
            +
            "C2: 2♣, 10♣, 5♦, K♦, 8♥\n"
            +
            "C3: 3♣, J♣, 6♦, A♥, 9♥, 4♠, Q♠\n"
            +
            "C4: 4♣, Q♣, 7♦, 2♥, 10♥, 5♠, K♠\n"
            +
            "C5: 5♣, K♣, 8♦, 3♥, J♥, 6♠\n"
            +
            "C6: 6♣, A♦, 9♦, 4♥, 3♠\n"
            +
            "C7: 7♣, 2♦, 10♦, 5♥, K♥, 8♠, 7♥\n"
            +
            "C8: 8♣, 3♦, J♦\n"
            +
            "Game quit prematurely.";
    assertEquals(out.toString(), out1);
  }


}