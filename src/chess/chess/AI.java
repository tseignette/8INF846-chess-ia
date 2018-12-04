package chess;

import java.util.Random;

import chess.piece.Piece;

public class AI {

  // ===============================================================================================
  // CONSTANTS
  // ===============================================================================================
  public final static int BLACK = 1;
  public final static int WHITE = 0;


  // ===============================================================================================
  // ATTRIBUTES
  // ===============================================================================================
  private Chessboard chessboard;
  private int color = WHITE;


  // ===============================================================================================
  // CONSTRUCTOR
  // ===============================================================================================
  public AI(Chessboard chessboard) {
    this.chessboard = chessboard;
  }


  // ===============================================================================================
  // PUBLIC METHODS
  // ===============================================================================================
  public void setColor(int color) {
    this.color = color;
  }

  // Minimax with alpha-beta pruning
  // Returns a Move if one has been found, null otherwise
  public Move chooseBestMove() {
    Piece[] myPieces = this.chessboard.getMyPieces(this.color);
    MoveArrayList possibleMoves = new MoveArrayList();
    
    for (int i = 0; i < myPieces.length; i++) {
      myPieces[i].getPossibleMoves(this.chessboard, possibleMoves);
    }

    if (possibleMoves.size() == 0)
      return null;

    int random = new Random().nextInt(possibleMoves.size());
    Move randomMove = possibleMoves.get(random);

    return randomMove;
  }

}
