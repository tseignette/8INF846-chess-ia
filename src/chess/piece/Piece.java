package chess.piece;

import chess.AI;

public abstract class Piece {

  // ===============================================================================================
  // ATTRIBUTES
  // ===============================================================================================
  private int owner = AI.BLACK;


  // ===============================================================================================
  // PUBLIC METHODS
  // ===============================================================================================
  public Piece setOwner(int owner) {
    this.owner = owner;

    return this;
  }

}
