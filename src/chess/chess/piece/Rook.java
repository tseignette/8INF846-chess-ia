package chess.piece;

import chess.Chessboard;
import chess.Move;
import chess.MoveArrayList;

public class Rook extends Piece {

  // Note: this function is also used to compute queen moves so compute the castling
  // move in the king move generation function
  protected void computePossibleMoves(Chessboard board, MoveArrayList possibleMoves) {
	int row = this.getRow();
	int column = this.getColumn();
	// Defining all moves
	for ( int i = 1; i < 8 ; i++ ) {
		int moveRow = row + i ;
		// Movement moves
			
	    // If there is not another friendly piece , we add the move
		// If there is a friendly piece, we stop the progression in this direction
	    if ( board.getPiece(moveRow, column) == null ) {
		  possibleMoves.add(new Move(row, column, moveRow, column));
		}
		else if(board.getPiece(moveRow, column) != null ) {
			if(board.getPiece(moveRow, column).getOwner() != this.getOwner()) {
				 possibleMoves.add(new Move(row, column, moveRow, column));
				 break;
			} else break;
		 
		}
	 }
	for ( int i = 1; i < 8 ; i++ ) {
		int moveRow = row - i ;
		// Movement moves
			
	    // If there is not another friendly piece , we add the move
		// If there is a friendly piece, we stop the progression in this direction
	    if ( board.getPiece(moveRow, column) == null ) {
		  possibleMoves.add(new Move(row, column, moveRow, column));
		}
		else if(board.getPiece(moveRow, column) != null ) {
			if(board.getPiece(moveRow, column).getOwner() != this.getOwner()) {
				 possibleMoves.add(new Move(row, column, moveRow, column));
				 break;
			} else break;
		 
		}
	}
	for ( int i = 1; i < 8 ; i++ ) {
		int moveColumn = column + i ;
		// Movement moves
			
	    // If there is not another friendly piece , we add the move
		// If there is a friendly piece, we stop the progression in this direction
	    if ( board.getPiece(row, moveColumn) == null ) {
		  possibleMoves.add(new Move(row, column, row, moveColumn));
		}
		else if(board.getPiece(row, moveColumn) != null ) {
			if(board.getPiece(row, moveColumn).getOwner() != this.getOwner()) {
				 possibleMoves.add(new Move(row, column, row, moveColumn));
				 break;
			} else break;
		 
		}
	}
	for ( int i = 1; i < 8 ; i++ ) {
		int moveColumn = column - i ;
		// Movement moves
			
	    // If there is not another friendly piece , we add the move
		// If there is a friendly piece, we stop the progression in this direction
	    if ( board.getPiece(row, moveColumn) == null ) {
		  possibleMoves.add(new Move(row, column, row, moveColumn));
		}
		else if(board.getPiece(row, moveColumn) != null ) {
			if(board.getPiece(row, moveColumn).getOwner() != this.getOwner()) {
				 possibleMoves.add(new Move(row, column, row, moveColumn));
				 break;
			} else break;
		 
		}
	 }
  }

}