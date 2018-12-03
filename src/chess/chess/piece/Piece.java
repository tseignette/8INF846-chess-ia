package chess.piece;

import chess.AI;
import chess.Chessboard;
import chess.MoveArrayList;

public abstract class Piece {

  // ===============================================================================================
  // ATTRIBUTES
  // ===============================================================================================
  private int owner = AI.WHITE;
  private int row, column;


  // ===============================================================================================
  // PROTECTED METHODS
  // ===============================================================================================
  protected abstract void computePossibleMoves(Chessboard board, MoveArrayList possibleMoves);


  // ===============================================================================================
  // PUBLIC METHODS
  // ===============================================================================================
  public Piece setOwner(int owner) {
    this.owner = owner;

    return this;
  }

  public int getOwner() {
    return this.owner;
  }

  public Piece setPosition(int row, int column) {
    this.row = row;
    this.column = column;

    return this;
  }

  public int getRow() {
    return this.row;
  }

  public int getColumn() {
    return this.column;
  }

  public void getPossibleMoves(Chessboard board, MoveArrayList possibleMoves) {
    if (this.row == Chessboard.CEMETERY && this.column == Chessboard.CEMETERY)
      return;

    this.computePossibleMoves(board, possibleMoves);
  }

}
