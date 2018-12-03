import java.util.HashMap;
import java.util.Map;

public class Move {

  // ===============================================================================================
  // ATTRIBUTES
  // ===============================================================================================
  private int rowFrom, columnFrom; // From 0 to 7
  private int rowTo, columnTo; // From 0 to 7


  // ===============================================================================================
  // CONSTRUCTOR
  // ===============================================================================================
  public Move(int rowFrom, int columnFrom, int rowTo, int columnTo) {
    this.rowFrom = rowFrom;
    this.columnFrom = columnFrom;

    this.rowTo = rowTo;
    this.columnTo = columnTo;
  }


  // ===============================================================================================
  // STATIC METHODS
  // ===============================================================================================
  public static String moveToUCI(Move move) {
    char[] a = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};

    return "" + a[move.getColumnFrom()] +
      (8 - move.getRowFrom()) +
      a[move.getColumnTo()] +
      (8 - move.getRowTo());
  }

  public static Move UCIToMove(String move) {
    Map<Character, Integer> a = new HashMap<Character, Integer>();
    a.put('a', 0);
    a.put('b', 1);
    a.put('c', 2);
    a.put('d', 3);
    a.put('e', 4);
    a.put('f', 5);
    a.put('g', 6);
    a.put('h', 7);

    return new Move(
      8 - Integer.parseInt(""+move.charAt(1)),
      a.get(move.charAt(0)),
      8 - Integer.parseInt(""+move.charAt(3)),
      a.get(move.charAt(2))
    );
  }


  // ===============================================================================================
  // GETTERS
  // ===============================================================================================
  public int getRowFrom() {
    return this.rowFrom;
  }

  public int getColumnFrom() {
    return this.columnFrom;
  }

  public int getRowTo() {
    return this.rowTo;
  }

  public int getColumnTo() {
    return this.columnTo;
  }

}
