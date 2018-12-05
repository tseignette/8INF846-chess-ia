package chess.piece;

import chess.Chessboard;
import chess.Move;
import chess.MoveArrayList;

public class Bishop extends Piece {

	// Note: this function is also used to compute queen moves
	protected void computePossibleMoves(Chessboard board, MoveArrayList possibleMoves) {
		int row = this.getRow();
		int column = this.getColumn();
		boolean diagoURBlocked = false;
		boolean diagoULBlocked = false;
		boolean diagoDRBlocked = false;
		boolean diagoDLBlocked = false;

		// Defining all moves
		for (int i = 1; i < 8; i++) {
			int moveRowUR = row - i;
			int moveColumnUR = column + i;
			int moveRowUL = row - i;
			int moveColumnUL = column - i;
			int moveRowDR = row + i;
			int moveColumnDR = column + i;
			int moveRowDL = row + i;
			int moveColumnDL = column - i;
			// Movement moves

			// If there is not another friendly piece , we add the move
			// If there is a friendly piece, we stop the progression in this direction
			if (!diagoURBlocked) {
				diagoURBlocked = verificationPossibleMove(board, possibleMoves, row, column, moveRowUR, moveColumnUR);
			}
			if (!diagoULBlocked) {
				diagoULBlocked = verificationPossibleMove(board, possibleMoves, row, column, moveRowUL, moveColumnUL);
			}
			if (!diagoDRBlocked) {
				diagoDRBlocked = verificationPossibleMove(board, possibleMoves, row, column, moveRowDR, moveColumnDR);
			}
			if (!diagoDLBlocked) {
				diagoDLBlocked = verificationPossibleMove(board, possibleMoves, row, column, moveRowDL, moveColumnDL);
			}
		}
	}

	protected boolean verificationPossibleMove(
		Chessboard board,
		MoveArrayList possibleMoves,
		int row,
		int column,
		int moveRow,
		int moveColumn
	) {
		if (board.getPiece(moveRow, moveColumn) == null) {
			possibleMoves.add(new Move(row, column, moveRow, moveColumn));
		} else if (board.getPiece(moveRow, moveColumn) != null) {
			if (board.getPiece(moveRow, moveColumn).getOwner() != this.getOwner()) {
				possibleMoves.add(new Move(row, column, moveRow, moveColumn));
				return true;
			} else
				return true;

		}
		return false;
	}

}