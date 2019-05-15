package freecell.model;

import java.util.ArrayList;
import java.util.List;

public class Builder implements FreecellOperationsBuilder {
  List<Pile> openpile;
  List<Pile> cascadepile;
  List<Pile> foundationpile;
  int cascades;
  int opens;

  /**
   * The constructor to initialize the default values of cascade, open and foundation piles.
   */
  Builder() {
    this.opens(4).cascades(8);
    this.foundationpile = new ArrayList<Pile>();
    for (int i = 0; i < 4; i++) {
      this.foundationpile.add(new Pile(new ArrayList<Card>(), PileType.FOUNDATION));
    }

  }

  @Override
  public FreecellOperationsBuilder cascades(int c) {
    this.cascadepile = new ArrayList<Pile>();
    if (c < 4) {
      throw new IllegalArgumentException();
    }
    for (int i = 0; i < c; i++) {
      this.cascadepile.add(new Pile(new ArrayList<Card>(), PileType.CASCADE));
    }
    this.cascades = c;
    return this;
  }

  @Override
  public FreecellOperationsBuilder opens(int o) {
    this.openpile = new ArrayList<Pile>();
    if (o < 1) {
      throw new IllegalArgumentException();
    }
    for (int i = 0; i < o; i++) {
      this.openpile.add(new Pile(new ArrayList<Card>(), PileType.OPEN));
    }
    this.opens = o;
    return this;
  }

  @Override
  public <Card> FreecellOperations<Card> build() {
    return (FreecellOperations<Card>) new FreecellModel(openpile, cascadepile, foundationpile,
            cascades, opens);
  }
}
