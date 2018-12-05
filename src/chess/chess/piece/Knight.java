package chess.piece;

import chess.AI;
import chess.Chessboard;
import chess.Move;
import chess.MoveArrayList;

public class Knight extends Piece {

  int options[][] = {{1,2},{2,1},{2,-1},{-1,2},{1,-2},{-1,-2},{-2,1},{-2,-1}};


  protected void computePossibleMoves(Chessboard board, MoveArrayList possibleMoves) {
	int row = this.getRow();
	int column = this.getColumn();

	// Defining all eight moves
	for ( int i = 0; i < options.length ; i++ ) {
		int moveRow = row + options[i][0] ;
		int moveColumn = column + options[i][1];
		// Movement moves
			
	    // If there is not another friendly piece , we add the move
	    if ( board.getPiece(moveRow, moveColumn) == null 
	    		|| (board.getPiece(moveRow, moveColumn) != null 
	    		&& board.getPiece(moveRow, moveColumn).getOwner() != this.getOwner() ) ) {
		  possibleMoves.add(new Move(row, column, moveRow, moveColumn));

		}
		
		
	}
  }
}


