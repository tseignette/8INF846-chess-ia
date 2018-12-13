package chess;

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
  private Minimax minimax;
  private int color = BLACK;



  // ===============================================================================================
  // CONSTRUCTOR
  // ===============================================================================================
  public AI(Chessboard chessboard) {
    this.chessboard = chessboard;
    this.minimax = new Minimax();
  }


  // ===============================================================================================
  // PUBLIC STATIC METHODS
  // ===============================================================================================
  public static int getOpponentColor(int color) {
    return (color == AI.WHITE) ? AI.BLACK : AI.WHITE;
  }


  // ===============================================================================================
  // PUBLIC METHODS
  // ===============================================================================================
  public void setColor(int color) {
    this.color = color;
  }

  // Minimax with alpha-beta pruning
  // Returns a Move if one has been found, null otherwise
  public Move chooseBestMove(long startTime) {

    Move bestMove = this.minimax.getBestMove(this.chessboard, this.color, startTime);

    // if (this.chessboard.getLittleCastling() == 1) {
    //     if ((this.color == WHITE) && (bestMove.getRowFrom() == 1) && (bestMove.getColumnFrom() == 4 || bestMove.getColumnFrom() == 7))
    //         this.chessboard.setLittleCastling(0);
    //     else if ((this.color == BLACK) && (bestMove.getRowFrom() == 7) && (bestMove.getColumnFrom() == 4 || bestMove.getColumnFrom() == 7))
    //         this.chessboard.setLittleCastling(0);
    // }
    
    // if (this.chessboard.getBigCastling() == 1) {
    //     if ((this.color == WHITE) && (bestMove.getRowFrom() == 1) && (bestMove.getColumnFrom() == 4 || bestMove.getColumnFrom() == 0))
    //         this.chessboard.setBigCastling(0);
    //     else if ((this.color == BLACK) && (bestMove.getRowFrom() == 7) && (bestMove.getColumnFrom() == 4 || bestMove.getColumnFrom() == 0))
    //         this.chessboard.setBigCastling(0);
    // }

    return bestMove;
  }

}
