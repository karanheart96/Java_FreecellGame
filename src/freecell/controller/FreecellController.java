package freecell.controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import freecell.model.FreecellOperations;
import freecell.model.PileType;

public class FreecellController implements IFreecellController {
  final Readable rd;
  final Appendable ap;
  LinkedList<String> inputs;
  int position;

  /**
   * The constructor of the FreecellController class.
   *
   * @param rd The readable object through which the move is passed.
   * @param ap The appendable object for printing the status of the game.
   */
  public FreecellController(Readable rd, Appendable ap) {
    if (rd == null || ap == null) {
      throw new IllegalArgumentException("INPUT OR OUTPUR NULL");
    }

    this.rd = rd;
    this.ap = ap;
    this.inputs = new LinkedList<String>();
    this.position = 0;

  }


  private boolean getPile(String word) {
    return (word.charAt(0) == 'O'
            || word.charAt(0) == 'F'
            || word.charAt(0) == 'C');
  }


  private boolean getCardIndex(String word) {

    try {
      int result = Integer.parseInt(word);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }

  }


  private String executeMove(FreecellOperations model) {
    int srcpile;
    int destpile;
    if (inputs.get(0).charAt(0) == 'C' && inputs.get(2).charAt(0) == 'F') {
      srcpile = Integer.parseInt(inputs.get(0).substring(1, inputs.get(0).length())) - 1;
      destpile = Integer.parseInt(inputs.get(2).substring(1, inputs.get(2).length())) - 1;
      int cardindex = Integer.parseInt(inputs.get(1)) - 1;
      try {
        model.move(PileType.CASCADE, srcpile, cardindex, PileType.FOUNDATION, destpile);
      } catch (IllegalArgumentException e) {
        return "Invalid move.";
      }
      return "Valid move.";
    }


    if (inputs.get(0).charAt(0) == 'C' && inputs.get(2).charAt(0) == 'C') {
      srcpile = Integer.parseInt(inputs.get(0).substring(1, inputs.get(0).length())) - 1;
      destpile = Integer.parseInt(inputs.get(2).substring(1, inputs.get(2).length())) - 1;
      int cardindex = Integer.parseInt(inputs.get(1)) - 1;
      try {
        model.move(PileType.CASCADE, srcpile, cardindex, PileType.CASCADE, destpile);
      } catch (IllegalArgumentException e) {
        return "Invalid move.";
      }
      return "Valid move.";
    }

    if (inputs.get(0).charAt(0) == 'C' && inputs.get(2).charAt(0) == 'O') {
      srcpile = Integer.parseInt(inputs.get(0).substring(1, inputs.get(0).length())) - 1;
      destpile = Integer.parseInt(inputs.get(2).substring(1, inputs.get(2).length())) - 1;
      int cardindex = Integer.parseInt(inputs.get(1)) - 1;
      try {
        model.move(PileType.CASCADE, srcpile, cardindex, PileType.OPEN, destpile);
      } catch (IllegalArgumentException e) {
        return "Invalid move.";
      }
      return "Valid move.";
    }

    if (inputs.get(0).charAt(0) == 'F' && inputs.get(2).charAt(0) == 'C') {
      srcpile = Integer.parseInt(inputs.get(0).substring(1, inputs.get(0).length())) - 1;
      destpile = Integer.parseInt(inputs.get(2).substring(1, inputs.get(2).length())) - 1;
      int cardindex = Integer.parseInt(inputs.get(1)) - 1;
      try {
        model.move(PileType.FOUNDATION, srcpile, cardindex, PileType.CASCADE, destpile);
      } catch (IllegalArgumentException e) {
        return "Invalid move.";
      }
      return "Valid move.";
    }

    if (inputs.get(0).charAt(0) == 'F' && inputs.get(2).charAt(0) == 'O') {
      srcpile = Integer.parseInt(inputs.get(0).substring(1, inputs.get(0).length())) - 1;
      destpile = Integer.parseInt(inputs.get(2).substring(1, inputs.get(2).length())) - 1;
      int cardindex = Integer.parseInt(inputs.get(1)) - 1;
      try {
        model.move(PileType.FOUNDATION, srcpile, cardindex, PileType.OPEN, destpile);
      } catch (IllegalArgumentException e) {
        return "Invalid move.";
      }
      return "Valid move.";
    }

    if (inputs.get(0).charAt(0) == 'F' && inputs.get(2).charAt(0) == 'F') {
      srcpile = Integer.parseInt(inputs.get(0).substring(1, inputs.get(0).length())) - 1;
      destpile = Integer.parseInt(inputs.get(2).substring(1, inputs.get(2).length())) - 1;
      int cardindex = Integer.parseInt(inputs.get(1)) - 1;
      try {
        model.move(PileType.FOUNDATION, srcpile, cardindex, PileType.FOUNDATION, destpile);
      } catch (IllegalArgumentException e) {
        return "Invalid move.";
      }
      return "Valid move.";
    }

    if (inputs.get(0).charAt(0) == 'O' && inputs.get(2).charAt(0) == 'C') {
      srcpile = Integer.parseInt(inputs.get(0).substring(1, inputs.get(0).length())) - 1;
      destpile = Integer.parseInt(inputs.get(2).substring(1, inputs.get(2).length())) - 1;
      int cardindex = Integer.parseInt(inputs.get(1)) - 1;
      try {
        model.move(PileType.OPEN, srcpile, cardindex, PileType.CASCADE, destpile);
      } catch (IllegalArgumentException e) {
        return "Invalid move.";
      }
      return "Valid move.";
    }

    if (inputs.get(0).charAt(0) == 'O' && inputs.get(2).charAt(0) == 'F') {
      srcpile = Integer.parseInt(inputs.get(0).substring(1, inputs.get(0).length())) - 1;
      destpile = Integer.parseInt(inputs.get(2).substring(1, inputs.get(2).length())) - 1;
      int cardindex = Integer.parseInt(inputs.get(1)) - 1;
      try {
        model.move(PileType.OPEN, srcpile, cardindex, PileType.FOUNDATION, destpile);
      } catch (IllegalArgumentException e) {
        return "Invalid move.";
      }
      return "Valid move.";
    }

    if (inputs.get(0).charAt(0) == 'O' && inputs.get(2).charAt(0) == 'O') {
      srcpile = Integer.parseInt(inputs.get(0).substring(1, inputs.get(0).length())) - 1;
      destpile = Integer.parseInt(inputs.get(2).substring(1, inputs.get(2).length())) - 1;
      int cardindex = Integer.parseInt(inputs.get(1)) - 1;
      try {
        model.move(PileType.OPEN, srcpile, cardindex, PileType.OPEN, destpile);
      } catch (IllegalArgumentException e) {
        return "Invalid move.";
      }
      return "Valid move.";
    }

    return "Invalid move.";


  }


