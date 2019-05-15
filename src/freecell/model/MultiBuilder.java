package freecell.model;

public class MultiBuilder extends Builder {

  MultiBuilder() {
    super();
  }

  @Override
  public <Card> FreecellOperations<Card> build() {
    return (FreecellOperations<Card>) new FreecellMultiMoveModel(openpile, cascadepile,
            foundationpile, cascades, opens);
  }

}
