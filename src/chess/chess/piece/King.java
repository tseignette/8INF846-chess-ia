package chess.piece;

import chess.Chessboard;
import chess.Move;
import chess.MoveArrayList;

public class King extends Piece {

  protected void computePossibleMoves(Chessboard board, MoveArrayList possibleMoves) {
    int row = this.getRow();
    int column = this.getColumn();

    for (int i = -1; i < 2; i++) {
      for (int j = -1; j < 2; j++) {
        if(i == 0 && j == 0)
          continue;

        Piece targetPiece = board.getPiece(row + i, column + j);
        // If there is no piece or it is an opponent piece
        if (
          targetPiece == null ||
          targetPiece.getOwner() != this.getOwner()
        )
          possibleMoves.add(new Move(row, column, row + i, column + j));
      }
    }
  }

  public Double getValue() {
		return 900.0;
  }

}
