package chess;

import java.util.ArrayList;
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
  public Move chooseBestMove() {
    Piece[] myPieces = this.chessboard.getMyPieces(this.color);
    ArrayList<Move> possibleMoves = new ArrayList<>();
    
    for (int i = 0; i < myPieces.length; i++) {
      possibleMoves.addAll(myPieces[i].getPossibleMoves(this.chessboard));
    }

    int random = new Random().nextInt(possibleMoves.size());
    Move randomMove = possibleMoves.get(random);

    this.chessboard.makeMove(randomMove);
    return randomMove;
  }

}
