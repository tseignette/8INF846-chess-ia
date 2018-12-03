package chess;

import java.util.ArrayList;

import chess.Move;

public class MoveArrayList extends ArrayList<Move> {

  // Override of add method in ArrayList
  // Allows to check move destination and not add those whose
  // row and/or column are out of chessboard
  public boolean add(Move m) {
    int row = m.getRowTo();
    int column = m.getColumnTo();

    if(
      row < 0 ||
      row > 7 ||
      column < 0 ||
      column > 7
    )
      return false;

    return super.add(m);
  }

}
