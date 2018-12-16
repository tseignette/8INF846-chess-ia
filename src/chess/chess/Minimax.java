package chess;

import chess.piece.*;

public class Minimax {

  // ===============================================================================================
  // CONSTANTS
  // ===============================================================================================
  public final static int BLACK = 1;
  public final static int WHITE = 0;

  private UCINotifier notifier = new UCINotifier();
  private int depth = 1;

  // ===============================================================================================
  // PRIVATE METHODS
  // ===============================================================================================
  private MoveArrayList getPossibleMoves(Chessboard chessboard, int color) {
    Piece[] myPieces = chessboard.getMyPieces(color);
    MoveArrayList possibleMoves = new MoveArrayList();

    for (int i = 0; i < myPieces.length; i++) {
      myPieces[i].getPossibleMoves(chessboard, possibleMoves);
    }

    return possibleMoves;
  }

  private Double evaluatePlayer(Chessboard chessboard, int color) {
    Double score = 0.0;
    Piece[] pieces = chessboard.getMyPieces(color);

    for (int i = 0; i < 16; i++) {
      score += (pieces[i].getRow() != Chessboard.CEMETERY) ? pieces[i].getValue() : 0.0;
    }

    return score;
  }

  private Double evaluate(Chessboard chessboard, int color) {
    if (chessboard.hasLost(color))
      return -1000000.0;

    if (chessboard.hasLost(AI.getOpponentColor(color)))
      return 1000000.0;

    Double whiteScore = this.evaluatePlayer(chessboard, AI.WHITE);
    Double blackScore = this.evaluatePlayer(chessboard, AI.BLACK);

    if (color == AI.WHITE)
      return whiteScore - blackScore;

    return blackScore - whiteScore;
  }

  private Double minValue(Chessboard chessboard, int color, int depth, long startTime, double alpha, double beta) {
    notifier.depthReached(depth).nodeLooked();

    if (depth == this.depth || chessboard.isGameOver())
      return this.evaluate(chessboard, color);

    MoveArrayList possibleMoves = this.getPossibleMoves(chessboard, AI.getOpponentColor(color));
    Double bestScore = Double.POSITIVE_INFINITY;

    for (int i = 0; i < possibleMoves.size(); i++) {
      Move move = possibleMoves.get(i);

      Chessboard clone = chessboard.clone();
      clone.makeMove(move);

      Double score = this.maxValue(clone, color, depth + 1, startTime, alpha, beta);
      bestScore = Math.min(bestScore, score);
      
      if (bestScore < alpha)
        return bestScore;
        
      beta = Math.min(beta, bestScore);  
      if(System.currentTimeMillis() - startTime >= 990) {
        break;
      }  
    }

    return bestScore;
  }

  private Double maxValue(Chessboard chessboard, int color, int depth, long startTime, double alpha, double beta) {
    notifier.depthReached(depth).nodeLooked();

    if (depth == this.depth || chessboard.isGameOver())
      return this.evaluate(chessboard, color);

    MoveArrayList possibleMoves = this.getPossibleMoves(chessboard, color);
    Double bestScore = Double.NEGATIVE_INFINITY;
    
    for (int i = 0; i < possibleMoves.size(); i++) {
      Move move = possibleMoves.get(i);

      Chessboard clone = chessboard.clone();
      clone.makeMove(move);

      Double score = this.minValue(clone, color, depth + 1, startTime, alpha, beta);
      bestScore = Math.max(score, bestScore);
      
      if (bestScore > beta)
        return bestScore;
        
      alpha = Math.max(alpha, bestScore);  
      if(System.currentTimeMillis() - startTime >= 990) {
        break;
      }
    }

    return bestScore;
  }


  // ===============================================================================================
  // PUBLIC METHODS
  // ===============================================================================================
  public Move getBestMove(Chessboard chessboard, int color, long startTime) {
    this.notifier.clear();
    
    this.depth = 1;

    MoveArrayList possibleMoves = this.getPossibleMoves(chessboard, color);
    Move bestMove = possibleMoves.get(0);
    Double bestScore = Double.NEGATIVE_INFINITY;
    Double alpha = Double.NEGATIVE_INFINITY;
    Double beta = Double.POSITIVE_INFINITY;

    while(System.currentTimeMillis() - startTime < 990) {
      for (int i = 0; i < possibleMoves.size(); i++) {
        Move move = possibleMoves.get(i);
        this.notifier.actualMove(move, i + 1);

        Chessboard clone = chessboard.clone();
        clone.makeMove(move);

        Double score = this.minValue(clone, color, 0, startTime, alpha, beta);

        if (score > bestScore) {
          bestMove = move;
          bestScore = score;
        }

        if(System.currentTimeMillis() - startTime >= 990)
          break;
      }

      this.depth++;
    }
    System.out.println("info string Time elapsed: " + (System.currentTimeMillis() - startTime) + "ms");
    this.notifier.sendNotification();
    return bestMove;
  }

}
