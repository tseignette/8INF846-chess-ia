package chess.piece;

import chess.AI;
import chess.Chessboard;
import chess.Move;
import chess.MoveArrayList;

public class Pawn extends Piece {

  protected void computePossibleMoves(Chessboard board, MoveArrayList possibleMoves) {
    int row = this.getRow();
    int column = this.getColumn();

    // Defining in front of him
    int frontRow = row - 1;
    int frontFrontRow = row - 2;
    if(this.getOwner() == AI.BLACK) {
      frontRow = row + 1;
      frontFrontRow = row + 2;
    }

    // Movement moves
    // If nothing in front of him
    if (board.getPiece(frontRow, column) == null) {
      possibleMoves.add(new Move(row, column, frontRow, column));

      // If first move and nothing two tiles in front of him
      if (
        (row == 1 || row == 6) &&
        (board.getPiece(frontFrontRow, column) == null)
      ) {
        possibleMoves.add(new Move(row, column, frontFrontRow, column));
      }
    }

    // Attack moves
    Piece leftFrontPiece = board.getPiece(frontRow, column - 1);
    Piece rightFrontPiece = board.getPiece(frontRow, column + 1);
    // If there is an opponent piece on the left
    if (
      leftFrontPiece != null &&
      leftFrontPiece.getOwner() != this.getOwner()
    )
      possibleMoves.add(new Move(row, column, frontRow, column - 1));

    // If there is an opponent piece on the right
    if (
      rightFrontPiece != null &&
      rightFrontPiece.getOwner() != this.getOwner()
    )
      possibleMoves.add(new Move(row, column, frontRow, column + 1));
  }

}
