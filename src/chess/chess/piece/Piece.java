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
  // PUBLIC STATIC METHODS
  // ===============================================================================================
  public static Piece getPromotion(Piece p, Character promotion) {
    Piece newPiece = p;

    if (promotion == 'q')
      newPiece = new Queen();
    else if (promotion == 'n')
      newPiece = new Knight();
    else if (promotion == 'r')
      newPiece = new Rook();
    else if (promotion == 'b')
      newPiece = new Bishop();

    newPiece.setOwner(p.getOwner())
      .setPosition(p.getRow(), p.getColumn());

    return newPiece;
  }


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