  @Override
  public void playGame(List deck, FreecellOperations model, boolean shuffle)
          throws IllegalArgumentException, IllegalStateException {
    if (model == null || deck == null) {
      throw new IllegalArgumentException("Null deck or model");
    }
    try {
      model.startGame(deck, shuffle);
    } catch (IllegalArgumentException e) {
      throw new IllegalStateException();
    }
    try {
      ap.append(model.getGameState() + "\n");
    } catch (IOException e) {
      e.printStackTrace();
    }
    Scanner scan = new Scanner(this.rd);
    scan.useDelimiter("\\s+|\\n");
    String currentWord = "";
    int wordCount = 0;
    while (scan.hasNext()) {
      currentWord = scan.next();
      if (currentWord.equals("q")
              || currentWord.equals("Q")) {
        try {
          ap.append("Game quit prematurely.");
          return;
        } catch (IOException e) {
          e.printStackTrace();
        }
      }

      if (model.isGameOver()) {
        try {
          ap.append("Game over.");
          return;
        } catch (IOException e) {
          e.printStackTrace();
        }
      }

      if (this.position == 0) {
        if (this.getPile(currentWord)) {
          this.inputs.add(currentWord);
          this.position = 1;
          wordCount = wordCount + 1;
        } else {
          wordCount = wordCount + 1;
        }
      } else if (this.position == 1) {
        if (this.getCardIndex(currentWord)) {
          this.inputs.add(currentWord);
          this.position = 2;
          wordCount = wordCount + 1;
        } else {
          wordCount = wordCount + 1;
        }
      } else if (this.position == 2) {
        if (this.getPile(currentWord)) {
          this.inputs.add(currentWord);
          this.position = 0;
          wordCount = wordCount + 1;
          String result = executeMove(model);
          this.inputs.clear();
          if (result.equals("Invalid move.")) {
            try {
              ap.append("Invalid move. Try again.");
            } catch (IOException e) {
              e.printStackTrace();
            }
            try {
              ap.append("\n");
            } catch (IOException e) {
              e.printStackTrace();
            }


          } else {
            try {
              ap.append(model.getGameState()).append("\n");
            } catch (IOException e) {
              e.printStackTrace();
            }
          }
        }

      } else {
        wordCount = wordCount + 1;
      }
    }
    try {
      ap.append("Game over.");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}



