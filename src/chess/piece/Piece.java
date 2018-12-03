package chess.piece;

import java.util.ArrayList;

import chess.AI;
import chess.Chessboard;
import chess.Move;

public abstract class Piece {

  // ===============================================================================================
  // ATTRIBUTES
  // ===============================================================================================
  private int owner = AI.WHITE;
  private int row, column;


  // ===============================================================================================
  // PROTECTED METHODS
  // ===============================================================================================
  protected abstract ArrayList<Move> computePossibleMoves(Chessboard board);


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

  // TODO: create new class extending ArrayList and check every move added
  public ArrayList<Move> getPossibleMoves(Chessboard board) {
    if (this.row == Chessboard.CEMETERY && this.column == Chessboard.CEMETERY)
      return new ArrayList<Move>();

    return this.computePossibleMoves(board);
  }

}
