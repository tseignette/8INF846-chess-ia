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
  private int color = BLACK;


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
    // TODO: implement
    return new Move(6, 0, 5, 0);
  }

}
