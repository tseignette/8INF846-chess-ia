package chess.piece;

import chess.Chessboard;
import chess.MoveArrayList;

public class Queen extends Piece {

  private Rook rook = new Rook();
  private Bishop bishop = new Bishop();

  // Queen moves are rook moves + bishop moves so we use their functions
  protected void computePossibleMoves(Chessboard board, MoveArrayList possibleMoves) {
    this.rook.computePossibleMoves(board, possibleMoves);
    this.bishop.computePossibleMoves(board, possibleMoves);
  }

  public Piece setOwner(int owner) {
    super.setOwner(owner);
    this.rook.setOwner(owner);
    this.bishop.setOwner(owner);

    return this;
  }

  public Piece setPosition(int row, int column) {
    super.setPosition(row, column);
    this.rook.setPosition(row, column);
    this.bishop.setPosition(row, column);

    return this;
  }

}