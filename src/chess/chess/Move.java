package chess;

import java.util.HashMap;
import java.util.Map;

public class Move {

  // ===============================================================================================
  // ATTRIBUTES
  // ===============================================================================================
  private int rowFrom, columnFrom; // From 0 to 7
  private int rowTo, columnTo; // From 0 to 7
  private Character promotionPiece; // The piece in which it is promoted (q, n, r or b)


  // ===============================================================================================
  // CONSTRUCTOR
  // ===============================================================================================
  public Move(int rowFrom, int columnFrom, int rowTo, int columnTo) {
    this.rowFrom = rowFrom;
    this.columnFrom = columnFrom;

    this.rowTo = rowTo;
    this.columnTo = columnTo;

    this.promotionPiece = null;
  }


  // ===============================================================================================
  // STATIC METHODS
  // ===============================================================================================
  public static String moveToUCI(Move move) {
    char[] a = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};

    String uci = "" + a[move.getColumnFrom()] +
      (8 - move.getRowFrom()) +
      a[move.getColumnTo()] +
      (8 - move.getRowTo());

    // If promotion
    if (move.getPromotion() != null)
      uci += move.getPromotion();

    return uci;
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

    Move m = new Move(
      8 - Integer.parseInt("" + move.charAt(1)),
      a.get(move.charAt(0)),
      8 - Integer.parseInt("" + move.charAt(3)),
      a.get(move.charAt(2))
    );

    // If promotion
    try {
      Character promotion = move.charAt(4);
      
      if (promotion == 'q' || promotion == 'n' || promotion == 'r' || promotion == 'b')
        m.setPromotion(promotion);
    }
    catch (Exception e) { }

    return m;
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

  public Move setPromotion(Character piece) {
    this.promotionPiece = piece;

    return this;
  }

  public Character getPromotion() {
    return this.promotionPiece;
  }

}
