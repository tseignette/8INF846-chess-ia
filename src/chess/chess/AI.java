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
  private int color = WHITE;


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
  public Move chooseBestMove() {
    return(this.minimax.getBestMove(this.chessboard, this.color));
  }

}
