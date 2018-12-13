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
  private int little_castling = 1;
  private int big_castling = 1;


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
    
    if (this.little_castling == 1) {
        Move little_castling;
        if ((this.color == WHITE) && (this.chessboard.getPiece(7,5) == null ) && (this.chessboard.getPiece(7,6) == null ) ) {
            little_castling = new Move(7,4,7,6);
            possibleMoves.add(little_castling);
        }
        else if((this.color == BLACK) && (this.chessboard.getPiece(0,5) == null ) && (this.chessboard.getPiece(0,6) == null )) {
            little_castling = new Move(0,4,0,6);
            possibleMoves.add(little_castling);
        }
    }
    
    if (this.big_castling == 1) {
        Move big_castling;
        if ((this.color == WHITE) && (this.chessboard.getPiece(7,3) == null ) && (this.chessboard.getPiece(7,2) == null ) && (this.chessboard.getPiece(7,1) == null )) {
            big_castling = new Move(7,4,7,2);
            possibleMoves.add(big_castling);
        }
        else if((this.color == BLACK) && (this.chessboard.getPiece(0,3) == null ) && (this.chessboard.getPiece(0,2) == null )&& (this.chessboard.getPiece(0,1) == null )) {
            big_castling = new Move(0,4,0,2);
            possibleMoves.add(big_castling);
        }
    }
    
    

    if (possibleMoves.size() == 0)
      return null;

    int random = new Random().nextInt(possibleMoves.size());
    Move randomMove = possibleMoves.get(random);
    
    if (this.little_castling == 1) {
        if ((this.color == WHITE) && (randomMove.getRowFrom() == 1) && (randomMove.getColumnFrom() == 4 || randomMove.getColumnFrom() == 7))
            this.little_castling = 0;
        else if ((this.color == BLACK) && (randomMove.getRowFrom() == 7) && (randomMove.getColumnFrom() == 4 || randomMove.getColumnFrom() == 7))
            this.little_castling = 0;
    }
    
    if (this.big_castling == 1) {
        if ((this.color == WHITE) && (randomMove.getRowFrom() == 1) && (randomMove.getColumnFrom() == 4 || randomMove.getColumnFrom() == 0))
            this.big_castling = 0;
        else if ((this.color == BLACK) && (randomMove.getRowFrom() == 7) && (randomMove.getColumnFrom() == 4 || randomMove.getColumnFrom() == 0))
            this.big_castling = 0;
    }

    return randomMove;
  }

}
