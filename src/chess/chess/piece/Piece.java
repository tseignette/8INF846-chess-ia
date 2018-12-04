package chess.piece;

import chess.AI;

public abstract class Piece {

  // ===============================================================================================
  // ATTRIBUTES
  // ===============================================================================================
  private int owner = AI.WHITE;
  private int row, column;


  // ===============================================================================================
  // PUBLIC METHODS
  // ===============================================================================================
  public Piece setOwner(int owner) {
    this.owner = owner;

    return this;
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

}
