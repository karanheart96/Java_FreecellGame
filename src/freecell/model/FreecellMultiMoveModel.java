package freecell.model;

import java.util.ArrayList;
import java.util.List;

public class FreecellMultiMoveModel extends FreecellModel {
  /**
   * Constructor to intialize a Freecellmodel.
   *
   * @param openpile       Open pile list from builder.
   * @param cascadepile    Cascade pile list from builder.
   * @param foundationpile Foundation Pile list from builder.
   * @param cascades       The total number of cascade.
   * @param opens          The total number of open piles.
   */
  public FreecellMultiMoveModel(List<Pile> openpile, List<Pile> cascadepile,
                                List<Pile> foundationpile, int cascades, int opens) {
    super(openpile, cascadepile, foundationpile, cascades, opens);
  }

  @Override
  public void move(PileType source, int pileNumber, int cardIndex, PileType destination,
                   int destPileNumber) throws IllegalArgumentException, IllegalStateException {
    int fromval;
    int toval;
    int n = 0;
    int k = 0;
    int build = 0;
    int opensize;
    int cascadesize;
    int fromsize;
    int preval;
    Cardcolor prevcol;
    int curval;
    Cardcolor curcol;
    Cardcolor fromcolor;
    Cardcolor tocolor;
    Card from;
    List<Card> temp = new ArrayList<>();
    if (source == null || destination == null) {
      throw new IllegalArgumentException("Null input");
    }
    if (gamestart == 0) {
      throw new IllegalStateException("Game not started");
    }
    if (pileNumber < 0 || destPileNumber < 0 || cardIndex < 0) {
      throw new IllegalArgumentException("Negative input in move");
    }
    if (source == PileType.CASCADE && destination == PileType.CASCADE) {
      if (pileNumber >= cascades || destPileNumber >= cascades) {
        throw new IllegalArgumentException("Move not possible");
      }
      fromsize = cascadepile.get(pileNumber).cardlist.size();
      if (fromsize == 0) {
        throw new IllegalArgumentException("Move not possible");
      }
      if (cardIndex > fromsize) {
        throw new IllegalArgumentException("Move not possible");
      }

      for (int i = cardIndex; i < fromsize; i++) {
        temp.add(cascadepile.get(pileNumber).cardlist.get(i));
      }
      for (int i = 0; i < opens; i++) {
        opensize = openpile.get(i).cardlist.size();
        if (opensize == 0) {
          n = n + 1;
        }
      }
      for (int i = 0; i < cascades; i++) {
        cascadesize = cascadepile.get(i).cardlist.size();
        if (cascadesize == 0) {
          k = k + 1;
        }
      }
      double valid = (n + 1) * Math.pow(2, k);
      if (valid < temp.size()) {
        throw new IllegalArgumentException("Move not possible");
      }
      for (int i = 1; i < temp.size(); i++) {
        preval = temp.get(i - 1).numericval;
        prevcol = temp.get(i - 1).color;
        curval = temp.get(i).numericval;
        curcol = temp.get(i).color;
        if (curval + 1 == preval && curcol != prevcol) {
          build += 1;
        }
      }
      if (build == temp.size() - 1) {
        if (cascadepile.get(destPileNumber).cardlist.size() != 0) {
          fromval = cascadepile.get(pileNumber).cardlist.get(cardIndex).numericval;
          fromcolor = cascadepile.get(pileNumber).cardlist.get(cardIndex).color;
          toval = cascadepile.get(destPileNumber).cardlist.get(cascadepile.get(destPileNumber)
                  .cardlist.size() - 1).numericval;
          tocolor = cascadepile.get(destPileNumber).cardlist.get(cascadepile.get(destPileNumber)
                  .cardlist.size() - 1).color;
          if (fromval + 1 == toval && fromcolor != tocolor) {
            for (int i = cardIndex; i < fromsize; i++) {
              from = cascadepile.get(pileNumber).cardlist.get(cardIndex);
              cascadepile.get(destPileNumber).cardlist.add(from);
              cascadepile.get(pileNumber).cardlist.remove(cardIndex);
            }
          } else {
            throw new IllegalArgumentException("Move not possible");
          }
        } else {
          for (int i = cardIndex; i < fromsize; i++) {
            from = cascadepile.get(pileNumber).cardlist.get(cardIndex);
            cascadepile.get(destPileNumber).cardlist.add(from);
            cascadepile.get(pileNumber).cardlist.remove(cardIndex);
          }
        }
      } else {
        throw new IllegalArgumentException("Move not possible");
      }
    } else if (source == PileType.CASCADE && destination == PileType.FOUNDATION) {
      super.move(source, pileNumber, cardIndex, destination,
              destPileNumber);
    } else if (source == PileType.CASCADE && destination == PileType.OPEN) {
      super.move(source, pileNumber, cardIndex, destination,
              destPileNumber);
    } else if (source == PileType.FOUNDATION && destination == PileType.CASCADE) {
      super.move(source, pileNumber, cardIndex, destination,
              destPileNumber);
    } else if (source == PileType.FOUNDATION && destination == PileType.OPEN) {
      super.move(source, pileNumber, cardIndex, destination,
              destPileNumber);
    } else if (source == PileType.FOUNDATION && destination == PileType.FOUNDATION) {
      super.move(source, pileNumber, cardIndex, destination,
              destPileNumber);
    } else if (source == PileType.OPEN && destination == PileType.CASCADE) {
      super.move(source, pileNumber, cardIndex, destination,
              destPileNumber);
    } else if (source == PileType.OPEN && destination == PileType.FOUNDATION) {
      super.move(source, pileNumber, cardIndex, destination,
              destPileNumber);
    } else if (source == PileType.OPEN && destination == PileType.OPEN) {
      super.move(source, pileNumber, cardIndex, destination,
              destPileNumber);
    }
  }

  public static Builder getBuilder() {
    return new MultiBuilder();
  }

}



