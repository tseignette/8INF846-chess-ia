package chess;

import chess.piece.*;

public class Chessboard {

  // ===============================================================================================
  // ATTRIBUTES
  // ===============================================================================================
  private Piece[][] board; // board[i][j] where i is the row and j the column


  // ===============================================================================================
  // CONSTRUCTOR
  // ===============================================================================================
  public Chessboard() {
    this.board = new Piece[8][8];

    // Black pieces
    this.board[0][0] = new Rook();
    this.board[0][1] = new Knight();
    this.board[0][2] = new Bishop();
    this.board[0][3] = new Queen();
    this.board[0][4] = new King();
    this.board[0][5] = new Bishop();
    this.board[0][6] = new Knight();
    this.board[0][7] = new Rook();

    for (int i = 0; i < 8; i++) {
      this.board[1][i] = new Pawn();
    }

    // White pieces
    this.board[7][0] = new Rook().setOwner(AI.WHITE);
    this.board[7][1] = new Knight().setOwner(AI.WHITE);
    this.board[7][2] = new Bishop().setOwner(AI.WHITE);
    this.board[7][3] = new Queen().setOwner(AI.WHITE);
    this.board[7][4] = new King().setOwner(AI.WHITE);
    this.board[7][5] = new Bishop().setOwner(AI.WHITE);
    this.board[7][6] = new Knight().setOwner(AI.WHITE);
    this.board[7][7] = new Rook().setOwner(AI.WHITE);

    for (int i = 0; i < 8; i++) {
      this.board[6][i] = new Pawn().setOwner(AI.WHITE);
    }
  }


  // ===============================================================================================
  // PUBLIC METHODS
  // ===============================================================================================
  public void makeMove(Move move) {
    Piece tmp = this.board[move.getRowFrom()][move.getColumnFrom()];
    this.board[move.getRowFrom()][move.getColumnFrom()] = this.board[move.getRowTo()][move.getColumnTo()];
    this.board[move.getRowTo()][move.getColumnTo()] = tmp;
  }

}
