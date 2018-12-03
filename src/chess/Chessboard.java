package chess;

import java.util.ArrayList;

import chess.piece.*;

public class Chessboard {

  // ===============================================================================================
  // CONSTANTS
  // ===============================================================================================
  public final static int CEMETERY = -1;


  // ===============================================================================================
  // ATTRIBUTES
  // ===============================================================================================
  private Piece[][] board; // board[i][j] where i is the row and j the column
  private ArrayList<Piece> cemetery;
  private Piece[] whitePieces; // allows faster access to white pieces
  private Piece[] blackPieces; // allows faster access to black pieces


  // ===============================================================================================
  // CONSTRUCTOR
  // ===============================================================================================
  public Chessboard() {
    this.board = new Piece[8][8];
    this.whitePieces = new Piece[16];
    this.blackPieces = new Piece[16];

    // Black pieces
    this.board[0][0] = new Rook().setPosition(0, 0).setOwner(AI.BLACK);
    this.board[0][1] = new Knight().setPosition(0, 1).setOwner(AI.BLACK);
    this.board[0][2] = new Bishop().setPosition(0, 2).setOwner(AI.BLACK);
    this.board[0][3] = new Queen().setPosition(0, 3).setOwner(AI.BLACK);
    this.board[0][4] = new King().setPosition(0, 4).setOwner(AI.BLACK);
    this.board[0][5] = new Bishop().setPosition(0, 5).setOwner(AI.BLACK);
    this.board[0][6] = new Knight().setPosition(0, 6).setOwner(AI.BLACK);
    this.board[0][7] = new Rook().setPosition(0, 7).setOwner(AI.BLACK);

    for (int i = 0; i < 8; i++) {
      this.board[1][i] = new Pawn().setPosition(1, i).setOwner(AI.BLACK);

      this.blackPieces[2 * i] = this.board[0][i];
      this.blackPieces[2 * i + 1] = this.board[1][i];
    }

    // White pieces
    this.board[7][0] = new Rook().setPosition(7, 0);
    this.board[7][1] = new Knight().setPosition(7, 1);
    this.board[7][2] = new Bishop().setPosition(7, 2);
    this.board[7][3] = new Queen().setPosition(7, 3);
    this.board[7][4] = new King().setPosition(7, 4);
    this.board[7][5] = new Bishop().setPosition(7, 5);
    this.board[7][6] = new Knight().setPosition(7, 6);
    this.board[7][7] = new Rook().setPosition(7, 7);

    for (int i = 0; i < 8; i++) {
      this.board[6][i] = new Pawn().setPosition(6, i);

      this.whitePieces[2 * i] = this.board[7][i];
      this.whitePieces[2 * i + 1] = this.board[6][i];
    }
  }


  // ===============================================================================================
  // PUBLIC METHODS
  // ===============================================================================================
  public void makeMove(Move move) {
    int rowFrom = move.getRowFrom();
    int columnFrom = move.getColumnFrom();
    int rowTo = move.getRowTo();
    int columnTo = move.getColumnTo();

    Piece pieceFrom = this.board[rowFrom][columnFrom];
    Piece pieceTo = this.board[rowTo][columnTo];

    // If there is a piece on the destination, put it in the cemetery
    if(pieceTo != null) {
      this.cemetery.add(pieceTo);
      pieceTo.setPosition(CEMETERY, CEMETERY);
    }

    // Set new piece position
    pieceFrom.setPosition(rowTo, columnTo);
    this.board[rowTo][columnTo] = pieceFrom;
    this.board[rowFrom][columnFrom] = null;
  }

  public Piece[] getMyPieces(int playerColor) {
    if (playerColor == AI.WHITE) return this.whitePieces;
    return this.blackPieces;
  }

}
