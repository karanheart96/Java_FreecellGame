package freecell.model;

public interface FreecellOperationsBuilder {
  /**
   * Method to overwrite the default number of cascades.
   *
   * @param c The number of cascades we desire.
   * @return The new builder Object.
   */
  FreecellOperationsBuilder cascades(int c);

  /**
   * Method to overwrite the default number of open piles.
   *
   * @param o The number of opens we desire.
   * @return The new builder Object.
   */
  FreecellOperationsBuilder opens(int o);

  /**
   * Method to return a FreecellOperation Object
   *
   * @param <K> A generic type.
   * @return FreecellOperation Object.
   */
  <K> FreecellOperations<K> build();
}
