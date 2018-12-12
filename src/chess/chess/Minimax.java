package chess;

import chess.piece.Piece;

public class Minimax {

  private int depth = 2;

  // ===============================================================================================
  // PRIVATE METHODS
  // ===============================================================================================
  private Double evaluate(Chessboard chessboard, int color) {
    // TODO: real evaluation (with different evaluation if game is over)
    return 1.0;
  }

  private Double minValue(Chessboard chessboard, int color, int depth) {
    if (depth == 0)
      return this.evaluate(chessboard, color);

    depth--;

    if (chessboard.isGameOver())
      return this.evaluate(chessboard, color);

    Piece[] myPieces = chessboard.getMyPieces(color);
    MoveArrayList possibleMoves = new MoveArrayList();
    
    for (int i = 0; i < myPieces.length; i++) {
      myPieces[i].getPossibleMoves(chessboard, possibleMoves);
    }

    Double bestScore = Double.POSITIVE_INFINITY;

    for (int i = 0; i < possibleMoves.size(); i++) {
      Move move = possibleMoves.get(i);

      Chessboard clone = chessboard.clone();
      clone.makeMove(move);

      Double score = this.maxValue(clone, color, depth);

      if (score < bestScore)
        bestScore = score;
    }

    return bestScore;
  }

  private Double maxValue(Chessboard chessboard, int color, int depth) {
    if (depth == 0)
      return this.evaluate(chessboard, color);

    depth--;

    if (chessboard.isGameOver())
      return this.evaluate(chessboard, color);

    Piece[] myPieces = chessboard.getMyPieces(color);
    MoveArrayList possibleMoves = new MoveArrayList();
    
    for (int i = 0; i < myPieces.length; i++) {
      myPieces[i].getPossibleMoves(chessboard, possibleMoves);
    }

    Double bestScore = Double.NEGATIVE_INFINITY;

    for (int i = 0; i < possibleMoves.size(); i++) {
      Move move = possibleMoves.get(i);

      Chessboard clone = chessboard.clone();
      clone.makeMove(move);

      Double score = this.maxValue(clone, color, depth);

      if (score > bestScore)
        bestScore = score;
    }

    return bestScore;
  }


  // ===============================================================================================
  // PUBLIC METHODS
  // ===============================================================================================
  public Move getBestMove(Chessboard chessboard, int color) {
    Piece[] myPieces = chessboard.getMyPieces(color);
    MoveArrayList possibleMoves = new MoveArrayList();
    
    for (int i = 0; i < myPieces.length; i++) {
      myPieces[i].getPossibleMoves(chessboard, possibleMoves);
    }

    if (possibleMoves.size() == 0)
      return null;

    Move bestMove = possibleMoves.get(0);
    Double bestScore = Double.NEGATIVE_INFINITY;

    for (int i = 0; i < possibleMoves.size(); i++) {
      Move move = possibleMoves.get(i);

      Chessboard clone = chessboard.clone();
      clone.makeMove(move);

      Double score = this.minValue(clone, color, this.depth);

      if (score > bestScore) {
        bestMove = move;
        bestScore = score;
      }
    }

    return bestMove;
  }

}
